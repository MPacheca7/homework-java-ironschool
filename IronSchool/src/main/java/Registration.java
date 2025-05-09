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
        Student student = null;
        for (Student s : studentList) {
            if (s.getStudentId().equals(studentId)) {
                student = s;
                break;
            }
        }

        Course course = null;
        for (Course c : courseList) {
            if (c.getCourseId().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course not found.");
        }

        student.setCourse(course);
        double totalMoneyErned = course.getMoneyEarned() + course.getPrice();
        course.setMoneyEarned(totalMoneyErned);
        System.out.println("Student enrolled in course.");

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
        for(Course course: courseList){
            System.out.println(course);
        }
    }

    @Override
    public void lookupCourse(String courseId) {
        if(courseId == null) {
            throw new IllegalArgumentException("CourseId no puede ser null");
        }

        for(Course course: courseList){
            if(course.getCourseId().equals(courseId)){
                System.out.println(course);
                break;
            }
        }

    }

    @Override
    public void showStudents() {
        for(Student student: studentList){
            System.out.println(student);
        }
    }

    @Override
    public void lookupStudent(String studentId) {
        if(studentId == null) {
            throw new IllegalArgumentException("StudentId no puede ser null");
        }

        for(Student student: studentList){
            if(student.getStudentId().equals(studentId)){
                System.out.println(student);
                break;
            }
        }
    }

    @Override
    public void showTeachers() {
        for(Teacher teacher: teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void lookupTeacher(String teacherId) {
        if(teacherId == null) {
            throw new IllegalArgumentException("teacherId no puede ser null");
        }

        for(Teacher teacher: teacherList){
            if(teacher.getTeacherId().equals(teacherId)){
                System.out.println(teacher);
                break;
            }
        }
    }

    @Override
    public void showProfit() {
        double totalMoneyEarned = 0;
        for(Course coursePrice: courseList){
            totalMoneyEarned += coursePrice.getMoneyEarned();
        }
        double totalTeacherSalary = 0;
        for(Teacher teacher: teacherList){
            totalTeacherSalary += teacher.getSalary();
        }
        System.out.println("Total Money Earned: " + totalMoneyEarned);
        System.out.println("Total Teacher Salary: " + totalTeacherSalary);
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
