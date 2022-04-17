package com.jessie.onlineexaminationsystem.domain;


import lombok.Data;

@Data
public class ExamWithPointsAndScore {
    Exam exam;
    Integer scores;
    Integer points;

    @Override
    public String toString() {
        return "ExamWithPointsAndScore{" +
                "exam=" + exam +
                ", scores=" + scores +
                ", points=" + points +
                '}';
    }
}
