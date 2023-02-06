/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import student.StudentBean;

public class DatabaseOperation {

    public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db_url = "jdbc:mysql://localhost:3306/student",
                    db_userName = "root",
                    db_password = "";
            connObj = DriverManager.getConnection(db_url, db_userName, db_password);
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return connObj;
    }

    public static ArrayList getStudentsListFromDB() {
        System.out.println("getStudentsListFromDB...");
        ArrayList studentsList = new ArrayList();
        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from student");
            while (resultSetObj.next()) {
                StudentBean stuObj = new StudentBean();
                stuObj.setId(resultSetObj.getInt("id"));
                stuObj.setName(resultSetObj.getString("name"));
                stuObj.setStudentID(resultSetObj.getString("studentid"));
                stuObj.setAge(resultSetObj.getInt("age"));
                stuObj.setBirth(resultSetObj.getDate("birth"));
                stuObj.setAddress(resultSetObj.getString("address"));
                studentsList.add(stuObj);
            }
            System.out.println("Total Records Fetched: " + studentsList.size());
            connObj.close();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return studentsList;
    }

    public static String saveStudentDetailsInDB(StudentBean newStudentObj) {
        int saveResult = 0;
        String navigationResult = "";
        try {
            pstmt = getConnection().prepareStatement("insert into student(name, studentid,age, birth, address) values (?, ?, ?, ?, ?)");
            pstmt.setString(1, newStudentObj.getName());
            pstmt.setString(2, newStudentObj.getStudentID());
            pstmt.setInt(3, newStudentObj.getAge());
            pstmt.setDate(4, (Date) newStudentObj.getBirth());
            pstmt.setString(5, newStudentObj.getAddress());
            saveResult = pstmt.executeUpdate();
            connObj.close();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        if (saveResult != 0) {
            navigationResult = "studentsList.xhtml?faces-redirect=true";
        } else {
            navigationResult = "createStudent.xhtml?faces-redirect=true";
        }
        return navigationResult;
    }

    public static String editStudentRecordInDB(int studentsId) {
        StudentBean editRecord = null;
        System.out.println("editStudentRecordInDB() : Student Id: " + studentsId);

        /* Setting The Particular Student Details In Session */
        Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from student where student = " + studentsId);
            if (resultSetObj != null) {
                resultSetObj.next();
                editRecord = new StudentBean();
                editRecord.setId(resultSetObj.getInt("id"));
                editRecord.setName(resultSetObj.getString("name"));
                editRecord.setStudentID(resultSetObj.getString("studentid"));
                editRecord.setBitrth(resultSetObj.getDate("birth"));
                editRecord.setAddress(resultSetObj.getString("address"));
                editRecord.setAge(resultSetObj.getInt("age"));
            }
            sessionMapObj.put("editRecordObj", editRecord);
            connObj.close();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/editStudent.xhtml?faces-redirect=true";
    }

    public static String updateStudentDetailsInDB(StudentBean updateStudentObj) {
        try {
            pstmt = getConnection().prepareStatement("update student set name=?, studentid=?, age, birth=?, address=? where id=?");
            pstmt.setString(1, updateStudentObj.getName());
            pstmt.setString(2, updateStudentObj.getStudentID());
            pstmt.setInt(3, updateStudentObj.getAge());
            pstmt.setDate(4, (Date) updateStudentObj.getBirth());
            pstmt.setString(5, updateStudentObj.getAddress());
            pstmt.setInt(6, updateStudentObj.getId());
            pstmt.executeUpdate();
            connObj.close();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/studentsList.xhtml?faces-redirect=true";
    }

    public static String deleteStudentRecordInDB(int studentsId) {
        System.out.println("deleteStudentRecordInDB() : Student Id: " + studentsId);
        try {
            pstmt = getConnection().prepareStatement("delete from student where id = " + studentsId);
            pstmt.executeUpdate();
            connObj.close();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/studentsList.xhtml?faces-redirect=true";
    }
}
