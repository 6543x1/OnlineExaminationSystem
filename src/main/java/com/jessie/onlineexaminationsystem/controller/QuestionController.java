package com.jessie.onlineexaminationsystem.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.jessie.onlineexaminationsystem.domain.*;
import com.jessie.onlineexaminationsystem.service.AnswerQuestionService;
import com.jessie.onlineexaminationsystem.service.BlanksService;
import com.jessie.onlineexaminationsystem.service.SelectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/question")
@RestController
@SaCheckRole("teacher")
public class QuestionController {

    @Autowired
    SelectionsService selectionsService;
    @Autowired
    BlanksService blanksService;
    @Autowired
    AnswerQuestionService answerQuestionService;

    @PostMapping("/newSelections")
    public Result newSelection(@RequestBody SelectionsVO selectionsVO) {
        List<Selections> selectionsList = selectionsVO.getSelections();
        for (Selections selections : selectionsList) {
            selections.setTeacher(Integer.parseInt(StpUtil.getLoginId("")));
        }
        selectionsService.insertBatch(selectionsList, selectionsVO.getStore());
        return Result.success("插入选择题到题库成功");
    }

    @PostMapping("/newBlanks")
    public Result newBlanks(@RequestBody BlanksVO blanksVO) {
        List<Blanks> selectionsList = blanksVO.getBlanks();
        for (Blanks selections : selectionsList) {
            selections.setTeacher(Integer.parseInt(StpUtil.getLoginId("")));
        }
        blanksService.insertBatch(blanksVO);
        return Result.success("插入填空题到题库成功");
    }

    @PostMapping("/newAnswerQuestions")
    public Result newAQs(@RequestBody AnswerQuestionVO answerQuestionVO) {
        List<AnswerQuestion> selectionsList = answerQuestionVO.getAnswerQuestions();
        for (AnswerQuestion selections : selectionsList) {
            selections.setTeacher(Integer.parseInt(StpUtil.getLoginId("")));
        }
        answerQuestionService.insertBatch(answerQuestionVO);
        return Result.success("插入填空题到题库成功");
    }

    @PostMapping("search")
    public Result search(@RequestBody String key) {
        return Result.success("查询成功", selectionsService.searchSelections(key));
    }

    @PostMapping("/getByTeacher")
    public Result getByTeacher() {
        QuestionVO questionVO = new QuestionVO();
        int teacher = Integer.parseInt(StpUtil.getLoginId(""));
        questionVO.setSelections(selectionsService.selectByTeacher(teacher));
        questionVO.setBlanks(blanksService.selectByTeacher(teacher));
        questionVO.setAnswerQuestions(answerQuestionService.selectByTeacher(teacher));
        return Result.success("查询成功", questionVO);
    }


}
