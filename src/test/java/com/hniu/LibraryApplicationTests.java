package com.hniu;

import com.hniu.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {
    @Autowired
    RedisUtil re;

    @Test
    public void hello(){
        re.setObject("h2","v2");
        System.out.println(re.getObject("h2"));
    }

}
