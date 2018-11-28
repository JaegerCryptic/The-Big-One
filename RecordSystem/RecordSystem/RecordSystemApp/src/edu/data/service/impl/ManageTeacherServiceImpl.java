/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.data.service.impl;

import edu.curd.dto.TeacherDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.teacher.ManageTeacher;
import edu.data.service.ManageTeacherService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aeron
 */
public class ManageTeacherServiceImpl implements ManageTeacherService {

    private static ManageTeacher manageTeacher = null;

    static {
        manageTeacher = new ManageTeacher();
    }

    @Override
    public int validatUser(String userName, String password) {
        int userId = -1;
        try {
            List<JDBCDataObject> dtoList = manageTeacher.read(new TeacherDTO(0, userName, password, null));

            if (dtoList != null && !dtoList.isEmpty()) {
                TeacherDTO teacher = (TeacherDTO) dtoList.get(0);
                userId = teacher.getTeacherId();
            }
        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return userId;
    }

    @Override
    public boolean updateUserPassword(int userId, String newPassword) {

        boolean operationStatus = false;
        try {
            List<JDBCDataObject> dtoList = new ArrayList<>();
            dtoList.add(new TeacherDTO(userId, null, newPassword, null));
            List<Integer> result = manageTeacher.update(dtoList);

            if (result != null && !result.isEmpty()) {
                operationStatus = (result.get(0) == userId);
            }

        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return operationStatus;
    }

}
