package org.yunchien.library_interviewtest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.yunchien.library_interviewtest.dao.InventoryDao;
import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.Inventory;
import org.yunchien.library_interviewtest.rowmapper.InventoryRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void borrowUpdInv(BorrowReturnRequest borrowReturnRequest) {

        String sql = "UPDATE inventory SET status = 'not available' WHERE inventory_id = :inventoryId";
        Map<String, Object> map = new HashMap<>();
        map.put("isbn", borrowReturnRequest.getInventoryId());
        namedParameterJdbcTemplate.update(sql,map);

    }

    @Override
    public void returnUpdInv(BorrowReturnRequest borrowReturnRequest) {
        String sql = "UPDATE inventory SET status = 'available' WHERE inventory_id = :inventoryId";
        Map<String, Object> map = new HashMap<>();
        map.put("isbn", borrowReturnRequest.getInventoryId());
        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public Inventory findInvById(Integer inventoryId) {
        String sql = "SELECT inventory_id, isbn, store_time, status FROM inventory " +
                "WHERE inventory_id = :inventoryId";
        Map<String,Object> map = new HashMap<>();
        map.put("inventoryId", inventoryId);
        List<Inventory> inventoryList =  namedParameterJdbcTemplate.query(sql, map ,new InventoryRowMapper());

        if(inventoryList.size() > 0){
            return inventoryList.get(0);
        } else {
            return null;
        }
    }
}
