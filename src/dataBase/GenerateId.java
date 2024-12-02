package dataBase;

public class GenerateId {
    static Long groupId= 0L;
    static Long lessonId= 0L;
    static Long studentId=0L;

    public static Long generateGroupId(){
        return ++groupId;
    }
    public static Long generateLessonId(){
        return ++lessonId;
    }
    public static Long generateStudentId(){
        return ++studentId;
    }
}
