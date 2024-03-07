package org.yunchien.library_interviewtest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void borrowUpdInv(Integer inventoryId) {
        inventoryDao.borrowUpdInv(inventoryId);
    }

    @Override
    @Transactional
    public void returnUpdInv(Integer inventoryId) {
        inventoryDao.returnUpdInv(inventoryId);
    }

    @Override
    public Inventory findInvById(Integer inventoryId) {
      return  inventoryDao.findInvById(inventoryId);
    }
}
