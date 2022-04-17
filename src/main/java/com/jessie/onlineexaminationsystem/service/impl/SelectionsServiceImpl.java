package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.Selections;
import com.jessie.onlineexaminationsystem.mapper.SelectionStoreMapper;
import com.jessie.onlineexaminationsystem.mapper.SelectionsMapper;
import com.jessie.onlineexaminationsystem.service.SelectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【selections】的数据库操作Service实现
 * @createDate 2022-04-03 01:22:11
 */
@Service
public class SelectionsServiceImpl extends ServiceImpl<SelectionsMapper, Selections>
        implements SelectionsService {

    @Autowired
    SelectionsMapper selectionsMapper;
    @Autowired
    SelectionStoreMapper selectionStoreMapper;

    @Override
    @Transactional
    public void insertBatch(List<Selections> selectionsList, Integer store) {
        selectionsMapper.insertBatch(selectionsList);
        selectionStoreMapper.insertBatch(selectionsList, store);
    }

    @Override
    public List<Selections> searchSelections(String body) {
        return selectionsMapper.searchAllByTitleAndBody(body);
    }

    @Override
    public List<Selections> selectByTeacher(int teacher) {
        return selectionsMapper.selectByTeacher(teacher);
    }
}




