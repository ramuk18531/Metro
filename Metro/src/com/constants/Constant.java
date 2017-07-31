package com.constants;

public class Constant {
public static String VALIDATE_USER="select * from metrousers where username=? and password=?";
public static String UPDATE_USER="insert into metrousers values(?,?,?,?,?,?,?,?)";
}
