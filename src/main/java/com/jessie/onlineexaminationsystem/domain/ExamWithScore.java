package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

@Data
public class ExamWithScore {
    Exam exam;
    Integer scores;

    @Override
    public String toString() {
        return "ExamWithScore{" +
                "exam=" + exam +
                ", scores=" + scores +
                '}';
    }
}
