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
public class AttendanceDTO implements JDBCDataObject {

    private int attendanceId;
    private int enrollmentId;
    private int studentId;
    private int classId;
    private String timeStamp;

    public AttendanceDTO() {
    }

    public AttendanceDTO(int attendanceId,
            int enrollmentId,
            int studentId,
            int classId,
            String timeStamp) {
        this.attendanceId = attendanceId;
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.classId = classId;
        this.timeStamp = timeStamp;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    
}
