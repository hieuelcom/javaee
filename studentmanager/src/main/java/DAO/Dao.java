
package DAO;

import java.util.ArrayList;
import student.StudentBean;


public interface Dao {
    ArrayList<StudentBean> stu();
    void add(StudentBean stu);
    void edit(StudentBean stu);
    void delete(StudentBean stu);

}
