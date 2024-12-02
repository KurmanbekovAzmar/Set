package sevise.serviseImpl;

import dataBase.DataBase;
import dataBase.GenerateId;
import models.Group;
import models.Lesson;
import sevise.LessonSevise;

import java.util.Scanner;

public class LessonServiceImpl implements LessonSevise {
    @Override
    public void addLesson(Long groupId) {
        Scanner scanner = new Scanner(System.in);
        for(Group group: DataBase.groups){
            if(group.getId()==groupId){
                System.out.println("Write lesson name: ");
                String name= scanner.nextLine();
                System.out.println("Write lesson description: ");
                String description = scanner.nextLine();
                group.getLessons().add(new Lesson(GenerateId.generateLessonId(),name,description));
                break;
            }else{
                System.out.println("there is no such group");
            }
        }
    }

    @Override
    public void getById(Long groupId, Long lessonId) {
        for(Group group:DataBase.groups){
            if(group.getId()==groupId){
                for(Lesson lesson:group.getLessons()){
                    if(lesson.getId()==lessonId){
                        System.out.println(lesson);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void getAllLessons(Long groupId) {
        for(Group group:DataBase.groups){
            System.out.println(group.getLessons());
        }

    }

    @Override
    public void updateLesson(Long groupId, Long lessonId) {
        Scanner scanner = new Scanner(System.in);
        for(Group group:DataBase.groups){
            if(group.getId()==groupId){
                for(Lesson lesson:group.getLessons()){
                    if(lesson.getId()==lessonId){
                        System.out.println("Write new lesson name: ");
                        String newLessonName = scanner.nextLine();
                        System.out.println("Write new lesson description: ");
                        String newLessonDescription = scanner.nextLine();
                        lesson.setLessonName(newLessonName);
                        lesson.setLessonDescription(newLessonDescription);
                        break;
                    }else {
                        System.out.println("there is no such lesson");
                    }
                }
            }else{
                System.out.println("there is no such group");
            }
        }
    }

    @Override
    public void deleteLesson(Long groupId, Long lessonId) {
        for(Group group:DataBase.groups){
            if(group.getId()==groupId){
                for(Lesson lesson:group.getLessons()){
                    if(lesson.getId()==lessonId){
                        DataBase.groups.remove(lesson);
                        break;
                    }else{
                        System.out.println("there is no such lesson");
                    }
                }
            }else {
                System.out.println("there is no such group");
            }
        }
    }
}
