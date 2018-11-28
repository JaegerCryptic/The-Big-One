/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.data.service;

/**
 *
 * @author Aeron
 */
public interface ManageTeacherService {
    
    
    int validatUser(String userName,String password);

    boolean updateUserPassword(int userId,String newPassword);

}
