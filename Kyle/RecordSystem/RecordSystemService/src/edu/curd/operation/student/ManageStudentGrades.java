package edu.curd.operation.student;

import edu.curd.operation.*;

import edu.curd.dto.GadesDTO;
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

public class ManageStudentGrades implements JDBCOperation {

    @Override
    public void setContext(Properties properties) {
        this.contextProperties = properties;
    }

    private Properties contextProperties;

    public ManageStudentGrades(Properties contextProperties) {
        this.setContext(contextProperties);
    }


    @Override
    public List<Integer> create(List<JDBCDataObject> jdbcDataObjects) {

        if (jdbcDataObjects != null && jdbcDataObjects.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> returnKeys = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement insertStatemtn = null;

        String insertSQL = "INSERT INTO `classroom_records`.`grades`(`enrollment_id`,`exercises_id`,`grade`,`score`)VALUES(?, ? , ? , ?);";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                GadesDTO attendance = (GadesDTO) rawDTO;

                insertStatemtn.setInt(1, attendance.getEnrollmentId());
                insertStatemtn.setInt(2, attendance.getExcerciseId());
                insertStatemtn.setString(3, attendance.getGrade().toUpperCase());
                insertStatemtn.setString(4, attendance.getScore());

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
                    Logger.getLogger(ManageStudentGrades.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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
                returnObjects.add(new GadesDTO(results.getInt(1), results.getInt(2), results.getInt(3), results.getString(4), results.getString(5), results.getString(6)));
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

        StringBuilder selectSQL = new StringBuilder("SELECT * FROM `classroom_records`.`grades` WHERE 1=1 ");

        GadesDTO gradeDTO = (GadesDTO) jdbcDataObjects;

        if (gradeDTO.getGradesId() > 0) {
            selectSQL.append(" AND ").append("grades_id=").append(gradeDTO.getGradesId());
        } else {
            if (gradeDTO.getEnrollmentId() > 0) {
                selectSQL.append(" AND ").append("enrollment_id=").append(gradeDTO.getEnrollmentId());
            }
            if (gradeDTO.getExcerciseId() > 0) {
                selectSQL.append(" AND ").append("exercises_id=").append(gradeDTO.getExcerciseId());
            }
            if (gradeDTO.getGrade() != null) {
                selectSQL.append(" AND ").append("grade=").append("'").append(gradeDTO.getGrade().trim().toUpperCase()).append("'");
            }
        }
        return selectSQL;

    }

}
