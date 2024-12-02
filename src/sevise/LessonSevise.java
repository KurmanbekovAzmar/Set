package sevise;

import models.Lesson;

public interface LessonSevise {
    void addLesson(Long groupId);
    void getById(Long groupId,Long lessonId);
    void getAllLessons(Long groupId);
    void updateLesson(Long groupId,Long lessonId);
    void deleteLesson(Long groupId, Long lessonId);
}
