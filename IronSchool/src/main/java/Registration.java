import java.util.ArrayList;
import java.util.List;

// datos y comandos

public class Registration implements IRegistration {

    private List<Student> studentList = new ArrayList<>();
    private List<Course> courseList= new ArrayList<>();
    private List<Teacher> teacherList= new ArrayList<>();

    public Registration(){
    }

    public Registration(List<Student> studentList, List<Course> courseList, List<Teacher> teacherList) {
        this.studentList = studentList;
        this.courseList = courseList;
        this.teacherList = teacherList;
    }

    @Override
    public void enroll(String studentId, String courseId) {

    }

    @Override
    public void assing(String teacherId, String courseId) {

    }

    @Override
    public void showCourses() {

    }

    @Override
    public void lookupCourse(String courseId) {

    }

    @Override
    public void showStudents() {

    }

    @Override
    public void lookupStudent(String studentId) {

    }

    @Override
    public void showTeachers() {

    }

    @Override
    public void lookupTeacher(String teacherId) {

    }

    @Override
    public double showProfit() {
        return 0;
    }

    public void addTeacher(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public void addCourse(Course course){
        this.courseList.add(course);
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }
}
