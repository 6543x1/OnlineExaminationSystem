package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.Blanks;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【blanks】的数据库操作Mapper
 * @createDate 2022-04-05 01:40:50
 * @Entity com.jessie.onlineexaminationsystem.domain.Blanks
 */
public interface BlanksMapper extends BaseMapper<Blanks> {
    int insertAll(Blanks blanks);

    int insertBatch(@Param("blanksCollection") Collection<Blanks> blanksCollection);

    List<Blanks> selectByTeacher(@Param("teacher") Integer teacher);

    List<Blanks> searchAllByBody(@Param("body") String body);
}




