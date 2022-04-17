package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AnswerQuestionVO implements Serializable {
    List<AnswerQuestion> answerQuestions;
    Integer store;
}
