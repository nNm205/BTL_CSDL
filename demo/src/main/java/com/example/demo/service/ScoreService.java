package com.example.demo.service;

import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.obj.Score;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScores() {
        return scoreRepository.getAllScores();
    }

    public Score getScoreByStudentID(long studentID) {
        return scoreRepository.getScoreByStudentID(studentID);
    }

    public List<Score> getScoreBySubjectID(long subjectID) {
        return scoreRepository.getScoreBySubjectID(subjectID);
    }

    public boolean isValidSubject(long subjectID) {
        return scoreRepository.isValidSubject(subjectID);
    }

    public boolean isValidStudent(long studentID) {
        return scoreRepository.isValidStudent(studentID);
    }

    public Score getScoreByStudentIDAndSubjectID(long studentID, long subjectID) {
        return scoreRepository.getScoreByStudentIDAndSubjectID(studentID, subjectID);
    }

    public Score updateScore(Score currentScore) {
        return scoreRepository.updateScore(currentScore);
    }

    public boolean deleteScore(Score score) {
        return scoreRepository.deleteScore(score);
    }
}
