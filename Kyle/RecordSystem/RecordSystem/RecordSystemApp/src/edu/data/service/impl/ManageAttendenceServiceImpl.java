package edu.data.service.impl;

import edu.config.PropertyLoader;
import edu.curd.dto.AttendanceDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.classes.ManageClass;
import edu.curd.operation.classes.ManageClassEnrollment;
import edu.curd.operation.student.ManageStudentAttendance;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import edu.data.service.ManageAttendenceService;

/**
 *
 * @author Kyle
 */
public class ManageAttendenceServiceImpl implements ManageAttendenceService {

    private static ManageStudentAttendance manageStudentAttendance = null;

    static {
        manageStudentAttendance = new ManageStudentAttendance(PropertyLoader.getInstance().getProperties());
    }

    @Override
    public boolean saveAttendence(int classId, Map<String, String> markedStuendts) {

        List<JDBCDataObject> attendanceList = new ArrayList<>();

        markedStuendts.keySet().forEach((studentId) -> {
            attendanceList.add(new AttendanceDTO(0,null, Integer.valueOf(markedStuendts.get(studentId)), Integer.valueOf(studentId), classId, null));
        });

        List<Integer> ids = manageStudentAttendance.create(attendanceList);

        return ids != null && ids.size() == markedStuendts.size();

    }

    @Override
    public List<AttendanceDTO> viewStudentAttendence(int classId, String date) {

      List<JDBCDataObject> returnList= manageStudentAttendance.read( classId, date);

      List<AttendanceDTO> finalList = new ArrayList<>();
      
      if(returnList!=null && returnList.size()>0){
          returnList.forEach((returnObj) -> {
              finalList.add((AttendanceDTO)returnObj);
          });
      }
      return  finalList;
    }

}
