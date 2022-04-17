package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName student_teacher
 */
@TableName(value = "student_teacher")
@Data
public class StudentTeacher implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer sid;
    /**
     *
     */
    private Integer tid;
}