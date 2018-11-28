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
public class TeacherDTO implements JDBCDataObject {

    private int teacherId;
    private String userName;
    private String password;
    private String timeStamp;

    public TeacherDTO() {
    }

    public TeacherDTO(int teacherId,
            String userName,
            String password,
            String timeStamp) {
        this.teacherId = teacherId;
        this.userName = userName;
        this.password = password;
        this.timeStamp = timeStamp;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
