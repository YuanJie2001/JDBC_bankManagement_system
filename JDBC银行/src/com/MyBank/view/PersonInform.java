package com.MyBank.view;

import com.MyBank.pojo.User;
import com.MyBank.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

//   存款页面
public class PersonInform extends JFrame {

    public void Homedposit(User user) {
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("存款");
        this.setSize(450,450);
        this.setLocationRelativeTo(null);

        JPanel c = (JPanel) this.getContentPane();
        c.setOpaque(false);
        this.setLayout(null);
        ImageIcon jpg = new ImageIcon("4.jpg");
        jpg.setImage(jpg.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
        JLabel s1 = new JLabel(jpg);
        s1.setBounds(0, 0, 450, 450);
        this.getLayeredPane().add(s1, new Integer(Integer.MIN_VALUE));

        JLabel m1 = new JLabel("存款");
        m1.setFont(new Font("宋体", Font.BOLD, 24));
        m1.setBounds(170, 0, 100, 40);
        JLabel m2 = new JLabel("存款金额");
        m2.setFont(new Font("宋体", Font.BOLD, 20));
        m2.setBounds(70, 70, 100, 40);
        JLabel m3 = new JLabel("支付密码");
        m3.setFont(new Font("宋体", Font.BOLD, 20));
        m3.setBounds(70, 140, 100, 40);
        JButton m4 = new JButton("取消");
        m4.setBounds(20, 313, 80, 40);
        m4.setFont(new Font("宋体", Font.BOLD, 15));
        JButton m5 = new JButton("确定");
        m5.setBounds(303, 313, 80, 40);
        m5.setFont(new Font("宋体", Font.BOLD, 15));
        JTextField m6 = new JTextField();
        m6.setBounds(200, 75, 150, 30);
        m6.setFont(new Font("宋体", Font.BOLD, 18));
        JPasswordField m7 = new JPasswordField();
        m7.setBounds(200, 145, 150, 30);
        m7.setFont(new Font("宋体", Font.BOLD, 18));
        this.add(m1);
        this.add(m2);
        this.add(m3);
        this.add(m4);
        this.add(m5);
        this.add(m6);
        this.add(m7);
        m4.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent arg0) {
                                     // TODO Auto-generated method stub
                                     setVisible(false);
                                 }

                             }

        );
        m5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //确定键
                double str1 = Double.parseDouble(m6.getText());
                String str2 = m7.getText();
                UserService userService = new UserService();
                User user2 = null;
                try {
                    user2 = userService.findPayment(str2);
                    if (user2 == null) {
                        JOptionPane.showMessageDialog(null, "支付密码不正确", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (str1 >= 0) {
                    double sum = str1 + user2.getBalance();
                    user2.setBalance(sum);
                    if (user2 != null && userService.UpdateBlance(user2) == true) {
                        JOptionPane.showMessageDialog(null, "存款成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "存款失败", "提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}