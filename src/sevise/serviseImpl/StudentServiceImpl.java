package sevise.serviseImpl;

import dataBase.DataBase;
import dataBase.GenerateId;
import enums.Gender;
import models.Group;
import models.Student;
import sevise.StudentServise;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentServise {

    @Override
    public String addStudent(Long groupId) {
        Scanner scanner = new Scanner(System.in);
        Gender gender = null;
        for(Group group: DataBase.groups){
            if(group.getId()==groupId){
                System.out.println("Write student first name: ");
                String name = scanner.nextLine();
                System.out.println("Write student last name: ");
                String lastName = scanner.nextLine();
                System.out.println("Write student email: ");
                String email = scanner.nextLine();
                System.out.println("Write student password: ");
                String password = scanner.nextLine();
                System.out.println("1-Male, 2-female");
                int gen = scanner.nextInt();
                if(gen==1){
                    gender=Gender.Male;
                } else if (gen==2) {
                    gender = Gender.Female;
                }
                group.getStudents().add(new Student(GenerateId.generateStudentId(),name,lastName,email,password,gender));
                return "Success";
            }
        }
        return "Invalid";
    }

    @Override
    public Student updateStudent(Long groupId,Long studentId) {
        Scanner scanner = new Scanner(System.in);
        for(Group group : DataBase.groups){
            if(group.getId()==groupId){
                for(Student student:group.getStudents()){
                    if(student.getId()==studentId){
                        System.out.println("Write new email: ");
                        String email = scanner.nextLine();
                        System.out.println("Write new password: ");
                        String password = scanner.nextLine();
                        System.out.println("Write new first name: ");
                        String newFirstName = scanner.nextLine();
                        System.out.println("Write new last name: ");
                        String newLastName = scanner.nextLine();
                        student.setEmail(email);
                        student.setPassword(password);
                        student.setFirstName(newFirstName);
                        student.setLastName(newLastName);
                        return student;
                    }else{
                        System.out.println("there is no such student");
                    }
                }
            }else{
                System.out.println("there is no such group");
            }
        }
    return null;
    }

    @Override
    public Student getStudentByName(Long groupId,String name) {
        for(Group group:DataBase.groups){
            if(group.getId()==groupId){
                for(Student student:group.getStudents()){
                    if(student.getFirstName().equalsIgnoreCase(name)){
                        return student;
                    }else {
                        System.out.println("there is no such student");
                    }
                }
            }else{
                System.out.println("there is no such group");
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents(Long groupId) {
        for(Group group:DataBase.groups){
            if(group.getId()==groupId){
                for(Student student:group.getStudents()){
                    System.out.println(student);
                }
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(Long groupId,Long studentId) {
        for(Group group:DataBase.groups){
            if(group.getId()==groupId){
                for(Student student: group.getStudents()){
                    if(student.getId()==studentId){
                        group.getStudents().remove(student);
                    }else{
                        System.out.println("there is no such student");
                    }
                }
            }else{
                System.out.println("there is no such group");
            }
        }
    }
}
