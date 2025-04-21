import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RegistrationTest {
    @Test
    public void assign() {
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();

        Teacher teacher1 = new Teacher(1200, "Jaime");
        Course course1 = new Course("Ingles", 100);

        teacherList.add(teacher1);
        courseList.add(course1);

        Registration registration = new Registration(studentList, courseList, teacherList);
        registration.assing(teacher1.getTeacherId(), course1.getCourseId());

        assertEquals(teacher1, course1.getTeacher(), "The teacher could not be assigned to the course");

    }

    @Test
    public void lookupStudent() {
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();

        Student student1 = new Student("Pedro", "Calle las manzanas", "Pedro@gpedro.com");

        studentList.add(student1);

        Registration registration = new Registration(studentList, courseList, teacherList);
        registration.lookupStudent(student1.getStudentId());

        assertNotNull(student1,"Student found");
    }

}