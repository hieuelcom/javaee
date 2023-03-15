///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package student;

import controller.StudentController;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author young
 */
public class PaginatorView {
     private List<StudentBean> student;
     
    @Inject
    private StudentController service;
 
    @PostConstruct
    public void init() {
        student = service.studentl(50);
    }
     
    public List<StudentBean> getID() {
        return student;
    }
 
    public void setService(StudentController service) {
        this.service = service;
    }
    
}
