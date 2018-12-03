package edu.data.service;

import edu.curd.dto.ClassExercisesDTO;
import edu.curd.dto.EnrollmentDTO;
import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ManageClassService {

    int addClass(String classTopic, String classDescription);

    List<JDBCDataObject> viewAllClasses();

    public boolean saveEnrollment(int key, Set<String> asList);

    public List<EnrollmentDTO> viewEnrolledStuentIDs(int selectedClassId);

    public List<StudentDTO> viewEnrolledStuents(int selectedClassId);

}
