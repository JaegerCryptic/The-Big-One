package edu.curd.operation;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kyle
 */
public interface JDBCOperation {

    public List<Integer> create(List<JDBCDataObject> jdbcDataObjects);

    public List<Integer> update(List<JDBCDataObject> jdbcDataObjects);

    public List<Integer> delete(List<JDBCDataObject> jdbcDataObjects);

    public List<JDBCDataObject> read(JDBCDataObject jdbcDataObjects);
}
