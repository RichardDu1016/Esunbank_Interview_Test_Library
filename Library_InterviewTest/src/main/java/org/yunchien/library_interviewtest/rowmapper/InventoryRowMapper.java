package org.yunchien.library_interviewtest.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.yunchien.library_interviewtest.model.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryRowMapper implements RowMapper<Inventory> {

    @Override
    public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {

        Inventory inventory = new Inventory();
        inventory.setInventoryId(rs.getInt("inventory_id"));
        inventory.setIsbn(rs.getString("isbn"));
        inventory.setStoreTime(rs.getDate("store_time"));
        inventory.setStatus(rs.getString("status"));
        return inventory;
    }
}
