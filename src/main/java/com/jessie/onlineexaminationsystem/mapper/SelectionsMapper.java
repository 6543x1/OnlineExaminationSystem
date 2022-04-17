package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.Selections;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【selections】的数据库操作Mapper
 * @createDate 2022-04-03 01:22:11
 * @Entity com.jessie.onlineexaminationsystem.domain.Selections
 */
public interface SelectionsMapper extends BaseMapper<Selections> {
    int insertAll(Selections selections);

    int insertBatch(@Param("selectionsCollection") Collection<Selections> selectionsCollection);

    List<Selections> searchAllByTitleAndBody(@Param("body") String body);

    List<Selections> selectByTeacher(@Param("teacher") Integer teacher);

}




