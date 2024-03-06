package org.yunchien.library_interviewtest.service;

import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;

public interface BorrowingRecordService {

    void createRecord(BorrowReturnRequest borrowReturnRequest);
    BorrowingRecord findRecordByUserIdAndInventoryId(BorrowReturnRequest borrowReturnRequest);

    void returnRecord(BorrowReturnRequest borrowReturnRequest);
}
