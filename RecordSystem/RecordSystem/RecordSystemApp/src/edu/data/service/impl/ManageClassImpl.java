/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.data.service.impl;

import edu.curd.dto.ClassDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.classes.ManageClass;
import edu.curd.operation.teacher.ManageTeacher;
import edu.data.service.ManageClassService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aeron
 */
public class ManageClassImpl implements ManageClassService {

    private static ManageClass manageClass = null;

    static {
        manageClass = new ManageClass();
    }

    @Override
    public boolean addClass(String classTopic, String classDescription) {

        List<JDBCDataObject> classList = new ArrayList<>();
        classList.add(new ClassDTO(0, classTopic, classDescription, null));

        try {
            List<Integer> ids = manageClass.create(classList);

            if (ids != null && !ids.isEmpty()) {
                return true;
            }
        } catch (Exception error) {
            Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", error);
        }
        return false;
    }

    @Override
    public List<JDBCDataObject> viewAllClasses() {
        return manageClass.read(new ClassDTO(0,null,null,null));
    }

}
