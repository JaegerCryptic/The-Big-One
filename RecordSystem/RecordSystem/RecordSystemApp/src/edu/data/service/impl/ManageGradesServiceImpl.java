
package edu.data.service.impl;

import edu.config.PropertyLoader;
import edu.curd.dto.ClassExercisesDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.excercises.ManageClassExercises;
import edu.curd.operation.teacher.ManageTeacher;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.data.service.ManageGradesService;

public class ManageGradesServiceImpl implements ManageGradesService {

    private static ManageClassExercises manageClassExercises = null;

    static {
        manageClassExercises = new ManageClassExercises(PropertyLoader.getInstance().getProperties());
    }

    @Override
    public boolean saveExcersise(int calssId, String excerciseName) {

        if(calssId <=0 || excerciseName==null){
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

}
