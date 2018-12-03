
package edu.curd.operation.classes;

import edu.curd.operation.*;

import edu.curd.dto.EnrollmentDTO;
import edu.curd.dto.StudentDTO;
import edu.dbConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageClassEnrollment implements JDBCOperation {


    @Override
    public List<Integer> create(List<JDBCDataObject> jdbcDataObjects) {

        if (jdbcDataObjects != null && jdbcDataObjects.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> returnKeys = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement insertStatemtn = null;

        String insertSQL = "INSERT INTO `classroom_records`.`enrollment` (`student_id`,`class_id`) VALUES (?,?);";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                EnrollmentDTO classDTO = (EnrollmentDTO) rawDTO;

                insertStatemtn.setInt(1, classDTO.getStudentId());
                insertStatemtn.setInt(2, classDTO.getClassId());

                insertStatemtn.executeUpdate();

                ResultSet rs = insertStatemtn.getGeneratedKeys();

                if (rs.next()) {
                    returnKeys.add(rs.getInt(1));
                }

                connection.commit();
            }
        } catch (SQLException e) {

            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException sqlError) {
                    Logger.getLogger(ManageClassEnrollment.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
                }
            }
        } finally {

            if (insertStatemtn != null) {
                try {
                    insertStatemtn.close();
                } catch (SQLException ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException ex) {
                }
            }
        }
        return returnKeys;
    }

    @Override
    public List<Integer> update(List<JDBCDataObject> jdbcDataObjects) {
        return null;
    }

    @Override
    public List<Integer> delete(List<JDBCDataObject> jdbcDataObjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JDBCDataObject> read(JDBCDataObject jdbcDataObjects) {

        if (jdbcDataObjects == null) {
            return new ArrayList<>();
        }

        List<JDBCDataObject> returnObjects = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement selectStatement = null;

        StringBuilder selectSQL = generateSelectStatment(jdbcDataObjects);

        try {
            selectStatement = connection.prepareStatement(selectSQL.toString());
            ResultSet results = selectStatement.executeQuery();
            while (results.next()) {
                returnObjects.add(new EnrollmentDTO(results.getInt(1), results.getInt(2), results.getInt(3), results.getString(4)));
            }
        } catch (SQLException e) {
            System.err.print("Erro while listing data.");
        } finally {

            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException ex) {
                }
            }
        }
        return returnObjects;
    }

    public List<StudentDTO> readEnrolledStudents(int classId) {

        List<StudentDTO> returnObjects = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement selectStatement = null;

        String selectSQL = " SELECT distinct st.student_id,enrollment_id, first_name, last_name FROM `classroom_records`.`student` st join `classroom_records`.`enrollment` enr on st.student_id = enr.student_id WHERE 1=1  AND class_id=?";

            try {
                selectStatement = connection.prepareStatement(selectSQL);
                selectStatement.setInt(1, classId);
                
                ResultSet results = selectStatement.executeQuery();
                while (results.next()) {
                    returnObjects.add(new StudentDTO(results.getInt(1),results.getInt(2), results.getString(3), results.getString(4), null, null,null,null,null));
                }
            } catch (SQLException e) {
                System.err.print("Erro while listing data.");
            } finally {

                if (selectStatement != null) {
                    try {
                        selectStatement.close();
                    } catch (SQLException ex) {
                    }
                }
                if (connection != null) {
                    try {
                        connection.setAutoCommit(true);
                        connection.close();
                    } catch (SQLException ex) {
                    }
                }
            }
            return returnObjects;
        }


    

    private StringBuilder generateSelectStatment(JDBCDataObject jdbcDataObjects) {

        StringBuilder selectSQL = new StringBuilder("SELECT * FROM `classroom_records`.`enrollment` WHERE 1=1 ");

        EnrollmentDTO classDTO = (EnrollmentDTO) jdbcDataObjects;

        if (classDTO.getEnrollmentId() > 0) {
            selectSQL.append(" AND ").append("enrollment_id=").append(classDTO.getEnrollmentId());
        } else {
            if (classDTO.getClassId() > 0) {
                selectSQL.append(" AND ").append("class_id=").append(classDTO.getClassId());
            }
            if (classDTO.getStudentId() > 0) {
                selectSQL.append(" AND ").append("student_id=").append(classDTO.getStudentId());
            }
        }
        return selectSQL;

    }
    
    
        @Override
    public void setContext(Properties properties) {
        this.contextProperties = properties;
    }

    private Properties contextProperties;

    public ManageClassEnrollment(Properties contextProperties) {
        this.setContext(contextProperties);
    }

}
