package com.MyBank.dao;

import com.MyBank.pojo.User;
import com.MyBank.service.utils.BaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    //找到用户名和密码

    public User findNameAndCord(String str1,String str2) {
        String sql = "select * from user where name=? and password=?";

        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            return qr.query(sql, new BeanHandler<User>(User.class),str1,str2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //匹配 身份证号  银行卡号 账号
    public User findIdAndNumberAndAcount(String str1,String str2,String str3) {
        String sql = "select * from user where id=? and number=? and acount=?";

        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            return qr.query(sql, new BeanHandler<User>(User.class),str1,str2,str3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //找到匹配的账号
    public User findCount(String str) {
        String sql = "select * from user where acount = ?";

        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            return qr.query(sql, new BeanHandler<User>(User.class),str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //插入数据库
    public int Insert(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?)";
        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            return qr.update(sql,user.getName(),user.getPassword(),user.getId(),user.getNumber(),user.getPayment(),user.getPhone(),user.getBalance(),user.getAcount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //找到相配的密码
    public User findPayment(String str) throws SQLException {
        String sql = "select * from user where payment= ? ";
        QueryRunner qr = BaseUtils.getQueryRunner();
        User user1= qr.query(sql, new BeanHandler<User>(User.class),str);
        System.out.println(user1);
        return user1;
    }

    //更新余额
    public int UpdateBlance(User user) {
        String sql = "update user set balance=? where acount = ?";
        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            int i =qr.update(sql,user.getBalance(),user.getAcount());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //更新密码
    public int UpdateCord(User user) {
        String sql = "update user set password=? where acount=?";
        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            int i =qr.update(sql,user.getPassword(),user.getAcount());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
