package edu.curd.operation.classes;

import edu.curd.dto.ClassDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.JDBCOperation;
import edu.curd.operation.student.ManageStudent;
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
public class ManageClassTest {

    public ManageClassTest() {
    }

    static JDBCOperation manageClass;
    static Properties prop = null;

    @BeforeClass
    public static void setUpClass() {
        prop = new Properties();
        prop.put("DB_URL", "jdbc:mysql://localhost:3306/classroom_records");
        prop.put("DB_USER", "root");
        prop.put("DB_PASSWORD", "root123");
        manageClass = new ManageClass(prop);
    }

    /**
     * Test of create method, of class ManageClass.
     */
    @Test
    public void testCreate() {
        List<JDBCDataObject> classList = new ArrayList<>();
        classList.add(new ClassDTO(0, "Enterprise Systems", "Enterprise Subject", null));

        List<Integer> ids = manageClass.create(classList);

        assertEquals(1, ids.size());
    }

    /**
     * Test of update method, of class ManageClass.
     */
    @Test
    public void testUpdate() {

        List<JDBCDataObject> classList = new ArrayList<>();
        classList = new ArrayList<>();
        classList.add(new ClassDTO(1, "Intro to Programming 1", "Intro to Programming Intro", null));

        List<Integer> ids = manageClass.update(classList);

        assertNotNull(ids);
    }

    /**
     * Test of read method, of class ManageClass.
     */
    @Test
    public void testRead() {

        List<JDBCDataObject> classList = new ArrayList<>();
        classList = manageClass.read(new ClassDTO(1, null, null, null));
        assertNotNull(classList);
    }

}
