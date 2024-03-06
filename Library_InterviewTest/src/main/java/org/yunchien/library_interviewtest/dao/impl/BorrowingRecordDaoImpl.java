package org.yunchien.library_interviewtest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.yunchien.library_interviewtest.dao.BorrowingRecordDao;
import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;
import org.yunchien.library_interviewtest.rowmapper.BorrowingRecordRowMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BorrowingRecordDaoImpl implements BorrowingRecordDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void createRecord(BorrowReturnRequest borrowReturnRequest) {
        String sql = "INSERT INTO borrowing_record (user_id, inventory_id, borrowing_time) " +
                "VALUES ( :userId, :inventoryId, :borrowingTime)";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", borrowReturnRequest.getUserId());
        map.put("InventoryId", borrowReturnRequest.getInventoryId());

        Date now = new Date();
        map.put("borrowingTime", now);

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public BorrowingRecord findRecordByUserIdAndInventoryId(BorrowReturnRequest borrowReturnRequest) {
        String sql = "SELECT user_id, inventory_id, borrowing_time, return_time FROM borrowing_record " +
                "WHERE user_id = :userId AND inventory_id = :inventoryId";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", borrowReturnRequest.getUserId());
        map.put("inventoryId", borrowReturnRequest.getInventoryId());

        List<BorrowingRecord> borrowingRecordList = namedParameterJdbcTemplate.query(sql , map, new BorrowingRecordRowMapper());

        if (borrowingRecordList.size() > 0){
            return  borrowingRecordList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void returnRecord(BorrowReturnRequest borrowReturnRequest) {
        String sql = "UPDATE borrowing_record SET return_time = :returnTime " +
                "WHERE user_id = :userId AND inventory_id = :inventoryId";
        Map<String, Object> map = new HashMap<>();
        Date now = new Date();
        map.put("returnTime", now);
        map.put("userId", borrowReturnRequest.getUserId());
        map.put("inventoryId", borrowReturnRequest.getInventoryId());

        namedParameterJdbcTemplate.update(sql, map);

    }
}
