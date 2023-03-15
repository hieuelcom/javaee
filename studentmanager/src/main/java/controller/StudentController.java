/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import DAO.studentDao;
import java.util.ArrayList;
import java.util.List;
import student.StudentBean;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentController {

    public ArrayList studentsListFromDB;
    private StudentBean studentBean;
    

    public List<StudentBean> studentl(int size) {
        List<StudentBean> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new StudentBean(getId(), getName(), getStudentID(), getAge(), getBirth(), getAfdress()));
        }
         
        return list;
    }
    @PostConstruct
    public void init() {
        studentBean = new StudentBean();
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
        boolean remove = studentsListFromDB.remove(studentBean);
        return studentDao.deleteStudentRecordInDB(studentId);
    }

    public ArrayList getStudentsListFromDB() {
        return studentsListFromDB;
    }

    public void setStudentsListFromDB(ArrayList studentsListFromDB) {
        this.studentsListFromDB = studentsListFromDB;
    }

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }
    
}
