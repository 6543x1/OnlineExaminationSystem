package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.SelectionStore;
import com.jessie.onlineexaminationsystem.domain.Selections;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【selection_store】的数据库操作Mapper
 * @createDate 2022-04-04 23:36:04
 * @Entity com.jessie.onlineexaminationsystem.domain.SelectionStore
 */
public interface SelectionStoreMapper extends BaseMapper<SelectionStore> {

    int insertAll(SelectionStore selectionStore);

    int insertBatch(@Param("selectionStoreCollection") List<Selections> selections, @Param("store") Integer store);
}




