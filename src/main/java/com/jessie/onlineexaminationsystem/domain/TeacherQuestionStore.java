package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 题库
 *
 * @TableName teacher_question_store
 */
@TableName(value = "teacher_question_store")
@Data
public class TeacherQuestionStore implements Serializable {
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
    private String name;
    /**
     *
     */
    @TableField("public")
    private boolean isPublic;
    /**
     *
     */
    private LocalDateTime updateTime;
    private Integer teacher;
    private String description;
    private String type;
}