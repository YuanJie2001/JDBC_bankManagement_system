package com.MyBank.service;

import com.MyBank.pojo.Transfer;
import com.MyBank.service.utils.BaseUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 插入一条转账记录
 */
public class TransferInsertSql {
    public int Insert1(Transfer transfer) {
        String sql = "insert into transfer values(?,?,?,?,?)";
        QueryRunner qr = BaseUtils.getQueryRunner();
        try {
            return qr.update(sql, transfer.getTransfer_people(),
                    transfer.getTransfer_object(), transfer.getTransfer_money(),
                    transfer.getTransfer_data(), transfer.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}