package com.MyBank.service;

import com.MyBank.pojo.Transfer;
import com.MyBank.pojo.User;
import com.MyBank.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    /**
     *
     * @param str1 用户名
     * @param str2 密码
     * @return
     */
    public User findNameAndCord(String str1, String str2) {
        UserDao userDao = new UserDao();
        return userDao.findNameAndCord(str1, str2);
    }

    /**
     *
     * @param str1 账号
     * @param str2 卡号
     * @param str3 身份证号
     * @return
     */
    public User findIdAndNumberAndAcount(String str1, String str2, String str3) {
        UserDao userDao = new UserDao();
        return userDao.findIdAndNumberAndAcount(str1, str2, str3);
    }

    public int Insert(User user) {
        UserDao userDao = new UserDao();
        return userDao.Insert(user);
    }

    public User findPayment(String str2) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.findPayment(str2);
    }

    public User findCount(String str2) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.findCount(str2);
    }

    public boolean UpdateBlance(User user) {
        UserDao userDao = new UserDao();
        if (userDao.UpdateBlance(user) == 0)
            return false;
        else
            return true;
    }

    public boolean UpdateCord(User user) {
        UserDao userDao = new UserDao();
        if (userDao.UpdateCord(user) == 0)
            return false;
        else
            return true;
    }

    public List findAll(String str) {
        FindAll findAllSql = new FindAll();
        List<Transfer> list = findAllSql.findAll(str);
        if (list == null)
            return null;
        else
            return list;
    }

    public int Insert1(Transfer tf) {
        TransferInsertSql insert = new TransferInsertSql();
        return insert.Insert1(tf);
    }

}
