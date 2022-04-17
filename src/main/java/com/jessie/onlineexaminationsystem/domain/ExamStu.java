package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName exam_stu
 */
@TableName(value = "exam_stu")
@Data
public class ExamStu implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer examID;
    /**
     *
     */
    private Integer uid;
    private Integer points;
    private String examPaper;


}