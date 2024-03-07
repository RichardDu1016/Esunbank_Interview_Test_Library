package org.yunchien.library_interviewtest.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.BorrowingRecord;
import org.yunchien.library_interviewtest.model.Inventory;
import org.yunchien.library_interviewtest.model.User;
import org.yunchien.library_interviewtest.service.BorrowingRecordService;
import org.yunchien.library_interviewtest.service.InventoryService;
import org.yunchien.library_interviewtest.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @Autowired
    private UserService userService;

    @PostMapping("/library/borrowBooks")
    public ResponseEntity<List<BorrowingRecord>> borrowBook(@RequestBody @Valid BorrowReturnRequest borrowReturnRequest) {
        List<BorrowingRecord> allBorrowingRecords = new ArrayList<>();
        User member = userService.getUserById(borrowReturnRequest.getUserId());

        // 確認有這名會員
        if (member != null) {
            for (Integer inventoryId : borrowReturnRequest.getInventoryIds()) {
                Inventory book = inventoryService.findInvById(inventoryId);

                if (book != null ) { // 假設有方法判斷該書是否可借
                    BorrowingRecord record = borrowingRecordService.createRecord(borrowReturnRequest.getUserId(), inventoryId);
                    if (record != null) {
                        allBorrowingRecords.add(record);
                        inventoryService.borrowUpdInv(inventoryId); // 更新庫存狀態
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            }
            if (!allBorrowingRecords.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(allBorrowingRecords);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/library/returnBooks")
    public ResponseEntity<List<BorrowingRecord>> returnBook(@RequestBody @Valid BorrowReturnRequest borrowReturnRequest){
        List<BorrowingRecord> allBorrowingRecords = new ArrayList<>();
        User member = userService.getUserById(borrowReturnRequest.getUserId());
        // 確認有這名會員
        if(member != null){
            for(Integer inventoryId : borrowReturnRequest.getInventoryIds()){
                BorrowingRecord borrowingRecord = borrowingRecordService.findRecordByUserIdAndInventoryId(borrowReturnRequest.getUserId(),inventoryId);

                // 確認有這筆借書紀錄
                if(borrowingRecord != null){
                    BorrowingRecord returnRecord = borrowingRecordService.returnRecord(borrowReturnRequest.getUserId(), inventoryId);
                    System.out.println(returnRecord);
                    allBorrowingRecords.add(returnRecord);
                    inventoryService.returnUpdInv(inventoryId);
                }else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            }
            if(!allBorrowingRecords.isEmpty()){
                return ResponseEntity.status(HttpStatus.CREATED).body(allBorrowingRecords);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
