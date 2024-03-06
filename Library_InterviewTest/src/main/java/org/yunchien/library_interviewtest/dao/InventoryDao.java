package org.yunchien.library_interviewtest.dao;

import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.Inventory;

public interface InventoryDao {

    void borrowUpdInv(BorrowReturnRequest borrowReturnRequest);
    void returnUpdInv(BorrowReturnRequest borrowReturnRequest);

    Inventory findInvById(Integer inventoryId);
}
