package com.chelp.oop.utils.constant;

/**
 * Created by Administrator on 2017/5/17.
 */
public class JwtConstant {

    public static final String JWT_ID = "jwt";
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    public static final int JWT_TTL = 24*60*60*1000;
    public static final  int APP_JWT_TTL = 24*60*60*1000*3650;
    public static final int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 24*60*60*1000;  //millisecond

}
