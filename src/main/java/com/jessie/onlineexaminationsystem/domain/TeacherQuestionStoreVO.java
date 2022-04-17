package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
public class TeacherQuestionStoreVO implements Serializable {
    private TeacherQuestionStore teacherQuestionStore;
    private List<BaseQuestion> questions;
    private String type;
    //感觉解法要么是懒加载,要么是究极连表查询

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherQuestionStoreVO storeVO = (TeacherQuestionStoreVO) o;
        return Objects.equals(teacherQuestionStore, storeVO.teacherQuestionStore) && Objects.equals(questions, storeVO.questions) && Objects.equals(type, storeVO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherQuestionStore, questions, type);
    }

    @Override
    public String toString() {
        return "TeacherQuestionStoreVO{" +
                "teacherQuestionStore=" + teacherQuestionStore +
                ", questions=" + questions +
                ", type='" + type + '\'' +
                '}';
    }
}
