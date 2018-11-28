/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.data.service;

import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import java.util.List;

/**
 *
 * @author Kyle
 */
public interface ManageStudentService {
    
    int addNewStudent(StudentDTO student);
    
    List<JDBCDataObject> viewAllStudents();
    
    
    StudentDTO getStudentDetails(int studentId);
    
    boolean updateStudent(StudentDTO student);
}
