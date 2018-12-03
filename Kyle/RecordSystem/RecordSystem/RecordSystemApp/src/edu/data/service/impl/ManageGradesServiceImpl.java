package edu.data.service.impl;

import edu.config.PropertyLoader;
import edu.curd.dto.ClassExercisesDTO;
import edu.curd.dto.GradesDTO;
import edu.curd.dto.StudentGradesDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.excercises.ManageClassExercises;
import edu.curd.operation.student.ManageStudentGrades;
import edu.curd.operation.teacher.ManageTeacher;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.data.service.ManageGradesService;

public class ManageGradesServiceImpl implements ManageGradesService {

    private static ManageStudentGrades manageStudentGrades = null;

    static {
        manageStudentGrades = new ManageStudentGrades(PropertyLoader.getInstance().getProperties());
    }

    @Override
    public List<StudentGradesDTO> viewStudentGrades(int selectedClassId, int selectedExcercisesId, int selectedTopicId) {

        return manageStudentGrades.readGrades(selectedClassId, selectedExcercisesId, selectedTopicId);

    }

    @Override
    public boolean updateMarks(int gradesId, String newScore) {
        return manageStudentGrades.updateMarks(gradesId, newScore);
    }

    @Override
    public boolean insertMarks(int studentEnrollId, int selectedTopicId, String newScore) {

        List<JDBCDataObject> newMarks = new ArrayList<>();
        newMarks.add(new GradesDTO(0, studentEnrollId, selectedTopicId, newScore, null));

        List<Integer> ids = manageStudentGrades.create(newMarks);

        return !ids.isEmpty();
    }

}
