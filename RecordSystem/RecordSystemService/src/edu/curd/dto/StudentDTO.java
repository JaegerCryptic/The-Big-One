
package edu.curd.dto;

import edu.curd.operation.JDBCDataObject;


public class StudentDTO implements JDBCDataObject {



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    private int studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String phone;
    private String address;
    private String timeStamp;
    private int enrollmentId;

    public int getEnrollmentId() {
        return enrollmentId;
    }
    
    public StudentDTO() {

    }

    public StudentDTO(int studentId, String firstName, String lastName, String gender, String dob, String phone, String address, String timeStamp) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.timeStamp = timeStamp;
    }
    
        public StudentDTO(int studentId,int enrollmentId, String firstName, String lastName, String gender, String dob, String phone, String address, String timeStamp) {
        this.studentId = studentId;
        this.enrollmentId= enrollmentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.timeStamp = timeStamp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
