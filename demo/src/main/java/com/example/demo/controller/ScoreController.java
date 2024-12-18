package com.example.demo.controller;

import com.example.demo.Dto.ScoreDto;
import com.example.demo.repository.ScoreRepository;
import com.example.demo.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.demo.obj.Score;
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

    @GetMapping("/edit/{studentID}/{subjectID}")
    public String showEditPage(Model model,
                               @PathVariable("studentID") Long studentID,
                               @PathVariable("subjectID") Long subjectID,
                               RedirectAttributes redirectAttributes) {

        Score score = scoreService.getScoreByStudentIDAndSubjectID(studentID, subjectID);
        if (score == null) {
            redirectAttributes
                    .addFlashAttribute("errorMessage",
                            "Score not found");
            return "redirect:/scores";
        }

        model.addAttribute("score", score);

        ScoreDto scoreDto = new ScoreDto();
        scoreDto.setStudentID(String.valueOf(studentID));
        scoreDto.setSubjectID(String.valueOf(subjectID));
        scoreDto.setDiem_cc(!String.valueOf(score.getDiem_cc()).isEmpty() ? String.valueOf(score.getDiem_cc()) : "0");
        scoreDto.setDiem_gk(!String.valueOf(score.getDiem_gk()).isEmpty() ? String.valueOf(score.getDiem_gk()) : "0");
        scoreDto.setDiem_ck(!String.valueOf(score.getDiem_ck()).isEmpty() ? String.valueOf(score.getDiem_ck()) : "0");
        scoreDto.setDiem_tb(!String.valueOf(score.getDiem_tb()).isEmpty() ? String.valueOf(score.getDiem_tb()) : "0");

        model.addAttribute("scoreDto", scoreDto);
        return "scores/edit";
    }

    @PostMapping("/edit/{studentID}/{subjectID}")
    public String editScore(Model model,
                            @PathVariable Long studentID,
                            @PathVariable Long subjectID,
                            @Valid @ModelAttribute("scoreDto") ScoreDto scoreDto,
                            RedirectAttributes redirectAttributes) {
        Score score = scoreService.getScoreByStudentIDAndSubjectID(studentID, subjectID);
        if (score == null) {
            return "redirect:/scores";
        }

        score.setDiem_cc(Double.parseDouble(scoreDto.getDiem_cc()));
        score.setDiem_gk(Double.parseDouble(scoreDto.getDiem_gk()));
        score.setDiem_ck(Double.parseDouble(scoreDto.getDiem_ck()));
        score.setDiem_tb(Double.parseDouble(scoreDto.getDiem_tb()));

        scoreService.updateScore(score);
        redirectAttributes
                .addFlashAttribute("successMessage",
                        "Sửa dữ liệu điểm thành công");
        return "redirect:/scores";
    }

    @GetMapping("/delete/{studentID}/{subjectID}")
    public String deleteScore(Model model,
                              @PathVariable Long studentID,
                              @PathVariable Long subjectID,
                              RedirectAttributes redirectAttributes) {
        try {
            Score score = scoreService.getScoreByStudentIDAndSubjectID(studentID, subjectID);
            scoreService.deleteScore(score);
            redirectAttributes
                    .addFlashAttribute("success",
                            "Xóa dữ liệu điểm thành công");
        } catch (Exception e) {
            redirectAttributes
                    .addFlashAttribute("errorMessage",
                            "Không thể xóa dữ liệu điểm sinh viên, vui lòng thử lại!");
        }
        return "redirect:/scores";
    }
}
