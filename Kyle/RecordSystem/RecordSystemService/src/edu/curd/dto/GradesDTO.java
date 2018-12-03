
package edu.curd.dto;

import edu.curd.operation.JDBCDataObject;

/**
 *
 * @author Kyle
 */
public class GradesDTO implements JDBCDataObject {

    private int gradesId;
    private int enrollmentId;
    private int topicId;
    private String score;
    private String timeStamp;

    public GradesDTO() {
    }
    
    public GradesDTO(int gradesId,
            int enrollmentId,
            int topicId,
            String score,
            String timeStamp) {

        this.gradesId = gradesId;
        this.enrollmentId = enrollmentId;
        this.topicId = topicId;
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

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
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
