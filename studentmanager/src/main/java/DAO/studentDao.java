/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import student.StudentBean;
import DBPool.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author young
 */
public class studentDao  {
    
    
    public ArrayList<StudentBean> liststudent() {  
        ArrayList studentsList = new ArrayList();  
//add data vào tableview
        try {
            //truy van sql
            String txt_sql = "SELECT * FROM student";

            Connector conn = Connector.getInstance();   //connector
            PreparedStatement stt = conn.getStatement(txt_sql);

            ResultSet rs = stt.executeQuery(txt_sql);

            ArrayList<StudentBean> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new StudentBean(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("studentid"),
                        rs.getString("adrress"),
                        Date.valueOf(rs.getString("birth")),
                        rs.getInt("age")
                ));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentsList;
    }
     public String add(StudentBean stuadd) {
        //truy vấn sql: thêm sv vào assigment01.database
        int saveResult = 0;
        String navigationResult = "";
        String sql_txt = "insert into student (id,name,studentid,birth,address,age) values(?,?,?,?,?,?)";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setInt(1,stuadd.getId());
            stt.setString(2,stuadd.getName());
            stt.setString(3,stuadd.getStudentID());
            stt.setString(4,stuadd.getBirth().toString());
            stt.setString(5,stuadd.getAddress());
            stt.setInt(6,stuadd.getAge());

            stt.execute();
            System.out.println(sql_txt);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(saveResult !=0) {
            navigationResult = "studentsList.xhtml?faces-redirect=true";
        } else {
            navigationResult = "createStudent.xhtml?faces-redirect=true";
        }
        return navigationResult;
    }

    
    public String edit(StudentBean stuedit) {
        String sql_txt = "UPDATE tbstu SET studentid=?,name=?,birth=?,address=?,age=? where id=?";
        try{
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,stuedit.getStudentID());
            stt.setString(2,stuedit.getName());
            stt.setString(3,stuedit.getBirth().toString());
            stt.setString(4,stuedit.getAddress());
            stt.setDouble(5,stuedit.getAge());

            stt.setInt(6,stuedit.getId());
            // insert
            stt.execute();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "/editStudent.xhtml?faces-redirect=true";
        
    }

    
    public String delete(StudentBean studelete) {
        String sql_txt = "delete from student where id=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setInt(1, studelete.getId());
            stt.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "/studentsList.xhtml?faces-redirect=true";
    }
}
