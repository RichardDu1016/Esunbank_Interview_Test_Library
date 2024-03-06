package org.yunchien.library_interviewtest.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.yunchien.library_interviewtest.model.BorrowingRecord;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowingRecordRowMapper implements RowMapper<BorrowingRecord> {
    @Override
    public BorrowingRecord mapRow(ResultSet rs, int rowNum) throws SQLException {

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setUserId(rs.getInt("user_id"));
        borrowingRecord.setInventoryId(rs.getInt("inventory_id"));
        borrowingRecord.setBorrowingTime(rs.getDate("borrowing_time"));
        borrowingRecord.setReturnTime(rs.getDate("return_time"));
        return borrowingRecord;
    }
}
