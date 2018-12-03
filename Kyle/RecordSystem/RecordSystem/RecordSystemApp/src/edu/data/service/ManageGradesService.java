
package edu.data.service;

import edu.curd.dto.StudentGradesDTO;
import java.util.List;


public interface ManageGradesService {

    public List<StudentGradesDTO> viewStudentGrades(int selectedClassId, int selectedExcercisesId, int selectedTopicId);

    public boolean updateMarks(int gradesId, String newScore);

    public boolean insertMarks(int studentEnrollId, int selectedTopicId, String newScore);
    
    
}
