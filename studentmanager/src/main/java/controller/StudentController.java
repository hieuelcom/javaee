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
    private studentDao studentdao = new studentDao();
    private StudentBean stu;
    
    private ArrayList<StudentBean> studentsListFromDB;
    public void init() {
    studentsListFromDB = studentdao.liststudent();
    }
   public ArrayList studentsList() {
        return studentsListFromDB;
    }
   public void add(StudentBean stuadd){
       studentdao.add(stuadd);
   }
   public void edit(StudentBean stuedit){
       studentdao.edit(stuedit);
   }
   public void delete(StudentBean studelete){
       studentdao.add(studelete);
   }
}
