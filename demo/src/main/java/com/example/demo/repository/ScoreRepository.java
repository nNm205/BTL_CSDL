package com.example.demo.repository;

import com.example.demo.obj.Score;
import com.example.demo.obj.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    public Score getScoreByStudentIDAndSubjectID(long studentID, long subjectID) {
        String query = "SELECT * FROM scores WHERE student_id = ? AND subject_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, studentID, subjectID);

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

        // if not found any student with given student id and given subject id
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

    public Score updateScore(Score currentScore) {
        String query = "UPDATE scores " +
                "SET diem_cc = ?," +
                "diem_gk = ?," +
                "diem_ck = ?," +
                "diem_tb = ?" +
                "WHERE student_id = ? AND subject_id = ?";
        jdbcTemplate.update(query,
                currentScore.getDiem_cc(),
                currentScore.getDiem_gk(),
                currentScore.getDiem_ck(),
                currentScore.getDiem_tb(),
                currentScore.getStudentID(),
                currentScore.getSubjectID());
        return getScoreByStudentIDAndSubjectID(currentScore.getStudentID(), currentScore.getSubjectID());
    }

    public boolean deleteScore(Score score) {
        String query = "DELETE FROM scores WHERE student_id = ? AND subject_id = ?";
        try {
            int deleteSuccess = jdbcTemplate.update(query, score.getStudentID(), score.getSubjectID());
            return deleteSuccess > 0;
        } catch (Exception e) {
            System.err.println("Lỗi xảy ra khi xóa dữ liệu điểm của sinh viên có mã sinh viên là"
                    + score.getSubjectID() + " ở môn học có mã môn học là "
                    + score.getSubjectID() + ": " + e.getMessage());
            return false;
        }
    }

    public List<Score> getScoresWithPagination(int pageNo, int pageSize) {
        List<Score> scoreList = new ArrayList<>();
        int offset = (pageNo - 1) * pageSize;

        String query = "SELECT * FROM scores LIMIT ? OFFSET ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, pageSize, offset);

        while (rowSet.next()) {
            Score score = new Score();
            score.setStudentID(rowSet.getLong("student_id"));
            score.setSubjectID(rowSet.getLong("subject_id"));
            score.setDiem_cc(Double.parseDouble(rowSet.getString("diem_cc")));
            score.setDiem_gk(Double.parseDouble(rowSet.getString("diem_gk")));
            score.setDiem_ck(Double.parseDouble(rowSet.getString("diem_ck")));
            score.setDiem_tb(Double.parseDouble(rowSet.getString("diem_tb")));
            scoreList.add(score);
        }

        return scoreList;
    }

    public int getTotalScores() {
        String query = "SELECT COUNT(*) FROM scores";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
}
