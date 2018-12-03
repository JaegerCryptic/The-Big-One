package edu.data.service;

import edu.curd.dto.AttendanceDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aeronx
 */
public interface ManageAttendenceService {
    
        public boolean saveAttendence(int classId, Map<String, String> markedStuendts);
        
        List<AttendanceDTO> viewStudentAttendence(int classId, String date);

}
