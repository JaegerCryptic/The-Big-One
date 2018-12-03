
package edu.data.service;

import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import java.util.List;

public interface ManageStudentService {
    
    int addNewStudent(StudentDTO student);
    
    List<JDBCDataObject> viewAllStudents();
    
    
    StudentDTO getStudentDetails(int studentId);
    
    boolean updateStudent(StudentDTO student);
}
