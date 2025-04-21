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
        for (Course course : this.courseList) {
            if (course.getCourseId().equals(courseId)) {
                System.out.println("Course with ID " + courseId + " found.");
                System.out.println("Course Name " + course.getName());
                System.out.println("Course Teacher " + course.getTeacher().getTeacherId());
                System.out.println("Course Price " + course.getPrice());
            } else {
                System.out.println("Course not found.");
            }
            return;
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
        for (Student student : this.studentList) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Student found.");
                System.out.println("Student with ID " + studentId + " found.");
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Email: " + student.getEmail());
                System.out.println("Student Course: " + student.getCourse());
                if (student.getCourse() != null) {
                    System.out.println("Course found.");
                    System.out.println("Course with ID " + student.getCourse().getCourseId());
                } else {
                    System.out.println("Course not found.");
                }
                return;
            }
        }
        System.out.println("Student not found.");
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
