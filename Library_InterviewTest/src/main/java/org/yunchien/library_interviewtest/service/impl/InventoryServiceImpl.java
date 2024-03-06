package org.yunchien.library_interviewtest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yunchien.library_interviewtest.dao.InventoryDao;
import org.yunchien.library_interviewtest.dto.BorrowReturnRequest;
import org.yunchien.library_interviewtest.model.Inventory;
import org.yunchien.library_interviewtest.service.InventoryService;

@Component
public class InventoryServiceImpl implements InventoryService {
    private final static Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Autowired
    InventoryDao inventoryDao;

    @Override
    public void borrowUpdInv(BorrowReturnRequest borrowReturnRequest) {
        inventoryDao.borrowUpdInv(borrowReturnRequest);
    }

    @Override
    public void returnUpdInv(BorrowReturnRequest borrowReturnRequest) {
        inventoryDao.returnUpdInv(borrowReturnRequest);
    }

    @Override
    public Inventory findInvById(Integer inventoryId) {
      return  inventoryDao.findInvById(inventoryId);
    }
}
