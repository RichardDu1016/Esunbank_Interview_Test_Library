package org.yunchien.library_interviewtest.service;

import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;

import java.util.List;

public interface BorrowingRecordService {

    BorrowingRecord createRecord(Integer userId, Integer inventoryId);
    BorrowingRecord findRecordByUserIdAndInventoryId(Integer userId, Integer inventoryId);

    BorrowingRecord returnRecord(Integer userId, Integer inventoryId);
}
