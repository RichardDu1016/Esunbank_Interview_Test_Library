package org.yunchien.library_interviewtest.dto;

import java.util.Date;
import java.util.List;

public class BorrowReturnRequest {

    private Integer userId;
    private List<Integer> inventoryIds;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getInventoryIds() {
        return inventoryIds;
    }

    public void setInventoryIds(List<Integer> inventoryIds) {
        this.inventoryIds = inventoryIds;
    }
}
