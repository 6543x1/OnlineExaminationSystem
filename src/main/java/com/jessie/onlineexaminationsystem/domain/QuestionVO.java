package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionVO implements Serializable {
    List<Selections> selections;
    List<Blanks> blanks;
    List<AnswerQuestion> answerQuestions;
}
