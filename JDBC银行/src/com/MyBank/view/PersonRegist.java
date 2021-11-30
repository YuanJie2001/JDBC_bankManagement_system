package com.MyBank.view;

import com.MyBank.pojo.User;
import com.MyBank.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * 添加用户功能实现
 * 触发注册弹窗功能实现一
 */
public class PersonRegist extends JFrame {
    User user = new User();

    public void RegisterDialog() {

        this.setTitle("注册");
        this.setSize(650,500);
        this.setLocationRelativeTo(null);
        JPanel c = (JPanel)this.getContentPane();
        c.setOpaque(false);
        this.setLayout(null);
        ImageIcon jpg = new ImageIcon("Image/4.jpg");
        jpg.setImage(jpg.getImage().getScaledInstance(650, 500, Image.SCALE_DEFAULT));
        JLabel s1 = new JLabel(jpg);
        s1.setBounds(0, 0, 650, 500);
        this.getLayeredPane().add(s1,new Integer(Integer.MIN_VALUE));
        JTextField name = new JTextField();

        name.setBounds(130, 55, 150, 30);
        name.setFont(new Font("宋体", Font.PLAIN, 18));

        JPasswordField password1 = new JPasswordField();

        password1.setBounds(130, 95, 150, 30);
        password1.setFont(new Font("宋体", Font.PLAIN, 18));
        JPasswordField password2 = new JPasswordField();

        password2.setFont(new Font("宋体", Font.PLAIN, 18));
        password2.setBounds(130, 140, 150, 30);
        JTextField IdCard = new JTextField();

        IdCard.setFont(new Font("宋体", Font.PLAIN, 18));
        IdCard.setBounds(130, 185, 150, 30);
        Random r = new Random();
        String str6 = "235154113"+r.nextInt(9)+r.nextInt(9);
        JLabel BankCard = new JLabel(str6);

        BankCard.setFont(new Font("宋体", Font.BOLD, 24));
        BankCard.setBounds(440, 55, 150, 30);
        BankCard.setForeground(Color.black);
        JPasswordField password3 = new JPasswordField();

        password3.setBounds(440, 95, 150, 30);
        password3.setFont(new Font("宋体", Font.PLAIN, 18));
        JTextField PhoneNumber = new JTextField();

        PhoneNumber.setFont(new Font("宋体", Font.PLAIN, 18));
        PhoneNumber.setBounds(440, 135, 150, 30);

        JButton m1 = new JButton("注册");
        m1.setBounds(10, 333, 60, 40);
        m1.setFont(new Font("宋体", Font.BOLD, 12));
        JButton m2 = new JButton("取消");
        m2.setBounds(572, 333, 60, 40);
        m2.setFont(new Font("宋体", Font.BOLD, 12));
        JRadioButton m3 = new JRadioButton("我已阅读服务条款");
        m3.setBounds(250, 275, 150, 40);
        m3.setFont(new Font("宋体", Font.BOLD, 12));
        JLabel a1 = new JLabel("姓名");
        a1.setForeground(Color.red);
        a1.setFont(new Font("宋体", Font.BOLD, 20));
        a1.setBounds(70, 30, 80, 80);
        JLabel a2 = new JLabel("密码");
        a2.setForeground(Color.red);
        a2.setFont(new Font("宋体", Font.BOLD, 20));
        a2.setBounds(70, 60, 100, 100);
        JLabel a3 = new JLabel("再次输入密码");
        a3.setForeground(Color.red);
        a3.setFont(new Font("宋体", Font.BOLD, 20));
        a3.setBounds(0, 105, 150, 100);
        JLabel a4 = new JLabel("身份证号");
        a4.setForeground(Color.red);
        a4.setFont(new Font("宋体", Font.BOLD, 20));
        a4.setBounds(41, 150, 100, 100);
        JLabel a5 = new JLabel("银行卡号");
        a5.setFont(new Font("宋体", Font.BOLD, 20));
        a5.setBounds(350, 20, 100, 100);
        JLabel a6 = new JLabel("支付密码");
        a6.setFont(new Font("宋体", Font.BOLD, 20));
        a6.setBounds(350, 60, 100, 100);
        JLabel a7 = new JLabel("  手机号");
        a7.setFont(new Font("宋体", Font.BOLD, 20));
        a7.setBounds(350, 100, 100, 100);
        JTextField a8 = new JTextField();
        a8.setBounds(150, 235, 310, 30);
        a8.setText("        <服务条款 > :  银行的钱统统归我！");
        a8.setForeground(Color.RED);
        a8.setFont(new Font("宋体", Font.BOLD, 12));
        JLabel a9 = new JLabel("注册");
        a9.setFont(new Font("宋体", Font.BOLD, 24));
        a9.setBounds(294, 0, 100, 40);
        JLabel a10 = new JLabel("    账号");
        a10.setFont(new Font("宋体", Font.BOLD, 20));
        a10.setBounds(350, 140, 100, 100);
        JLabel a11 = new JLabel("(6~9位)");
        a11.setFont(new Font("宋体", Font.BOLD, 12));
        a11.setBounds(290, 95, 50, 20);

        JTextField account = new JTextField();
        account.setBounds(440, 175, 150, 30);
        account.setFont(new Font("宋体", Font.BOLD, 18));

        JLabel jLabel = new JLabel("请记好您的银行卡号！");
        jLabel.setFont(new Font("宋体", Font.BOLD, 30));
        jLabel.setBounds(200, 340, 400, 30);
        jLabel.setForeground(Color.red);
        this.add(jLabel);

        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(a4);
        this.add(a5);
        this.add(a6);
        this.add(a7);
        this.add(a8);
        this.add(a9);
        this.add(name);
        this.add(password1);
        this.add(password2);
        this.add(password3);
        this.add(IdCard);
        this.add(BankCard);
        this.add(PhoneNumber);
        this.add(account);
        this.add(m1);
        this.add(m2);
        this.add(m3);
        this.add(a10);
        this.add(a11);
        //对窗口进行监听：让窗口关闭（释放资源）
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //点击注册
                String str1 = name.getText();
                String str2 = password1.getText();
                String str3 = password2.getText();
                String str4 = password3.getText();
                String str5 = IdCard.getText();
                String str7 = PhoneNumber.getText();
                String str8 = account.getText();
                user.setName(str1);
                user.setPassword(str2);
                user.setPayment(str4);
                user.setId(str5);
                user.setNumber(str6);
                user.setPhone(str7);
                user.setAcount(str8);

                UserService us = new UserService();
                int bl = us.Insert(user);
                User user2 = us.findIdAndNumberAndAcount(str5, str6, str8);
                System.out.println(str1+"****");
                System.out.println(str2+"****");

                if(!str1.isEmpty() || !str2.isEmpty()){
//                    System.out.println(str1+"****");
//                    System.out.println(str2+"****");
                    if(str2.equals(str3) || Integer.parseInt(str2)<6 || Integer.parseInt(str2)>9) {
                        if(m3.isSelected()) {
                            if(user2 != null && bl != 0) {

                                JOptionPane.showMessageDialog(null, "注册成功","提示",JOptionPane.INFORMATION_MESSAGE);
                                setVisible(false);
                                LoginPage homePage = new LoginPage();
                                homePage.FirstRegister();
                            }
                            else
                                JOptionPane.showMessageDialog(null, "注册失败","提示",JOptionPane.WARNING_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "请同意条款","提示",JOptionPane.WARNING_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "密码错误","提示",JOptionPane.WARNING_MESSAGE);
                } else
                JOptionPane.showMessageDialog(null, "用户名和密码不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
        }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 取消按钮
                LoginPage homePage = new LoginPage();
                homePage.FirstRegister();
                setVisible(false);
            }

        });
    }
}