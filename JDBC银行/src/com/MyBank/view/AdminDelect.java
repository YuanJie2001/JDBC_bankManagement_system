package com.MyBank.view;

import com.MyBank.dao.AdministratorDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ɾ��ҳ�湦��ʵ��
 */
public class AdminDelect extends JFrame{

    public void a_delect() {
        this.setTitle("ɾ��ҳ��");
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        JPanel c = (JPanel)this.getContentPane();
        c.setOpaque(false);
        this.setLayout(null);
        ImageIcon jpg = new ImageIcon("7.jpg");
        jpg.setImage(jpg.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        JLabel s1 = new JLabel(jpg);
        s1.setBounds(0, 0, 500, 400);
        this.getLayeredPane().add(s1,new Integer(Integer.MIN_VALUE));

        JTextField name = new JTextField();
        name.setBounds(130, 55, 150, 30);
        name.setFont(new Font("����", Font.PLAIN, 18));

        JTextField acount = new JTextField();
        acount.setBounds(130, 140, 150, 30);
        acount.setFont(new Font("����", Font.PLAIN, 18));

        JLabel a1 = new JLabel("����");
        a1.setFont(new Font("����", Font.BOLD, 20));
        a1.setBounds(70, 30, 80, 80);
        JLabel a2 = new JLabel("�˺�");
        a2.setFont(new Font("����", Font.BOLD, 20));
        a2.setBounds(70, 100, 100, 100);
        JLabel a3 = new JLabel("��ȷ��Ҫɾ����");
        a3.setFont(new Font("����", Font.BOLD, 28));
        a3.setBounds(100, 200, 300, 50);
        a3.setForeground(Color.red);

        JButton m1 = new JButton("ȡ��");
        m1.setFont(new Font("����", Font.BOLD, 20));
        m1.setBounds(30, 250, 100, 50);
        JButton m2 = new JButton("ȷ��");
        m2.setFont(new Font("����", Font.BOLD, 20));
        m2.setBounds(300, 250, 100, 50);

        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(name);
        this.add(acount);
        this.add(m1);
        this.add(m2);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        this.setResizable(false);
        this.setVisible(true);

        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // ȷ����ť
                String str1 = name.getText();
                String str2 = acount.getText();
                AdministratorDao admin = new AdministratorDao();
                int ad = admin.delectUser(str1, str2);
                if(ad==0)
                    JOptionPane.showMessageDialog(null, "ɾ��ʧ��","��ʾ",JOptionPane.WARNING_MESSAGE);
                else {
                    JOptionPane.showMessageDialog(null, "ɾ���ɹ�","��ʾ",JOptionPane.OK_CANCEL_OPTION);
                    setVisible(false);
                    AdminMain homeMain = new AdminMain();
                    homeMain.a_homeMain();
                }

            }

        });

        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // ȡ����ť
                AdminMain homeMain = new AdminMain();
                homeMain.a_homeMain();
                setVisible(false);
            }

        });

    }
}
