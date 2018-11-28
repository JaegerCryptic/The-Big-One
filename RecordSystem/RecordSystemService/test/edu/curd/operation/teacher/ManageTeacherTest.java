/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curd.operation.teacher;

import edu.curd.operation.*;

import java.util.List;
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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ManageTeacher.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] arg = null;
        ManageTeacher.main(arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ManageTeacher.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        List<JDBCDataObject> jdbcDataObjects = null;
        ManageTeacher instance = new ManageTeacher();
        List<Integer> expResult = null;
        List<Integer> result = instance.create(jdbcDataObjects);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ManageTeacher.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        List<JDBCDataObject> jdbcDataObjects = null;
        ManageTeacher instance = new ManageTeacher();
        List<Integer> expResult = null;
        List<Integer> result = instance.update(jdbcDataObjects);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ManageTeacher.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        List<JDBCDataObject> jdbcDataObjects = null;
        ManageTeacher instance = new ManageTeacher();
        List<Integer> expResult = null;
        List<Integer> result = instance.delete(jdbcDataObjects);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class ManageTeacher.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        JDBCDataObject jdbcDataObjects = null;
        ManageTeacher instance = new ManageTeacher();
        List<JDBCDataObject> expResult = null;
        List<JDBCDataObject> result = instance.read(jdbcDataObjects);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
