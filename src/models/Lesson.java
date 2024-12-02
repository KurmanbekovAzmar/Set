package models;

public class Lesson {
    private Long id;
    private String lessonName;
    private String lessonDescription;

    public Lesson() {
    }

    public Lesson(Long id, String lessonName, String lessonDescription) {
        this.id = id;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    @Override
    public String toString() {
        return "\nLesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", lessonDescription='" + lessonDescription + '\'' +
                '}';
    }
}
