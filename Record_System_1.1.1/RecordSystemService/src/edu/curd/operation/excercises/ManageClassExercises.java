package edu.curd.operation.excercises;

import edu.curd.operation.*;

import edu.curd.dto.ClassExercisesDTO;
import edu.curd.dto.ClassExercisesDTO;
import edu.curd.dto.StudentDTO;
import edu.dbConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageClassExercises implements JDBCOperation {

    @Override
    public void setContext(Properties properties) {
        this.contextProperties = properties;
    }

    private Properties contextProperties;

    public ManageClassExercises(Properties contextProperties) {
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

        String insertSQL = "INSERT INTO `classroom_records`.`exercises` (`class_id`, `exercises_type`) VALUES (?, ? );";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                ClassExercisesDTO classExDTO = (ClassExercisesDTO) rawDTO;

                insertStatemtn.setInt(1, classExDTO.getClassId());
                insertStatemtn.setString(2, classExDTO.getExcerciseType());

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
                    Logger.getLogger(ManageClassExercises.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> delete(List<JDBCDataObject> jdbcDataObjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Map<Integer,String> getTopicList(int excerciseId) {

        if (excerciseId <= 0) {
            return new HashMap<>();
        }

       Map<Integer,String> returnObjects = new HashMap<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement selectStatement = null;

        String selectSQL = "SELECT topic_id, topic FROM classroom_records.excercise_topic where exercises_id=?";

        try {
            selectStatement = connection.prepareStatement(selectSQL);
            selectStatement.setInt(1, excerciseId);
            ResultSet results = selectStatement.executeQuery();
            while (results.next()) {
                returnObjects.put(results.getInt(1), results.getString(2));
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
                returnObjects.add(new ClassExercisesDTO(results.getInt(1), results.getInt(2), results.getString(3), results.getString(4)));
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

        StringBuilder selectSQL = new StringBuilder("SELECT * FROM `classroom_records`.`exercises` WHERE 1=1 ");

        ClassExercisesDTO classExDTO = (ClassExercisesDTO) jdbcDataObjects;

        if (classExDTO.getExcerciseId() > 0) {
            selectSQL.append(" AND ").append("exercises_id=").append(classExDTO.getExcerciseId());
        } else {
            if (classExDTO.getClassId() > 0) {
                selectSQL.append(" AND ").append("class_id=").append(classExDTO.getClassId());
            }
            if (classExDTO.getExcerciseType() != null) {
                selectSQL.append(" AND ").append("exercises_type=").append("'").append(classExDTO.getExcerciseType().trim()).append("'");
            }
        }
        return selectSQL;

    }

    public boolean createTopic(int calssId, int excerciseId, String topic) {

        List<Integer> returnKeys = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement insertStatemtn = null;

        String insertSQL = "INSERT INTO `classroom_records`.`excercise_topic` (`exercises_id`,`topic`)VALUES (?,?);";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            insertStatemtn.setInt(1, excerciseId);
            insertStatemtn.setString(2, topic);

            insertStatemtn.executeUpdate();

            ResultSet rs = insertStatemtn.getGeneratedKeys();

            if (rs.next()) {
                returnKeys.add(rs.getInt(1));
            }

            connection.commit();
        } catch (SQLException e) {

            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException sqlError) {
                    Logger.getLogger(ManageClassExercises.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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
        return !returnKeys.isEmpty();
    }

}
