/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curd.dto;

import edu.curd.operation.JDBCDataObject;

/**
 *
 * @author Aeron
 */
public class ClassExercisesDTO implements JDBCDataObject {

    private int classId;
    private String excerciseType;
    private int excerciseId;
    private String timeStamp;

    public ClassExercisesDTO() {
    }

    public ClassExercisesDTO(            int excerciseId,
            int classId,
            String excerciseType,
            String timeStamp) {

        this.classId = classId;
        this.excerciseType = excerciseType;
        this.excerciseId = excerciseId;
        this.timeStamp = timeStamp;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getExcerciseType() {
        return excerciseType;
    }

    public void setExcerciseType(String excerciseType) {
        this.excerciseType = excerciseType;
    }

    public int getExcerciseId() {
        return excerciseId;
    }

    public void setExcerciseId(int excerciseId) {
        this.excerciseId = excerciseId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
