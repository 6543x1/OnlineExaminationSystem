package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName exam
 */
@TableName(value = "exam")
@Data
public class Exam implements Serializable {
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
    private LocalDateTime startTime;
    /**
     *
     */
    private LocalDateTime endTime;
    /**
     *
     */
    private LocalDateTime publishTime;
    /**
     *
     */
    private LocalDateTime publicTime;
    /**
     *
     */
    private Integer passScore;
    /**
     *
     */
    private Integer chance;
    /**
     *
     */
    private Integer examPaperID;
    /**
     *
     */
    private Integer limitTime;
    /**
     * 持续时间 单位分钟
     */
    private Integer duration;
    /**
     *
     */
    private Integer teacher;
    /**
     *
     */
    private LocalDateTime infoTime;
    /**
     *
     */
    private String notes;

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", publishTime=" + publishTime +
                ", publicTime=" + publicTime +
                ", passScore=" + passScore +
                ", chance=" + chance +
                ", examPaperID=" + examPaperID +
                ", limitTime=" + limitTime +
                ", duration=" + duration +
                ", teacher=" + teacher +
                ", infoTime=" + infoTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}