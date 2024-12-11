package com.example.demo.service;

import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.obj.Score;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public void getScoreList(ModelAndView modelAndView) {
        List<Score> scoreList = scoreRepository.findAllInfo();
        modelAndView.addObject("scoreList", scoreList);
    }
}
