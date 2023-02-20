/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import DAO.studentDao;
import java.util.ArrayList;
import student.StudentBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class StudentController {

    private ArrayList studentsListFromDB;
    public void init() {
        studentsListFromDB = studentDao.getStudentsListFromDB();
    }
 
    public ArrayList studentsList() {
        return studentsListFromDB;
    }
     
    public String saveStudentDetails(StudentBean newStudentObj) {
        return studentDao.saveStudentDetailsInDB(newStudentObj);
    }
     
    public String editStudentRecord(int studentId) {
        return studentDao.editStudentRecordInDB(studentId);
    }
     
    public String updateStudentDetails(StudentBean updateStudentObj) {
        return studentDao.updateStudentDetailsInDB(updateStudentObj);
    }
     
    public String deleteStudentRecord(int studentId) {
        return studentDao.deleteStudentRecordInDB(studentId);
    }
}
