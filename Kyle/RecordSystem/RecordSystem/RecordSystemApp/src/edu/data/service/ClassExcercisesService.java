package edu.data.service;

import edu.curd.dto.ClassExercisesDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kyle
 */
public interface ClassExcercisesService {

    List<ClassExercisesDTO> viewAllExcercisesForClass(int classId);

    boolean saveExcersise(int calssId, String excercise);

    public Map<Integer,String> viewAllTopicsForExcercises(int selectedExcercisesId);

    boolean saveTopic(int calssId, int excerciseId, String topic);
}
