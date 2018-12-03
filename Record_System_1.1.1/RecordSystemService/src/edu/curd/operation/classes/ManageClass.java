package edu.curd.operation.classes;

import edu.curd.operation.student.*;
import edu.curd.operation.student.*;
import edu.curd.operation.*;

import edu.curd.dto.ClassDTO;
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

public class ManageClass implements JDBCOperation {


    @Override
    public List<Integer> create(List<JDBCDataObject> jdbcDataObjects) {

        if (jdbcDataObjects != null && jdbcDataObjects.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> returnKeys = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection(contextProperties);

        PreparedStatement insertStatemtn = null;

        String insertSQL = "INSERT INTO `classroom_records`.`class` (`topic`,`description`) VALUES(? , ? );";

        try {
            connection.setAutoCommit(false);
            insertStatemtn = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                ClassDTO classDTO = (ClassDTO) rawDTO;

                insertStatemtn.setString(1, classDTO.getTopic());
                insertStatemtn.setString(2, classDTO.getDesription());

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
                    Logger.getLogger(ManageClass.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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

        Connection connection = DatabaseConnection.getConnection(this.contextProperties);

        PreparedStatement updateStatemtn = null;

        String updateSQL = "UPDATE `classroom_records`.`class` SET `topic` =?, `description` =? WHERE `class_id` = ?;";

        try {
            connection.setAutoCommit(false);
            updateStatemtn = connection.prepareStatement(updateSQL);

            for (JDBCDataObject rawDTO : jdbcDataObjects) {
                ClassDTO classDTO = (ClassDTO) rawDTO;

                if (classDTO.getClassId() > 0) {
                    updateStatemtn.setString(1, classDTO.getTopic());
                    updateStatemtn.setString(2, classDTO.getDesription());
                    updateStatemtn.setInt(3, classDTO.getClassId());

                    if (updateStatemtn.executeUpdate() > 0) {
                        returnKeys.add(classDTO.getClassId());
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
                    Logger.getLogger(ManageClass.class.getName()).log(Level.SEVERE, "Error while performing the operation.", sqlError);
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

        Connection connection = DatabaseConnection.getConnection(this.contextProperties);

        PreparedStatement selectStatement = null;

        StringBuilder selectSQL = generateSelectStatment(jdbcDataObjects);

        try {
            selectStatement = connection.prepareStatement(selectSQL.toString());
            ResultSet results = selectStatement.executeQuery();
            while (results.next()) {
                returnObjects.add(new ClassDTO(results.getInt(1), results.getString(2), results.getString(3), results.getString(4)));
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

        StringBuilder selectSQL = new StringBuilder("SELECT * FROM `classroom_records`.`class` WHERE 1=1 ");

        ClassDTO classDTO = (ClassDTO) jdbcDataObjects;

        if (classDTO.getClassId() > 0) {
            selectSQL.append(" AND ").append("class_id=").append(classDTO.getClassId());
        } else {
            if (classDTO.getTopic() != null) {
                selectSQL.append(" AND ").append("topic=").append("'").append(classDTO.getTopic().trim()).append("'");
            }
            if (classDTO.getDesription() != null) {
                selectSQL.append(" AND ").append("description=").append("'").append(classDTO.getDesription().trim()).append("'");
            }
        }
        return selectSQL;

    }

    @Override
    public void setContext(Properties properties) {
        this.contextProperties = properties;
    }

    private Properties contextProperties;

    public ManageClass(Properties contextProperties) {
        this.setContext(contextProperties);
    }
}
