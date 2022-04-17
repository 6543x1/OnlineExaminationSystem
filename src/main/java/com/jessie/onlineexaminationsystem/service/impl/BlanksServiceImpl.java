package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.Blanks;
import com.jessie.onlineexaminationsystem.domain.BlanksVO;
import com.jessie.onlineexaminationsystem.mapper.BlanksMapper;
import com.jessie.onlineexaminationsystem.mapper.BlanksStoreMapper;
import com.jessie.onlineexaminationsystem.service.BlanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【blanks】的数据库操作Service实现
 * @createDate 2022-04-05 01:40:50
 */
@Service
public class BlanksServiceImpl extends ServiceImpl<BlanksMapper, Blanks>
        implements BlanksService {
    @Autowired
    BlanksMapper blanksMapper;
    @Autowired
    BlanksStoreMapper blanksStoreMapper;

    @Override
    @Transactional
    public void insertBatch(BlanksVO blanksVO) {
        blanksMapper.insertBatch(blanksVO.getBlanks());
        blanksStoreMapper.insertBatch(blanksVO.getBlanks(), blanksVO.getStore());
    }

    @Override
    public List<Blanks> selectByTeacher(Integer teacher) {
        return blanksMapper.selectByTeacher(teacher);
    }

    @Override
    public List<Blanks> search(String key) {
        return blanksMapper.searchAllByBody(key);
    }
}




