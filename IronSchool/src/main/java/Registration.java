import java.util.ArrayList;
import java.util.List;

// datos y comandos

public class Registration implements IRegistration {

    private List<Student> studentList = new ArrayList<>();
    private List<Course> courseList= new ArrayList<>();
    private List<Teacher> teacherList= new ArrayList<>();

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
        Teacher teacher = null;
        for (Teacher teac : this.teacherList) {
            if (teac.getTeacherId().equals(teacherId)) {
                teacher = teac;
                break;
            }
        }

        Course course = null;
        for (Course cour : this.courseList) {
            if (cour.getCourseId().equals(courseId)) {
                course = cour;
                break;
            }
        }

        if (teacher != null && course != null) {
            course.setTeacher(teacher);
            System.out.println("Teacher with ID " + teacherId + " assigned to course with ID " + courseId + ".");
        } else {
            System.out.println("The teacher could not be assigned to the course.");
        }
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


}
