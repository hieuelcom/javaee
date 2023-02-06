/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
import DAO.DatabaseOperation;
import javax.faces.bean.ViewScoped;
 
@ManagedBean @ViewScoped
public class StudentBean {
    private int id=0;
    private String name="";
    private String studentid="";
    private String address="";
    private int age=0;
    private Date birth;
    private int records;
    
    public ArrayList studentsListFromDB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getStudentID(){
        return studentid;
    }
    public void setStudentID(String studentid){
        this.studentid=studentid;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public Date getBirth(){
        return birth;
    }
    public void setBirth(Date birth){
        this.birth=birth;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }
    @PostConstruct
    public void init() {
        studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
        if(studentsListFromDB != null) {
            this.records = studentsListFromDB.size();
        }
    }    
    
    public ArrayList studentsList() {
        return studentsListFromDB;
    }
     
    public String saveStudentDetails(StudentBean newStudentObj) {
        return DatabaseOperation.saveStudentDetailsInDB(newStudentObj);
    }
     
    public String editStudentRecord(int studentsId) {
        return DatabaseOperation.editStudentRecordInDB(studentsId);
    }
     
    public String updateStudentDetails(StudentBean updateStudentObj) {
        return DatabaseOperation.updateStudentDetailsInDB(updateStudentObj);
    }
     
    public String deleteStudentRecord(int studentuId) {
        return DatabaseOperation.deleteStudentRecordInDB(studentuId);
    }

    public void setBitrth(java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
