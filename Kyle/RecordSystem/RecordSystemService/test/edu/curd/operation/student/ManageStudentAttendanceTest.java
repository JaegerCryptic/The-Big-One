package edu.curd.operation.student;

import edu.curd.dto.AttendanceDTO;
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
 * @author Kyle
 */
public class ManageStudentAttendanceTest {
    
    public ManageStudentAttendanceTest() {
    }
    
    static JDBCOperation manageAttendance;
    static Properties prop = null;

    @BeforeClass
    public static void setUpClass() {
        prop = new Properties();
        prop.put("DB_URL", "jdbc:mysql://localhost:3306/classroom_records");
        prop.put("DB_USER", "root");
        prop.put("DB_PASSWORD", "root123");
        manageAttendance = new ManageStudentAttendance(prop);
    }
    


    /**
     * Test of create method, of class ManageStudentAttendance.
     */
    @Test
    public void testCreate() {

       
        List<JDBCDataObject> attendanceList = new ArrayList<>();
        attendanceList.add(new AttendanceDTO(0,null, 1, 1, 2, null));
        attendanceList.add(new AttendanceDTO(0,null, 3, 1, 1, null));

        List<Integer> ids = manageAttendance.create(attendanceList);
       assertEquals(2, ids.size());

    }



    /**
     * Test of read method, of class ManageStudentAttendance.
     */
    @Test
    public void testRead() {
       
        List<JDBCDataObject> attendanceList = new ArrayList<>();
        attendanceList = manageAttendance.read(new AttendanceDTO(1,null, 0, 0, 0, null));

         assertNotNull(attendanceList);
    }
    
}
