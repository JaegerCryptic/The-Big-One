package edu.curd.operation;

import java.util.List;
import java.util.Properties;

public interface JDBCOperation {

    void setContext(Properties properties);
    
    public List<Integer> create(List<JDBCDataObject> jdbcDataObjects);

    public List<Integer> update(List<JDBCDataObject> jdbcDataObjects);

    public List<Integer> delete(List<JDBCDataObject> jdbcDataObjects);

    public List<JDBCDataObject> read(JDBCDataObject jdbcDataObjects);
}
