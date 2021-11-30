package com.MyBank.service;

import com.MyBank.pojo.Transfer;
import com.MyBank.pojo.User;
import com.MyBank.service.utils.BaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FindAll {
    //查询所有转账记录
    public List findAll(String str){
        Transfer transfer = null;
        String  sql = "select *from transfer where transfer_people";
        QueryRunner qr = BaseUtils.getQueryRunner();
        List<Transfer> List = null;
        BeanListHandler<Transfer> blhl = new BeanListHandler<>(Transfer.class);
        try {
            List = qr.query(sql, blhl ,str);
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询所有用户
    public List findAllUser() {
        User user = null;
        String sql = "select * from user";
        QueryRunner qr = BaseUtils.getQueryRunner();
        List<User>  List = null;
        BeanListHandler<User> blhl = new BeanListHandler<>(User.class);
        try {
            List = qr.query(sql, blhl);
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
