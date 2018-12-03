package edu.curd.dto;

import edu.curd.operation.JDBCDataObject;

/**
 *
 * @author aeronx
 */
public class StudentGradesDTO implements JDBCDataObject {

    private int gradesId;
    private String score;
    private String studentFullName;
    private int studentEnrollmentId;
    private int topicId;

    public StudentGradesDTO(int gradesId,
            String studentFullName,
            String score,int topicId,
            int studentEnrollmentId) {
        this.gradesId = gradesId;
        this.score = score;
        this.studentFullName = studentFullName;
        this.topicId=topicId;
        this.studentEnrollmentId=studentEnrollmentId;
    }

    public int getGradesId() {
        return gradesId;
    }

    public void setGradesId(int gradesId) {
        this.gradesId = gradesId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public int getStudentEnrollmentId() {
        return studentEnrollmentId;
    }

    public void setStudentEnrollmentId(int studentEnrollmentId) {
        this.studentEnrollmentId = studentEnrollmentId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }


}
