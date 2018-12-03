package edu.curd.operation.student;

import edu.curd.operation.*;

import edu.curd.dto.GradesDTO;
import edu.curd.dto.StudentGradesDTO;
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

        String insertSQL = "INSERT INTO `classroom_records`.`grades` (`enrollment_id`,`topic_id`,`score`) VALUES (?, ?, ?);";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                GradesDTO attendance = (GradesDTO) rawDTO;

                insertStatemtn.setInt(1, attendance.getEnrollmentId());
                insertStatemtn.setInt(2, attendance.getTopicId());
                insertStatemtn.setString(3, attendance.getScore());

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
                returnObjects.add(new GradesDTO(results.getInt(1), results.getInt(2), results.getInt(3), results.getString(4), results.getString(5)));
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

        GradesDTO gradeDTO = (GradesDTO) jdbcDataObjects;

        if (gradeDTO.getGradesId() > 0) {
            selectSQL.append(" AND ").append("grades_id=").append(gradeDTO.getGradesId());
        } else {
            if (gradeDTO.getEnrollmentId() > 0) {
                selectSQL.append(" AND ").append("enrollment_id=").append(gradeDTO.getEnrollmentId());
            }
            if (gradeDTO.getTopicId() > 0) {
                selectSQL.append(" AND ").append("topic_id=").append(gradeDTO.getTopicId());
            }
            if (gradeDTO.getScore() != null) {
                selectSQL.append(" AND ").append("score=").append("'").append(gradeDTO.getScore().trim()).append("'");
            }
        }
        return selectSQL;

    }

    public List<StudentGradesDTO> readGrades(int selectedClassId, int selectedExcercisesId, int selectedTopicId) {

        List<StudentGradesDTO> returnObjects = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement selectStatement = null;

        String selectSQL = "select grades_id, concat(st.first_name, '  ',st.last_name),  gr.score, gr.topic_id, en.enrollment_id  from student st JOIN enrollment en on en.student_id = st.student_id JOIN class cl on cl.class_id=en.class_id JOIN exercises ex on ex.class_id =cl.class_id LEFT outer join grades gr on gr.enrollment_id=en.enrollment_id where cl.class_id=? and ex.exercises_id=?";

        try {
            selectStatement = connection.prepareStatement(selectSQL);

            selectStatement.setInt(1, selectedClassId);
            selectStatement.setInt(2, selectedExcercisesId);
            ResultSet results = selectStatement.executeQuery();
            while (results.next()) {

                // Check for Topic
                // grades_id, concat(st.first_name, '  ',st.last_name),  gr.score, gr.topic_id 
                //if (results.getInt(4) == 0 || results.getInt(4) == selectedTopicId) {
                returnObjects.add(new StudentGradesDTO(results.getInt(1), results.getString(2), results.getString(3), results.getInt(4), results.getInt(5)));
                // }

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

    public boolean updateMarks(int gradesId, String newScore) {

        boolean isSuccess = false;

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement insertStatemtn = null;

        String insertSQL = "UPDATE `classroom_records`.`grades` SET `score` = ? WHERE `grades_id` = ?;";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            insertStatemtn.setString(1, newScore);
            insertStatemtn.setInt(2, gradesId);

            int count = insertStatemtn.executeUpdate();

            if (count > 0) {
                isSuccess = true;
            }

            connection.commit();
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
        return isSuccess;
    }

    public boolean insertMarks(int studentEnrollId, int selectedTopicId, String newScore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
