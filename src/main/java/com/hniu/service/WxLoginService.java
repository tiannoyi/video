package com.hniu.service;


import com.hniu.exception.SystemErrorException;

public interface WxLoginService  {

    String wxLogin(String code) throws SystemErrorException;
}
