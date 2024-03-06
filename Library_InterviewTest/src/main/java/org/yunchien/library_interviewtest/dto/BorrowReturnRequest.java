package org.yunchien.library_interviewtest.dto;

import java.util.Date;

public class BorrowReturnRequest {

    private Integer userId;
    private Integer inventoryId;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
}
