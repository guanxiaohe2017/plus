package com.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.entity.consumables.FhvcInventory;
import com.mybatis.plus.entity.consumables.FhvcInventoryJournal;
import com.mybatis.plus.mapper.consumables.FhvcInventoryJournalMapper;
import com.mybatis.plus.mapper.consumables.FhvcInventoryMapper;
import com.mybatis.plus.service.FhvcInventoryJournalService;
import com.mybatis.plus.service.FhvcInventoryService;
import org.springframework.stereotype.Service;

@Service
public class FhvcInventoryJournalServiceImpl extends ServiceImpl<FhvcInventoryJournalMapper, FhvcInventoryJournal> implements FhvcInventoryJournalService {

}
