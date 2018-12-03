
package edu.data.service.impl;

import edu.config.PropertyLoader;
import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.student.ManageStudent;
import edu.curd.operation.teacher.ManageTeacher;
import edu.data.service.ManageStudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageStudentServiceImpl implements ManageStudentService {

    private static ManageStudent manageStudent = null;

    static {
        manageStudent = new ManageStudent(PropertyLoader.getInstance().getProperties());
    }

    @Override
    public int addNewStudent(StudentDTO student) {

        int returnId = 0;
        List<JDBCDataObject> studentList = new ArrayList<>();
        studentList.add(student);

        try {
            List<Integer> ids = manageStudent.create(studentList);

            if (ids != null && !ids.isEmpty()) {
                returnId = ids.get(0);
            }
        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return returnId;
    }

    @Override
    public List<JDBCDataObject> viewAllStudents() {
        return manageStudent.read(new StudentDTO(0, null, null, null, null, null, null, null));
    }

    @Override
    public boolean updateStudent(StudentDTO student) {
        List<JDBCDataObject> studentList = new ArrayList<>();
        studentList.add(student);

        try {
            List<Integer> ids = manageStudent.update(studentList);

            if (ids != null && !ids.isEmpty()) {
                return true;
            }
        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return false;
    }

    @Override
    public StudentDTO getStudentDetails(int studentId) {

        try {
            List<JDBCDataObject> studnetList = manageStudent.read(new StudentDTO(studentId, null, null, null, null, null, null, null));

            if (studnetList != null && !studnetList.isEmpty()) {
                return (StudentDTO) studnetList.get(0);
            }
        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return null;
    }

}
