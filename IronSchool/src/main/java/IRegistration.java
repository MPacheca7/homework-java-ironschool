public interface IRegistration {
    void enroll(String studentId, String courseId);

    void assing(String teacherId, String courseId);

    void showCourses();

    void lookupCourse(String courseId);

    void showStudents();

    void lookupStudent(String studentId);

    void showTeachers();

    void lookupTeacher(String teacherId);

    double showProfit();
}
