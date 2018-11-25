package Main.Entities;

import Main.Services.RecordsConnection;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kyle
 */
public class Student 
{
    public void StudentFunction(char operation, Integer id, String fName, String lName, 
                                String gender, String bDate, String phone, String address)
    {
        Connection con = RecordsConnection.GetConnection();
        PreparedStatement ps;
        
        if(operation == 'u')
        {
            try
            {
                ps = con.prepareStatement("UPDATE `students` SET `first_name`=?,`last_name`=?,`gender`=?,"
                        + "`birthdate`=?,`phone`=?,`address`=? WHERE `id` =?");
                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, gender);
                ps.setString(4, bDate);
                ps.setString(5, phone);
                ps.setString(6, address);
                ps.setInt(7, id);
                
                if(ps.executeUpdate() > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Student Updated Successfully");
                }
                
            } catch (SQLException ex)
            {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(operation == 'i')
        {
            try
            {
                ps = con.prepareStatement("INSERT INTO students(first_name, last_name, gender, "
                                        + "birthdate, phone, address) VALUES (?,?,?,?,?,?)");
                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, gender);
                ps.setString(4, bDate);
                ps.setString(5, phone);
                ps.setString(6, address);
                
                if(ps.executeUpdate() > 0) 
                {
                    JOptionPane.showMessageDialog(null, "New Student Added Successfully");
                }
                
            } catch (SQLException ex)
            {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(operation == 'd')
        {
            try
            {
                ps = con.prepareStatement("DELETE FROM students WHERE id =?");
                ps.setInt(1, id);               
                
                if(ps.executeUpdate() > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Student Deleted Successfully");
                }
                
            } catch (SQLException ex)
            {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void FillStudents(JTable table, String searchValue)
    {
        Connection con = RecordsConnection.GetConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `students` WHERE CONCAT (`first_name`, `last_name`, `phone`, `address`) LIKE ?");
            ps.setString(1, "%"+searchValue+"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
