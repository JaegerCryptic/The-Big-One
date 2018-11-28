/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public class ManageClassEnrollment implements JDBCOperation {

    public static void main(String... arg) {

        JDBCOperation manageClass = new ManageClassEnrollment();

        List<JDBCDataObject> classList = new ArrayList<>();
        classList.add(new EnrollmentDTO(0, 5, 1, null));

        List<Integer> ids = manageClass.create(classList);
        for (Integer intx : ids) {
            System.out.println("X " + intx);
        }
        /*   */
  

        // List<Integer> ids = manageClass.update(classList);
        //  for (Integer intx : ids) {
        //      System.out.println("X " + intx);
        //   }
        classList = manageClass.read(new EnrollmentDTO(1, 0, 0, null));
        //studentList = manageStudent.read(new StudentDTO(0, "Firstx", null, null, null, null, null, null));
        for (JDBCDataObject dto : classList) {
            EnrollmentDTO classDTO = (EnrollmentDTO) dto;
            System.out.println("X " + classDTO.getStudentId());
        }
    }

    @Override
    public List<Integer> create(List<JDBCDataObject> jdbcDataObjects) {

        if (jdbcDataObjects != null && jdbcDataObjects.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> returnKeys = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection();

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

        Connection connection = DatabaseConnection.getConnection();

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

}
