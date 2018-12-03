package edu.data.service.impl;

import edu.config.PropertyLoader;
import edu.curd.dto.AttendanceDTO;
import edu.curd.dto.ClassDTO;
import edu.curd.dto.ClassExercisesDTO;
import edu.curd.dto.EnrollmentDTO;
import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.classes.ManageClass;
import edu.curd.operation.classes.ManageClassEnrollment;
import edu.curd.operation.excercises.ManageClassExercises;
import edu.curd.operation.student.ManageStudentAttendance;
import edu.curd.operation.teacher.ManageTeacher;
import edu.data.service.ManageClassService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageClassImpl implements ManageClassService {

    private static ManageClass manageClass = null;
    private static ManageClassEnrollment manageClassEnrollment = null;

    static {
        manageClass = new ManageClass(PropertyLoader.getInstance().getProperties());
        manageClassEnrollment = new ManageClassEnrollment(PropertyLoader.getInstance().getProperties());
    }

    @Override
    public int addClass(String classTopic, String classDescription) {

        List<JDBCDataObject> classList = new ArrayList<>();
        classList.add(new ClassDTO(0, classTopic, classDescription, null));

        try {
            List<Integer> ids = manageClass.create(classList);

            if (ids != null && !ids.isEmpty()) {
                return ids.get(0);
            }
        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return 0;
    }

    @Override
    public List<JDBCDataObject> viewAllClasses() {
        return manageClass.read(new ClassDTO(0, null, null, null));
    }

    @Override
    public boolean saveEnrollment(int classId, Set<String> stuendIdList) {

        List<JDBCDataObject> classEnrollmentList = new ArrayList<>();

        for (String studnetId : stuendIdList) {
            classEnrollmentList.add(new EnrollmentDTO(0, Integer.valueOf(studnetId.trim()), classId, null));
        }

        List<Integer> newRegistrations = manageClassEnrollment.create(classEnrollmentList);

        return newRegistrations != null && newRegistrations.size() == classEnrollmentList.size();
    }

    @Override
    public List<EnrollmentDTO> viewEnrolledStuentIDs(int selectedClassId) {

        List<JDBCDataObject> resultSet = manageClassEnrollment.read(new EnrollmentDTO(0, 0, selectedClassId, null));

        List<EnrollmentDTO> studentList = new ArrayList<>();

        if (resultSet != null && resultSet.size() > 0) {

            for (JDBCDataObject dto : resultSet) {
                studentList.add((EnrollmentDTO) dto);
            }

        }
        return studentList;
    }

    @Override
    public List<StudentDTO> viewEnrolledStuents(int selectedClassId) {
        return manageClassEnrollment.readEnrolledStudents(selectedClassId);
    }



}
