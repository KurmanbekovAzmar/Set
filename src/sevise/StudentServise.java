package sevise;

import models.Group;
import models.Student;

import java.util.List;

public interface StudentServise {
    String addStudent(Long groupId);
    Student updateStudent(Long groupId,Long studentId);
    Student getStudentByName(Long groupId,String name);
    List<Student> getAllStudents(Long groupId);
    void  deleteStudent(Long groupId,Long studentId);
}
