package edu.data.service.impl;

import edu.config.PropertyLoader;
import edu.curd.dto.ClassExercisesDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.classes.ManageClass;
import edu.curd.operation.classes.ManageClassEnrollment;
import edu.curd.operation.excercises.ManageClassExercises;
import edu.curd.operation.student.ManageStudentAttendance;
import edu.curd.operation.teacher.ManageTeacher;
import edu.data.service.ClassExcercisesService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public class ClassExcercisesServiceImpl implements ClassExcercisesService {

    private static ManageClassExercises manageClassExercises = null;

    static {
        manageClassExercises = new ManageClassExercises(PropertyLoader.getInstance().getProperties());
    }

    @Override
    public List<ClassExercisesDTO> viewAllExcercisesForClass(int classId) {

        List<JDBCDataObject> resultSet = manageClassExercises.read(new ClassExercisesDTO(0, classId, null, null));

        List<ClassExercisesDTO> classExcersiseList = new ArrayList<>();

        if (resultSet != null && resultSet.size() > 0) {

            for (JDBCDataObject dto : resultSet) {
                classExcersiseList.add((ClassExercisesDTO) dto);
            }

        }
        return classExcersiseList;
    }

    @Override
    public boolean saveExcersise(int calssId, String excerciseName) {

        if (calssId <= 0 || excerciseName == null) {
            return false;
        }
        List<JDBCDataObject> excercise = new ArrayList<>();
        excercise.add(new ClassExercisesDTO(0, calssId, excerciseName, null));

        try {
            List<Integer> ids = manageClassExercises.create(excercise);

            if (ids != null && !ids.isEmpty()) {
                return true;
            }
        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return false;
    }

    @Override
    public Map<Integer,String> viewAllTopicsForExcercises(int selectedExcercisesId) {
        return manageClassExercises.getTopicList(selectedExcercisesId);
    }

    @Override
    public boolean saveTopic(int calssId, int excerciseId, String topic) {

        return manageClassExercises.createTopic(calssId, excerciseId, topic);

    }

}
