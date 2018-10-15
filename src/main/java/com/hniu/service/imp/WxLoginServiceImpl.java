package com.hniu.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hniu.entity.System;
import com.hniu.entity.User;
import com.hniu.entity.UserExample;
import com.hniu.exception.SystemErrorException;
import com.hniu.mapper.UserMapper;
import com.hniu.service.UserService;
import com.hniu.service.WxLoginService;
import com.hniu.util.EncryptUtil;
import com.hniu.util.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.validator.constraints.pl.REGON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class WxLoginServiceImpl implements WxLoginService {

    private static final Logger logger = LoggerFactory.getLogger(WxLoginServiceImpl.class);

    @Resource
    System system;

    RestTemplate restTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;


    @Resource
    UserMapper userMapper;

    /*@Autowired
    ReaderService rs;
*/
    public WxLoginServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String wxLogin(String code) throws SystemErrorException {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + system.getAppid() +
                "&secret=" + system.getAppsecret() +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        String uuid = null;
        logger.info("调用微信接口："+url);
        //根据code去微信服务器获取openid和sessionkey
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        logger.info("微信接口返回值："+entity.getBody());
        try {
            JsonNode jsonNode = objectMapper.readTree(entity.getBody());
            String errcode = jsonNode.findPath("errcode").toString();
            //解析返回的数据如果包含errcode就没能获取成功
            if (!StringUtils.isEmpty(errcode)) {
                throw new SystemErrorException("登录失败");
            } else {
                String session_key = jsonNode.findPath("session_key").toString().replace("\"", "");
                String openid = jsonNode.findPath("openid").toString().replace("\"", "");
                uuid = UUID.randomUUID().toString().replace("-", "");
                Subject subject = SecurityUtils.getSubject();
                //查询数据库是否有这个微信号登录过 --------------
               User user = userMapper.selectBywechat(openid);
                //Readers readers = rs.selectByWechat(openid);
                //没有就生成一个
                /*if(readers == null){
                    Calendar rightNow = Calendar.getInstance();
                    rightNow.setTime(new Date());
                    rightNow.add(Calendar.YEAR, 3);
                    Date time = rightNow.getTime();
                    readers = new Readers(1, 3, "微信用户", EncryptUtil.encryption("123",openid ).get("password"), openid, "","" , "", null,new Byte("0") , new Date(), time,new Byte("0"),new Byte("0"), "" ,"");
                    rs.insert(readers);
                    //将数据保存到redis
                    redisUtil.setObject(uuid,session_key+","+openid+","+readers.getReaderId(),3*24l);
                }*/
                if(user == null) {
                    //readers = new Readers(1, 3, "微信用户", EncryptUtil.encryption("123",openid ).get("password"), openid, "","" , "", null,new Byte("0") , new Date(), time,new Byte("0"),new Byte("0"), "" ,"");
                   user = new User(3, "微信用户", openid, EncryptUtil.encryption("123", openid).get("password"), "", "", "");
                    //rs.insert(readers);
                    user = userService.insertUser(user);
                }
                    //将数据保存到redis
                    //redisUtil.setObject(uuid,session_key+","+openid+","+readers.getReaderId(),3*24l);
                    redisUtil.setObject(uuid,session_key+","+openid+","+user.getUserId(),3*24l);

                //登录
                //subject.login(new UsernamePasswordToken(readers.getWechat(),readers.getPassword()));
                //subject.login(new UsernamePasswordToken(user.getWechat(),user.getPassword()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uuid;

    }
}
