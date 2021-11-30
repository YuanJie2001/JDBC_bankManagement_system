package com.MyBank.dao;

import com.MyBank.pojo.Administrator;
import com.MyBank.service.utils.BaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdministratorDao {
    //找到用户和密码
    public Administrator findNameAndCord(String str1, String str2) {
        String sql = "select *from administrator where Aname=? and Acord=?";
        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            return qr.query(sql, new BeanHandler<Administrator>(Administrator.class), str1, str2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //删除用户
    public int delectUser(String str1, String str2) {
        String sql = "delete from user  where user=? and acount=?";
        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            int update = qr.update(sql, str1, str2);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //更新姓名 账号 密码
    public int UpdateCord(String str1, String str2, String str3) {
        String sql = "update user set  acount=?,cord= ?where name=? ";
        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            int i = qr.update(sql, str2, str3, str1);
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
