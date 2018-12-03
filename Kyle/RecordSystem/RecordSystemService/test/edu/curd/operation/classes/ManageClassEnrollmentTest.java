package edu.curd.operation.classes;

import edu.curd.dto.EnrollmentDTO;
import edu.curd.dto.StudentDTO;
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
public class ManageClassEnrollmentTest {

    public ManageClassEnrollmentTest() {
    }

    static JDBCOperation manageClass;
    static Properties prop = null;

    @BeforeClass
    public static void setUpClass() {
        prop = new Properties();
        prop.put("DB_URL", "jdbc:mysql://localhost:3306/classroom_records");
        prop.put("DB_USER", "root");
        prop.put("DB_PASSWORD", "root123");
        manageClass = new ManageClassEnrollment(prop);
    }

    /**
     * Test of create method, of class ManageClassEnrollment.
     */
    @Test
    public void testCreate() {

        List<JDBCDataObject> classList = new ArrayList<>();
        classList.add(new EnrollmentDTO(0, 5, 1, null));

        List<Integer> ids = manageClass.create(classList);
        assertEquals(1, ids.size());

    }

    /**
     * Test of read method, of class ManageClassEnrollment.
     */
    @Test
    public void testRead() {

        List<JDBCDataObject> classList = new ArrayList<>();

        classList = manageClass.read(new EnrollmentDTO(1, 0, 0, null));

        assertNotNull(classList);
    }

}
