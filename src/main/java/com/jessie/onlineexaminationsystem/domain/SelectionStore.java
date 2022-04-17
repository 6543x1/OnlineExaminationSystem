package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName selection_store
 */
@TableName(value = "selection_store")
@Data
public class SelectionStore implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer qid;
    /**
     *
     */
    private Integer sid;
}