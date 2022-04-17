package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @TableName selections
 */
@TableName(value = "selections")
@Data
public class Selections extends BaseQuestion implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     *
     */
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
    private String a;
    /**
     *
     */
    private String b;
    /**
     *
     */
    private String c;
    /**
     *
     */
    private String d;
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
    @TableField("isPublic")
    private boolean isPublic;
    @TableField("uploadTime")
    private LocalDateTime uploadTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Selections that = (Selections) o;
        return isPublic == that.isPublic && Objects.equals(id, that.id) && Objects.equals(body, that.body) && Objects.equals(a, that.a) && Objects.equals(b, that.b) && Objects.equals(c, that.c) && Objects.equals(d, that.d) && Objects.equals(ans, that.ans) && Objects.equals(teacher, that.teacher) && Objects.equals(uploadTime, that.uploadTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, a, b, c, d, ans, teacher, isPublic, uploadTime);
    }
}