/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curd.dto;

import edu.curd.operation.JDBCDataObject;

/**
 *
 * @author Kyle
 */
public class GadesDTO implements JDBCDataObject {

    private int gradesId;
    private int enrollmentId;
    private int excerciseId;
    private String grade;
    private String score;
    private String timeStamp;

    public GadesDTO() {
    }

    public GadesDTO(int gradesId,
            int enrollmentId,
            int excerciseId,
            String grade,
            String score,
            String timeStamp) {

        this.gradesId = gradesId;
        this.enrollmentId = enrollmentId;
        this.excerciseId = excerciseId;
        this.grade = grade;
        this.score = score;
        this.timeStamp = timeStamp;
    }

    public int getGradesId() {
        return gradesId;
    }

    public void setGradesId(int gradesId) {
        this.gradesId = gradesId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getExcerciseId() {
        return excerciseId;
    }

    public void setExcerciseId(int excerciseId) {
        this.excerciseId = excerciseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    
}
