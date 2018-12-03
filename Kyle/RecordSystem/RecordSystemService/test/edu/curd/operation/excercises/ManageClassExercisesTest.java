package edu.curd.operation.excercises;

import edu.curd.dto.ClassExercisesDTO;
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
 * @author Kyle
 */
public class ManageClassExercisesTest {

    public ManageClassExercisesTest() {
    }

    static JDBCOperation manageClass;
    static Properties prop = null;

    @BeforeClass
    public static void setUpClass() {
        prop = new Properties();
        prop.put("DB_URL", "jdbc:mysql://localhost:3306/classroom_records");
        prop.put("DB_USER", "root");
        prop.put("DB_PASSWORD", "root123");
        manageClass = new ManageClassExercises(prop);
    }

    /**
     * Test of create method, of class ManageClassExercises.
     */
    @Test
    public void testCreate() {

        List<JDBCDataObject> classList = new ArrayList<>();
        classList.add(new ClassExercisesDTO(0, 1, "Assignent", null));

        List<Integer> ids = manageClass.create(classList);
        assertEquals(1, ids.size());

    }

    /**
     * Test of read method, of class ManageClassExercises.
     */
    @Test
    public void testRead() {

        List<JDBCDataObject> classList = new ArrayList<>();

        classList = manageClass.read(new ClassExercisesDTO(1, 0, null, null));
        
        assertTrue("",classList.size()>0);
    }

}
