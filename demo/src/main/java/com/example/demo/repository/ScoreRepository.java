package com.example.demo.repository;

import com.example.demo.obj.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoreRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // show all scores
    public List<Score> getAllScores() {
        List<Score> scoreList = new ArrayList<>();

        String query = "SELECT * FROM scores";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query);

        while (rows.next()) {
            Score score = new Score();
            score.setStudentID(rows.getLong("student_id"));
            score.setSubjectID(rows.getLong("subject_id"));
            score.setDiem_cc(rows.getDouble("diem_cc"));
            score.setDiem_gk(rows.getDouble("diem_gk"));
            score.setDiem_ck(rows.getDouble("diem_ck"));
            score.setDiem_tb(rows.getDouble("diem_tb"));

            System.out.println(score.toString());
            scoreList.add(score);
        }

        return scoreList;
    }

    // show score of a student with given student id
    public Score getScoreByStudentID(long studentID) {
        String query = "SELECT * FROM scores WHERE student_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, studentID);

        if (rows.next()) {
            Score score = new Score();
            score.setStudentID(studentID);
            score.setSubjectID(rows.getLong("subject_id"));
            score.setDiem_cc(rows.getDouble("diem_cc"));
            score.setDiem_gk(rows.getDouble("diem_gk"));
            score.setDiem_ck(rows.getDouble("diem_ck"));
            score.setDiem_tb(rows.getDouble("diem_tb"));

            return score;
        }

        // if not found any student with given id
        return null;
    }

    // show scores of a subject with given subject id
    public List<Score> getScoreBySubjectID(long subjectID) {
        List<Score> scoreList = new ArrayList<>();

        String query = "SELECT * FROM scores WHERE subject_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, subjectID);

        while (rows.next()) {
            Score score = new Score();
            score.setStudentID(rows.getLong("student_id"));
            score.setSubjectID(subjectID);
            score.setDiem_cc(rows.getDouble("diem_cc"));
            score.setDiem_gk(rows.getDouble("diem_gk"));
            score.setDiem_ck(rows.getDouble("diem_ck"));
            score.setDiem_tb(rows.getDouble("diem_tb"));

            scoreList.add(score);
        }

        return scoreList;
    }

    // create new score data
    public Score createScore(Score newScore) {
        String query = "INSERT INTO scores (student_id, subject_id, diem_cc, diem_gk, diem_ck, diem_tb)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        int updateSuccess = jdbcTemplate.update(query,
                newScore.getStudentID(),
                newScore.getSubjectID(),
                newScore.getDiem_cc(),
                newScore.getDiem_gk(),
                newScore.getDiem_ck(),
                newScore.getDiem_tb());

        if (updateSuccess > 0) {
            return newScore;
        }

        return null;
    }

    public boolean isValidSubject(long subjectID) {
        String query = "SELECT * FROM subjects WHERE subject_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, subjectID);
        if (rows.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidStudent(long studentID) {
        String query = "SELECT * FROM students WHERE student_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, studentID);
        if (rows.next()) {
            return true;
        } else {
            return false;
        }
    }
}
