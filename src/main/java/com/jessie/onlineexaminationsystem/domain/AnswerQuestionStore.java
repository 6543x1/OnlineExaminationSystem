package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName answer_question_store
 */
@TableName(value = "answer_question_store")
@Data
public class AnswerQuestionStore implements Serializable {
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