package com.example.demo.controller;

import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.example.demo.obj.Score;

@Controller
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/score")
    public String score(Model model) {
        List<Score> scoreList = scoreRepository.findAllInfo();
        model.addAttribute("scoreList", scoreList);
        return "home-page";
    }
}
