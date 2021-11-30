package com.MyBank.view;


import com.MyBank.pojo.User;
import com.MyBank.service.FindAll;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class AdminSelect extends JDialog {

    public void a_select(){
        Container c = this.getContentPane();
        this.setTitle("查看用户");
        this.setSize(900,300);
        this.setLocationRelativeTo(null);
        //创建表格
        Object[][] obj = new Object[37][8];
        String a = null;
        String b = null;
        String d = null;
        String e = null;
        String f = null;
        String g = null;
        double h = 0.0;
        String n = null;
        FindAll uc = new FindAll();
        List list = uc.findAllUser();
        for (int i = 0; i < list.size(); i++) {
            User flow = (User) list.get(i);
            a = flow.getName();
            b = flow.getPassword();
            d = flow.getId();
            e = flow.getNumber();
            f = flow.getPayment();
            g = flow.getPhone();
            h = flow.getBalance();
            n = flow.getAcount();
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        obj[i][j] = a;
                        break;
                    case 1:
                        obj[i][j] =b;
                        break;
                    case 2:
                        obj[i][j] = d;
                        break;
                    case 3:
                        obj[i][j] = e;
                        break;
                    case 4:
                        obj[i][j] = f;
                        break;
                    case 5:
                        obj[i][j] = g;
                        break;
                    case 6:
                        obj[i][j] = h;
                        break;
                    case 7:
                        obj[i][j] = n;
                        break;
                }
            }
        }
        String[] columnNames = { "用户名", "密码", "身份证号", "卡号", "支付密码","电话号","余额","账号" };
        JTable j1 = new JTable(obj, columnNames);
        System.out.println(list);
        /**
         * 滚动面板插入文本域用到的方法
         */
        JScrollPane j2 = new JScrollPane();
        j2.setViewportView(j1);
        j2.transferFocusUpCycle();

        c.add(j2);
        this.setResizable(false);
        this.setVisible(true);
    }
}

