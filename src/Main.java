import dataBase.GenerateId;
import models.Group;
import models.Lesson;
import sevise.GroupService;
import sevise.LessonSevise;
import sevise.StudentServise;
import sevise.serviseImpl.GroupServiceImpl;
import sevise.serviseImpl.LessonServiceImpl;
import sevise.serviseImpl.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    private static long groupId;

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        GroupService groupService = new GroupServiceImpl();
        LessonSevise lessonService = new LessonServiceImpl();
        StudentServise studentServise = new StudentServiceImpl();
        for(;true;){
            System.out.println("""
                    0-> Exit
                    1-> Add new group
                    2-> Get group by id
                    3-> Update group by name
                    4-> Get all groups
                    5-> Add new student to group
                    6-> Update student
                    7-> Find student by first name
                    8-> Get all students by group id
                    9-> Get all lessons
                    10-> Delete student
                    11-> Add new lesson to group
                    12-> Get lesson by id
                    13-> Get all lesson by group id
                    14-> Delete lesson
                    15-> Delete group by id""");
            int scan = scanner1.nextInt();
            if(scan<0|| scan>15){
                System.out.println("T1" +
                        "here is no such option");
            }
            switch (scan){
                case 1->{
                    System.out.println("Write name: ");
                    String name = scanner2.nextLine();
                    System.out.println("Write description: ");
                    String description = scanner2.nextLine();
                    groupService.addGroup(new Group(GenerateId.generateGroupId(),name,description));
                }
                case 2->{
                    System.out.println("Write id: ");
                    long scanId = scanner2.nextLong();
                    groupService.getGroupById(scanId);
                }
                case 3->{
                    System.out.println("Write name");
                    String name = scanner2.nextLine();
                    groupService.updateGroupByName(name);
                }
                case 4->{
                    System.out.println(groupService.getAllGroups());
                }
                case 5->{
                    System.out.println("Write group id: ");
                    long id = scanner2.nextLong();
                    studentServise.addStudent(id);
                }
                case 6->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    System.out.println("Write student id: ");
                    long studentId = scanner2.nextLong();
                    studentServise.updateStudent(groupId,studentId);
                }
                case 7->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    System.out.println("Write student name: ");
                    String studentName = scanner2.nextLine();
                    studentServise.getStudentByName(groupId,studentName);
                }
                case 8->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    System.out.println(studentServise.getAllStudents(groupId));
                }
                case 9->{
                    System.out.println("write group id: ");
                    long groupId = scanner2.nextLong();
                    System.out.println("Write lesson id: ");
                    long lessonId = scanner2.nextLong();
                    lessonService.updateLesson(groupId,lessonId);
                }
                case 10->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    System.out.println("Write student id: ");
                    long studentId = scanner2.nextLong();
                    lessonService.getById(groupId,studentId);
                }
                case 11->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    lessonService.addLesson(groupId);
                }
                case 12->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    System.out.println("Write lesson id: ");
                    long lessonId = scanner2.nextLong();
                    lessonService.getById(groupId,lessonId);
                }
                case 13->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    lessonService.getAllLessons(groupId);
                }

                case 14->{
                    System.out.println("Write group id: ");
                    long groupid = scanner2.nextLong();
                    System.out.println("Write lesson id: ");
                    long lessonId = scanner2.nextLong();
                    lessonService.deleteLesson(groupid,lessonId);
                }
                case 15->{
                    System.out.println("Write group id: ");
                    long groupId = scanner2.nextLong();
                    groupService.deleteGroup(groupId);
                }
                case 0->{

                }
            }
        }
    }
}
