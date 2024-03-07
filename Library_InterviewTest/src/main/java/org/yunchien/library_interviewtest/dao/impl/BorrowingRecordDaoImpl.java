package org.yunchien.library_interviewtest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.yunchien.library_interviewtest.dao.BorrowingRecordDao;
import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;
import org.yunchien.library_interviewtest.rowmapper.BorrowingRecordRowMapper;

import java.util.*;

@Component
public class BorrowingRecordDaoImpl implements BorrowingRecordDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public BorrowingRecord createRecord(Integer userId, Integer inventoryId) {
        List<BorrowingRecord> newRecords = new ArrayList<>();
        String sql = "INSERT INTO borrowing_record (user_id, inventory_id, borrowing_time) " +
                "VALUES ( :userId, :inventoryId, :borrowingTime)";

            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("inventoryId", inventoryId); // 注意這裡的鍵名大小寫應與SQL查詢一致

            Date now = new Date();
            map.put("borrowingTime", now);

            namedParameterJdbcTemplate.update(sql, map);

        return findRecordByUserIdAndInventoryId(userId,inventoryId);
    }

    @Override
    public BorrowingRecord findRecordByUserIdAndInventoryId(Integer userId, Integer inventoryId) {
        String sql = "SELECT user_id, inventory_id, borrowing_time, return_time FROM borrowing_record " +
                "WHERE user_id = :userId AND inventory_id = :inventoryId";

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("inventoryId", inventoryId);

        List<BorrowingRecord> borrowingRecordList = namedParameterJdbcTemplate.query(sql , map, new BorrowingRecordRowMapper());

        if (borrowingRecordList.size() > 0){
            return  borrowingRecordList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public BorrowingRecord returnRecord(Integer userId, Integer inventoryId) {
        List<BorrowingRecord> returnRecords = new ArrayList<>();
        String sql = "UPDATE borrowing_record SET return_time = :returnTime " +
                "WHERE user_id = :userId AND inventory_id = :inventoryId";


            Map<String, Object> map = new HashMap<>();
            Date now = new Date();
            map.put("returnTime", now);
            map.put("userId", userId);
            map.put("inventoryId", inventoryId);

            namedParameterJdbcTemplate.update(sql, map);
            return findRecordByUserIdAndInventoryId(userId, inventoryId);
    }
}
