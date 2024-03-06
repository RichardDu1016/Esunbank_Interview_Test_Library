package org.yunchien.library_interviewtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yunchien.library_interviewtest.dao.BorrowingRecordDao;
import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;
import org.yunchien.library_interviewtest.service.BorrowingRecordService;

@Component
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Autowired
    BorrowingRecordDao borrowingRecordDao;

    @Override
    public void createRecord(BorrowReturnRequest borrowReturnRequest) {
        borrowingRecordDao.createRecord(borrowReturnRequest);
    }

    @Override
    public BorrowingRecord findRecordByUserIdAndInventoryId(BorrowReturnRequest borrowReturnRequest) {
        return borrowingRecordDao.findRecordByUserIdAndInventoryId(borrowReturnRequest);
    }

    @Override
    public void returnRecord(BorrowReturnRequest borrowReturnRequest) {
        borrowingRecordDao.returnRecord(borrowReturnRequest);
    }
}
