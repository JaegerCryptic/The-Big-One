package edu.curd.operation.student;

import edu.curd.dto.GradesDTO;
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
        prop.put("DB_URL", "jdbc:mysql://localhost/classroom_records?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        prop.put("DB_USER", "rootx");
        prop.put("DB_PASSWORD", "rootx123");
        manageAttendance = new ManageStudentGrades(prop);
    }

    /**
     * Test of create method, of class ManageStudentGrades.
     */
    @Test
    public void testCreate() {

        List<JDBCDataObject> attendanceList = new ArrayList<>();
        attendanceList.add(new GradesDTO(0, 1, 1, "8/10", null));
        attendanceList.add(new GradesDTO(0, 1, 1, "9/10", null));

        List<Integer> ids = manageAttendance.create(attendanceList);
        assertEquals(2, ids.size());

    }

    /**
     * Test of update method, of class ManageStudentGrades.
     */
    @Test
    public void testUpdate() {

        List<JDBCDataObject> attendanceList = new ArrayList<>();
        attendanceList = manageAttendance.read(new GradesDTO(0, 0, 0, "9/10", null));

        assertTrue("",attendanceList.size()>0);
    }

}
