package org.yunchien.library_interviewtest.dao;

import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.Inventory;

public interface InventoryDao {

    void borrowUpdInv(Integer inventoryId);
    void returnUpdInv(Integer inventoryId);

    Inventory findInvById(Integer inventoryId);
}
