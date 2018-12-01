package edu.curd.operation.student;

import edu.curd.dto.GadesDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.JDBCOperation;
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
public class ManageStudentGradesTest {

    public ManageStudentGradesTest() {
    }

    static JDBCOperation manageAttendance;
    static Properties prop = null;

    @BeforeClass
    public static void setUpClass() {
        prop = new Properties();
        prop.put("DB_URL", "jdbc:mysql://localhost:3306/classroom_records");
        prop.put("DB_USER", "root");
        prop.put("DB_PASSWORD", "root123");
        manageAttendance = new ManageStudentGrades(prop);
    }

    /**
     * Test of create method, of class ManageStudentGrades.
     */
    @Test
    public void testCreate() {

        List<JDBCDataObject> attendanceList = new ArrayList<>();
        attendanceList.add(new GadesDTO(0, 1, 1, "Pass", "50", null));
        attendanceList.add(new GadesDTO(0, 1, 2, "Fail", "20", null));

        List<Integer> ids = manageAttendance.create(attendanceList);
        assertEquals(2, ids.size());

    }

    /**
     * Test of update method, of class ManageStudentGrades.
     */
    @Test
    public void testUpdate() {

        List<JDBCDataObject> attendanceList = new ArrayList<>();
        attendanceList = manageAttendance.read(new GadesDTO(0, 0, 0, "Pass", null, null));

        assertTrue("",attendanceList.size()>0);
    }

}
