/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kyle
 */
public class Users 
{
    private String username;
    private String password;

    public Users() {
    }

    public Users(Integer id, String username, String password, String fname, String lname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(String pass) {
        if(checkPassword(pass) == true){
        return password;
        }else{
            return null;
    }
    }

    public void changePassword(String newPassword, String oldPassword) {
        if(checkPassword(oldPassword) == true){
        this.password = newPassword;
    }
    }

  private Boolean checkUsername(String uname){
        Boolean bool;
        if(uname.equals(this.username)){
            bool = true;
            System.out.println("Username is Correct");
        }else{
             bool = false;
             System.out.println("Username is Incorrect");

        }
        return bool;
    }

    private  Boolean checkPassword(String password){
        Boolean bool;
        if(password.equals(this.password)){
            bool = true;
            System.out.println("Password is Correct");
        }else{
             bool = false;
             System.out.println("Password is Incorrect");

        }
        return bool;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlTransient
    public Collection<Applied> getAppliedCollection() {
        return appliedCollection;
    }

    public void setAppliedCollection(Collection<Applied> appliedCollection) {
        this.appliedCollection = appliedCollection;
    }

    public Caseworker getAssignedWorker() {
        return assignedWorker;
    }

    public void setAssignedWorker(Caseworker assignedWorker) {
        this.assignedWorker = assignedWorker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Users[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Guardians> getGuardiansCollection() {
        return guardiansCollection;
    }

    public void setGuardiansCollection(Collection<Guardians> guardiansCollection) {
        this.guardiansCollection = guardiansCollection;
    }
    
}
