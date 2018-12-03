/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curd.operation.teacher;

import edu.curd.dto.TeacherDTO;
import edu.curd.operation.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aeron
 */
public class ManageTeacherTest {

    public ManageTeacherTest() {
    }

    static JDBCOperation manageTeacher;
    static Properties prop = null;

    @BeforeClass
    public static void setUpClass() {
        prop = new Properties();
        prop.put("DB_URL", "jdbc:mysql://localhost:3306/classroom_records");
        prop.put("DB_USER", "root");
        prop.put("DB_PASSWORD", "root123");
        manageTeacher = new ManageTeacher(prop);
    }

    /**
     * Test of create method, of class ManageTeacher.
     */
    @Test
    public void testCreate() {

        List<JDBCDataObject> teacherList = new ArrayList<>();
        teacherList.add(new TeacherDTO(0, "test1", "test123", null));
        teacherList.add(new TeacherDTO(0, "test2", "test123", null));
        List<Integer> ids = manageTeacher.create(teacherList);

        assertTrue(ids.size() == 2);
    }

    /**
     * Test of update method, of class ManageTeacher.
     */
    @Test
    public void testUpdate() {

        List<JDBCDataObject> teacherList = new ArrayList<>();
        teacherList.add(new TeacherDTO(1, null, "123432", null));
        List<Integer> ids = manageTeacher.update(teacherList);

        assertTrue(ids.size() == 1);
    }

    /**
     * Test of delete method, of class ManageTeacher.
     */
    /**
     * Test of read method, of class ManageTeacher.
     */
    @Test
    public void testRead() {
        List<JDBCDataObject> teacherList = new ArrayList<>();
        teacherList = manageTeacher.read(new TeacherDTO(1, null, "123432", null));

        assertTrue(teacherList.get(0) != null);
    }

}
