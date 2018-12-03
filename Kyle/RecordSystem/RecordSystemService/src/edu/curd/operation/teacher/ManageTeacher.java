
package edu.curd.operation.teacher;

import edu.curd.operation.*;

import edu.curd.dto.TeacherDTO;
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

public class ManageTeacher implements JDBCOperation {

                            @Override
    public void setContext(Properties properties) {
        this.contextProperties = properties;
    }

    private Properties contextProperties;

    public ManageTeacher(Properties contextProperties) {
        this.setContext(contextProperties);
    }
    public static void main(String... arg) {

    }

    @Override
    public List<Integer> create(List<JDBCDataObject> jdbcDataObjects) {

        if (jdbcDataObjects != null && jdbcDataObjects.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> returnKeys = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement insertStatemtn = null;

        String insertSQL = "INSERT INTO `classroom_records`.`teacher`(`username`,`password`)VALUES(? , ?);";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                TeacherDTO teacher = (TeacherDTO) rawDTO;

                insertStatemtn.setString(1, teacher.getUserName());
                insertStatemtn.setString(2, teacher.getPassword());
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
                    Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement updateStatemtn = null;

        String updateSQL = "UPDATE `classroom_records`.`teacher` SET `password` =? WHERE `teacher_id` = ?;";

        try {
            connection.setAutoCommit(false);
            updateStatemtn = connection.prepareStatement(updateSQL);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                TeacherDTO teacher = (TeacherDTO) rawDTO;

                updateStatemtn.setString(1, teacher.getPassword());
                updateStatemtn.setInt(2, teacher.getTeacherId());

                if (updateStatemtn.executeUpdate() > 0) {
                    returnKeys.add(teacher.getTeacherId());
                }

                connection.commit();
            }
        } catch (SQLException e) {

            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException sqlError) {
                    Logger.getLogger(ManageTeacher.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement selectStatement = null;

        StringBuilder selectSQL = generateSelectStatment(jdbcDataObjects);

        try {
            selectStatement = connection.prepareStatement(selectSQL.toString());
            ResultSet results = selectStatement.executeQuery();
            while (results.next()) {
                returnObjects.add(new TeacherDTO(results.getInt(1), results.getString(2), results.getString(3), results.getString(4)));
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

        StringBuilder selectSQL = new StringBuilder("SELECT * FROM `classroom_records`.`teacher` WHERE 1=1 ");

        TeacherDTO teacher = (TeacherDTO) jdbcDataObjects;

        if (teacher.getTeacherId() > 0) {
            selectSQL.append(" AND ").append("teacher_id=").append(teacher.getTeacherId());
        } else {
            if (teacher.getPassword() != null) {
                selectSQL.append(" AND ").append("password=").append("'").append(teacher.getPassword().trim()).append("'");
            }
            if (teacher.getUserName() != null) {
                selectSQL.append(" AND ").append("username=").append("'").append(teacher.getUserName().trim()).append("'");
            }
        }
        return selectSQL;

    }

}
