package org.yunchien.library_interviewtest.dao;

import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;

public interface BorrowingRecordDao {

    void createRecord(BorrowReturnRequest borrowReturnRequest);

    BorrowingRecord findRecordByUserIdAndInventoryId(BorrowReturnRequest borrowReturnRequest);

    void returnRecord(BorrowReturnRequest borrowReturnRequest);
}
