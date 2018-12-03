package edu.curd.operation.student;

import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.JDBCOperation;
import edu.curd.operation.teacher.ManageTeacher;
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
public class ManageStudentTest {

    public ManageStudentTest() {
    }

    static JDBCOperation manageStudent;
    static Properties prop = null;

    @BeforeClass
    public static void setUpClass() {
        prop = new Properties();
        prop.put("DB_URL", "jdbc:mysql://localhost:3306/classroom_records");
        prop.put("DB_USER", "root");
        prop.put("DB_PASSWORD", "root123");
        manageStudent = new ManageStudent(prop);
    }

    /**
     * Test of create method, of class ManageStudent.
     */
    @Test
    public void testCreate() {

        List<JDBCDataObject> studentList = new ArrayList<>();
        studentList.add(new StudentDTO(0, "First", "Last", "M", "12-2-2000", "1231234314", "5 54 TEst Road ViC ", null));
        studentList.add(new StudentDTO(0, "Firstx", "Lastx", "F", "12-2-2001", "67867868", "7 54 TEst Road ViC ", null));

        List<Integer> ids = manageStudent.create(studentList);

        assertEquals(2, ids.size());

    }

    /**
     * Test of update method, of class ManageStudent.
     */
    @Test
    public void testUpdate() {

        List<JDBCDataObject> studentList = new ArrayList<>();
        studentList = new ArrayList<>();
        studentList.add(new StudentDTO(1, "Mr First", "Mr Last", "T", "20-2-2000", "123123431477", "8 54 TEst Road ViC ", null));

        List<Integer> ids = manageStudent.update(studentList);

        assertTrue(1 == ids.get(0));

    }

    /**
     * Test of read method, of class ManageStudent.
     */
    @Test
    public void testRead() {

        List<JDBCDataObject> studentList = new ArrayList<>();
        studentList = manageStudent.read(new StudentDTO(0, "Firstx", null, null, null, null, null, null));

        StudentDTO tacher = (StudentDTO) studentList.get(0);

        assertEquals("Firstx", tacher.getFirstName());

    }

}
