/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curd.operation.student;

import edu.curd.operation.*;

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
 * @author Aeron
 */
public class ManageStudent implements JDBCOperation {

    public static void main(String... arg) {

        JDBCOperation manageStudent = new ManageStudent();

        List<JDBCDataObject> studentList = new ArrayList<>();
        studentList.add(new StudentDTO(0, "First", "Last", "M", "12-2-2000", "1231234314", "5 54 TEst Road ViC ", null));
        studentList.add(new StudentDTO(0, "Firstx", "Lastx", "F", "12-2-2001", "67867868", "7 54 TEst Road ViC ", null));

        //List<Integer> ids = manageStudent.create(studentList);
        // for (Integer intx : ids) {
        //    System.out.println("X " + intx);
        // }
        studentList = new ArrayList<>();
        studentList.add(new StudentDTO(4, "Mr First", "Mr Last", "T", "20-2-2000", "123123431477", "8 54 TEst Road ViC ", null));

        //  List<Integer> ids = manageStudent.update(studentList);
        //studentList = manageStudent.read(new StudentDTO(4, null, null, null, null, null, null, null));
        studentList = manageStudent.read(new StudentDTO(0, "Firstx", null, null, null, null, null, null));
        for (JDBCDataObject dto : studentList) {
            StudentDTO tacher = (StudentDTO) dto;
            System.out.println("X " + tacher.getFirstName());
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

        String insertSQL = "INSERT INTO `classroom_records`.`student` (`first_name`,`last_name`,`gender`,`dob`,`phone`,`address`) VALUES(? , ? , ?, ? , ? , ? );";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                StudentDTO student = (StudentDTO) rawDTO;

                insertStatemtn.setString(1, student.getFirstName());
                insertStatemtn.setString(2, student.getLastName());
                insertStatemtn.setString(3, student.getGender());
                insertStatemtn.setString(4, student.getDob());
                insertStatemtn.setString(5, student.getPhone());
                insertStatemtn.setString(6, student.getAddress());

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
                    Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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

        if (jdbcDataObjects != null && jdbcDataObjects.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> returnKeys = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement updateStatemtn = null;

        String updateSQL = "UPDATE `classroom_records`.`student` SET `first_name` =?, `last_name` =?,`gender` = ?,`dob` = ?,`phone` =?,`address` = ? WHERE `student_id` = ?;";

        try {
            connection.setAutoCommit(false);
            updateStatemtn = connection.prepareStatement(updateSQL);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                StudentDTO student = (StudentDTO) rawDTO;

                if (student.getStudentId() > 0) {
                    updateStatemtn.setString(1, student.getFirstName());
                    updateStatemtn.setString(2, student.getLastName());
                    updateStatemtn.setString(3, student.getGender());
                    updateStatemtn.setString(4, student.getDob());
                    updateStatemtn.setString(5, student.getPhone());
                    updateStatemtn.setString(6, student.getAddress());
                    updateStatemtn.setInt(7, student.getStudentId());
                    if (updateStatemtn.executeUpdate() > 0) {
                        returnKeys.add(student.getStudentId());
                    }
                    connection.commit();
                }

            }
        } catch (SQLException e) {

            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException sqlError) {
                    Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
                }
            }
        } finally {

            if (updateStatemtn != null) {
                try {
                    updateStatemtn.close();
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
                returnObjects.add(new StudentDTO(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7), results.getString(8))
                );
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

        StringBuilder selectSQL = new StringBuilder("SELECT * FROM `classroom_records`.`student` WHERE 1=1 ");

        StudentDTO student = (StudentDTO) jdbcDataObjects;

        if (student.getStudentId() > 0) {
            selectSQL.append(" AND ").append("student_id=").append(student.getStudentId());
        } else {
            if (student.getFirstName() != null) {
                selectSQL.append(" AND ").append("first_name=").append("'").append(student.getFirstName().trim()).append("'");
            }
            if (student.getLastName() != null) {
                selectSQL.append(" AND ").append("last_name=").append("'").append(student.getLastName().trim()).append("'");
            }
            if (student.getGender() != null) {
                selectSQL.append(" AND ").append("gender=").append("'").append(student.getGender().trim()).append("'");
            }
            if (student.getDob() != null) {
                selectSQL.append(" AND ").append("dob=").append("'").append(student.getDob().trim()).append("'");
            }
            if (student.getPhone() != null) {
                selectSQL.append(" AND ").append("phone=").append("'").append(student.getPhone().trim()).append("'");
            }
            if (student.getAddress() != null) {
                selectSQL.append(" AND ").append("address=").append("'").append(student.getAddress().trim()).append("'");
            }
            if (student.getTimeStamp() != null) {
                selectSQL.append(" AND ").append("created_ts=").append("'").append(student.getTimeStamp().trim()).append("'");
            }
        }
        return selectSQL;

    }

}
