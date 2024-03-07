package org.yunchien.library_interviewtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yunchien.library_interviewtest.dao.BorrowingRecordDao;
import org.yunchien.library_interviewtest.dao.InventoryDao;
import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;
import org.yunchien.library_interviewtest.model.Inventory;
import org.yunchien.library_interviewtest.service.BorrowingRecordService;

import java.util.ArrayList;
import java.util.List;

@Component
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Autowired
    BorrowingRecordDao borrowingRecordDao;

    @Autowired
    InventoryDao inventoryDao;

    @Override
    @Transactional
    public BorrowingRecord createRecord(Integer userId, Integer inventoryId) {
        // 確認該筆庫存狀態
            Inventory book = inventoryDao.findInvById(inventoryId);
            Boolean status = book.getStatus().equals("available");
            // 確認使用者是否有借過此本
            BorrowingRecord borrowingRecord = borrowingRecordDao.findRecordByUserIdAndInventoryId(userId, inventoryId);
            // 兩者皆成立才創建借書成功
            if (status && borrowingRecord == null) {
                BorrowingRecord newrecord = borrowingRecordDao.createRecord(userId, inventoryId);
                return newrecord;
            }else {
                return null;
            }
    }


    @Override
    public BorrowingRecord findRecordByUserIdAndInventoryId(Integer userId, Integer inventoryId) {
        return borrowingRecordDao.findRecordByUserIdAndInventoryId(userId, inventoryId);
    }

    @Override
    @Transactional
    public BorrowingRecord returnRecord(Integer userId, Integer inventoryId) {
        // 確認使用者是否有借過此本
            BorrowingRecord borrowingRecord = borrowingRecordDao.findRecordByUserIdAndInventoryId(userId,inventoryId);
            if (borrowingRecord != null){
                BorrowingRecord borrowedRecord = borrowingRecordDao.returnRecord(userId,inventoryId);
                return borrowedRecord;
            }else {
                return null;
            }
    }
}
