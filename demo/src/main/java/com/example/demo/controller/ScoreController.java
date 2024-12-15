package com.example.demo.controller;

import com.example.demo.ScoreDto;
import com.example.demo.repository.ScoreRepository;
import com.example.demo.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.example.demo.obj.Score;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping({"", "/"})
    public String getScoreList(Model model) {
        List<Score> scoreList = scoreService.getAllScores();
        model.addAttribute("scoreList", scoreList);
        return "scores/score-list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        ScoreDto scoreDto = new ScoreDto();
        model.addAttribute("scoreDto", scoreDto);
        return "scores/create";
    }

    @PostMapping("/create")
    public String createScore(
            @Valid @ModelAttribute("scoreDto") ScoreDto scoreDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "scores/create";
        }

        if (!scoreService.isValidStudent(Long.parseLong(scoreDto.getStudentID()))
        && !scoreService.isValidSubject(Long.parseLong(scoreDto.getSubjectID()))) {
            scoreDto.setMesage("Student ID is not found and SubjectID is not found");
            return "scores/create";
        }

        if (!scoreService.isValidStudent(Long.parseLong(scoreDto.getStudentID()))) {
            scoreDto.setMesage("Student ID is not found");
            return "scores/create";
        }

        if (!scoreService.isValidSubject(
                Long.parseLong(scoreDto.getSubjectID()))) {
            scoreDto.setMesage("Subject ID is not found");
            return "scores/create";
        }

        if (scoreDto.getMessage() == null) {
            return "scores/create";
        }

        Score score = new Score();
        score.setStudentID(Long.parseLong(scoreDto.getStudentID()));
        score.setSubjectID(Long.parseLong(scoreDto.getSubjectID()));
        score.setDiem_cc(Double.parseDouble(scoreDto.getDiem_cc()));
        score.setDiem_gk(Double.parseDouble(scoreDto.getDiem_gk()));
        score.setDiem_ck(Double.parseDouble(scoreDto.getDiem_ck()));
        score.setDiem_tb(Double.parseDouble(scoreDto.getDiem_tb()));

        scoreRepository.createScore(score);
        redirectAttributes
                .addFlashAttribute("message",
                        "Tạo dữ liệu mới điểm thành công");
        return "redirect:/scores";
    }
}
