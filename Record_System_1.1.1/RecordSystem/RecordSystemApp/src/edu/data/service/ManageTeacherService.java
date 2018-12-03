
package edu.data.service;


public interface ManageTeacherService {
    
    int validatUser(String userName,String password);

    boolean updateUserPassword(int userId,String newPassword);

}
