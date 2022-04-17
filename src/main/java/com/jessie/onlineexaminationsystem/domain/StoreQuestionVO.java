package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StoreQuestionVO implements Serializable {
    List<BaseQuestion> questions;
    Integer size;

    public void setQuestions(List<BaseQuestion> questions) {
        this.questions = questions;
        this.size = questions.size();
    }

    @Override
    public String toString() {
        return "StoreQuestionVO{" +
                "questions=" + questions +
                ", size=" + size +
                '}';
    }
}
