package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName answer_question
 */
@TableName(value = "answer_question")
@Data
public class AnswerQuestion implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     *
     */
    private String body;
    /**
     *
     */
    private String ans;
    /**
     *
     */
    private Integer teacher;
    /**
     *
     */
    private boolean isPublic;
    /**
     *
     */
    private LocalDateTime uploadTime;
}