package com.MyBank.view;

import com.MyBank.pojo.Transfer;
import com.MyBank.pojo.User;
import com.MyBank.service.TransferInsertSql;
import com.MyBank.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class homeTransfer extends JFrame {
    //转账
    public void Hometransfer(User user) {
        this.setTitle("转账");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        JPanel c = (JPanel)this.getContentPane();
        c.setOpaque(false);

        this.setLayout(null);

        ImageIcon jpg = new ImageIcon("2.jpg");
        jpg.setImage(jpg.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        JLabel a1 = new JLabel(jpg);
        a1.setBounds(0, 10, 500, 500);
        this.getLayeredPane().add(a1,new Integer(Integer.MIN_VALUE));

        JLabel j1 = new JLabel("转账");
        j1.setFont(new Font("宋体", Font.PLAIN, 24));
        j1.setBounds(170, 0, 100, 40);
        JLabel j2 = new JLabel("转账金额");
        j2.setFont(new Font("宋体", Font.PLAIN, 20));
        j2.setBounds(90, 70, 100, 40);
        JLabel j3 = new JLabel("目标账号");
        j3.setFont(new Font("宋体", Font.PLAIN, 20));
        j3.setBounds(90, 140, 100, 40);
        JLabel j4 = new JLabel("支付密码");
        j4.setFont(new Font("宋体", Font.PLAIN, 20));
        j4.setBounds(90, 210, 150, 40);
        JButton j5 = new JButton("取消");
        j5.setBounds(20, 313, 80, 40);
        j5.setFont(new Font("宋体", Font.PLAIN, 15));
        JButton j6 = new JButton("确定");
        j6.setBounds(303, 313, 80, 40);
        j6.setFont(new Font("宋体", Font.PLAIN, 15));
        JTextField j7 = new JTextField();
        j7.setBounds(200, 75, 150, 30);
        j7.setFont(new Font("宋体", Font.PLAIN, 18));
        JTextField j8 = new JTextField();
        j8.setBounds(200, 145, 150, 30);
        j8.setFont(new Font("宋体", Font.PLAIN, 18));
        JPasswordField j9 = new JPasswordField();
        j9.setBounds(200, 215, 150, 30);
        j9.setFont(new Font("宋体", Font.PLAIN, 18));
        this.add(j1);
        this.add(j2);
        this.add(j3);
        this.add(j4);
        this.add(j5);
        this.add(j6);
        this.add(j7);
        this.add(j8);
        this.add(j9);

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        this.setResizable(false);
        this.setVisible(true);

        j5.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent arg0) {
                                     // 取消按钮
                                     setVisible(false);
                                 }

                             }
        );
        j6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 确认键
                double str1 = Double.parseDouble(j7.getText());
                String str2 = j8.getText();
                String str3 = j9.getText();
                UserService userService = new UserService();
                User user2=null;
                try {
                    user2 = userService.findPayment(str3);
                    if(user2==null) {
                        JOptionPane.showMessageDialog(null, "支付密码不正确", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                double sum = user2.getBalance() - str1;
                user2.setBalance(sum);
                User user3 = null;
                try {
                    user3 = userService.findCount(str2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                double sum1 = user3.getBalance() + str1;
                user3.setBalance(sum1);
                if(j7.getText()!=null ||str1>=0){

                if (user2 != null && userService.UpdateBlance(user2)==true && userService.UpdateBlance(user3)==true) {
                    JOptionPane.showMessageDialog(null, "转账成功", "提示", JOptionPane.WARNING_MESSAGE);
                    Transfer transfer = new Transfer();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    /**
                     *     private String transfer_people;//转账人
                     *     private String transfer_object;//转账的对象
                     *     private double transfer_money;//转账数目
                     *     private String transfer_data;//转账日期
                     *     private double money;
                     */
                    transfer.setTransfer_people(user2.getName());
                    transfer.setTransfer_object(user3.getName());
                    transfer.setTransfer_money(str1);
                    transfer.setTransfer_data(df.format(new Date()));
                    transfer.setMoney(user2.getBalance());
                    TransferInsertSql tis = new TransferInsertSql();
                    tis.Insert1(transfer);
                    setVisible(false);
                }} else {
                    JOptionPane.showMessageDialog(null, "转账失败", "提示", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

    }
}