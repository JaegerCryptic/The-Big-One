
package edu.curd.dto;

import edu.curd.operation.JDBCDataObject;


public class ClassDTO  implements JDBCDataObject {

    private int classId;
    private String topic;
    private String desription;
    private String timeStamp;

    public ClassDTO() {    }

    public ClassDTO(int classId, String topic, String desription, String timeStamp) {
        this.classId = classId;
        this.topic = topic;
        this.desription = desription;
        this.timeStamp = timeStamp;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
