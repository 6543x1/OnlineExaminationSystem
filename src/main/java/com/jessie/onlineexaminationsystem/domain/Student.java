package com.jessie.onlineexaminationsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @TableName student
 */
@TableName(value = "student")
@Data
public class Student implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId
    private Integer id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String no;
    /**
     *
     */
    private String school;
    /**
     *
     */
    private String profession;
    private List<Course> courses;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", school='" + school + '\'' +
                ", profession='" + profession + '\'' +
                ", courses=" + courses +
                '}';
    }
}