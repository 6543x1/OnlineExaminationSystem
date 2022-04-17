package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.Selections;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【selections】的数据库操作Service
 * @createDate 2022-04-03 01:22:11
 */
public interface SelectionsService extends IService<Selections> {

    void insertBatch(List<Selections> selectionsList, Integer store);

    List<Selections> searchSelections(String body);

    List<Selections> selectByTeacher(int teacher);
}
