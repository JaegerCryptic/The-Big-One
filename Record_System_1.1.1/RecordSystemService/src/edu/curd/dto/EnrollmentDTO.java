
package edu.curd.dto;

import edu.curd.operation.JDBCDataObject;

/**
 *
 * @author Aeron
 */
public class EnrollmentDTO implements JDBCDataObject {

    private int classId;
    private int enrollmentId;
    private int studentId;
    private String timeStamp;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(
            int enrollmentId,
            int studentId,
            int classId,
            String timeStamp) {
        this.classId = classId;
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.timeStamp = timeStamp;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
