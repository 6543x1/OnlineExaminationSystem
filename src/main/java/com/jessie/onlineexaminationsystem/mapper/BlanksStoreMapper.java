package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.Blanks;
import com.jessie.onlineexaminationsystem.domain.BlanksStore;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * @author JessieLin
 * @description 针对表【blanks_store】的数据库操作Mapper
 * @createDate 2022-04-05 14:32:26
 * @Entity com.jessie.onlineexaminationsystem.domain.BlanksStore
 */
public interface BlanksStoreMapper extends BaseMapper<BlanksStore> {
    int insertBatch(@Param("blanksStoreCollection") Collection<Blanks> blanksStoreCollection, @Param("store") Integer store);
}




