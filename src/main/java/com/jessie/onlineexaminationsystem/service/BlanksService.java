package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.Blanks;
import com.jessie.onlineexaminationsystem.domain.BlanksVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【blanks】的数据库操作Service
 * @createDate 2022-04-05 01:40:50
 */
public interface BlanksService extends IService<Blanks> {

    @Transactional
    void insertBatch(BlanksVO blanksVO);

    List<Blanks> selectByTeacher(Integer teacher);

    List<Blanks> search(String key);
}
