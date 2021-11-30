package com.MyBank.service.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 链接池返回
 */
public class BaseUtils {
//    // 第一步 初始化 druid连接池
    private static DataSource dataSource=null;
    static {
        try {
            Properties pros = new Properties();//Properties主要的作用是通过修改配置文件可以方便的修改代码中的参数
            InputStream is =ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");//生成一个流来读取配置文件
            pros.load(is);//从输入流中读取属性列表（键和元素对）
            dataSource = DruidDataSourceFactory.createDataSource(pros);//DataSource它负责建立与数据库的连接
            Connection conn = dataSource.getConnection();//通过DataSource获取链接
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static QueryRunner getQueryRunner() {
        //第一步 创建 QueryRunner 对象 传入连接池对象
        QueryRunner query = new QueryRunner(dataSource);
        //为什么要这样做 为的是从数据源中获取连接 不用关闭
        return query;
    }
    /**
     * 公共方法
     * @param sql
     * @param arr
     * @return
     */
    //增删改查
    public static boolean addUpdateDelet(String sql,Object...arr) {
        System.out.println();
        QueryRunner qr = getQueryRunner();
        int count;
        try {
            count = qr.update(sql, arr);
            if(count>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
