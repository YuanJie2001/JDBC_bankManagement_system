package com.MyBank.view;
import java.util.List;
import com.MyBank.pojo.Transfer;
import com.MyBank.pojo.User;
import com.MyBank.service.UserService;

import javax.swing.*;
import java.awt.*;

public class BankSlip extends JFrame{

    public void bank_slip(User user) {
        Container c = this.getContentPane();
        this.setTitle("转账流水");
        this.setSize(800,300);
        this.setLocationRelativeTo(null);
        // 创建表格
        UserService uc = new UserService();
        List list = uc.findAll(user.getName());
        Object[][] obj = new Object[list.size()][5];
        String a = null;
        String b = null;
        double d = 0;
        String e = null;
        double f = 0;

        for (int i = 0; i < list.size(); i++) {
            Transfer flow = (Transfer) list.get(i);
            a = flow.getTransfer_people();
            System.out.println("*************");
            b = flow.getTransfer_object();
            d = flow.getTransfer_money();
            e = flow.getTransfer_data();
            f = flow.getMoney();
            for (int j = 0; j < 5; j++) {
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
                }
            }
        }
        String[] columnNames = { "转账人", "转账对象", "转账金额", "转账日期", "余额" };
        JTable j1 = new JTable(obj, columnNames);
        JScrollPane js = new JScrollPane();
        js.setViewportView(j1);
//        js.transferFocusUpCycle();
        c.add(js);
        this.setResizable(false);
        this.setVisible(true);
    }

}