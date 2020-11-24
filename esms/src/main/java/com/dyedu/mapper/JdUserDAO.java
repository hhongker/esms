package com.dyedu.mapper;

import com.dyedu.bean.JdUser;
import org.apache.ibatis.annotations.Param;

public interface JdUserDAO {
    JdUser findJdUser(@Param("login_name") String  login_name,
                      @Param("password") String password);
    int    insertJdUser(JdUser  user);
}
