package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExamVO implements Serializable {
    Exam exam;
    List<Integer> students;
}
