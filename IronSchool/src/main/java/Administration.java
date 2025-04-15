import java.util.Scanner;

public class Administration {
    private Registration registration = new Registration();

    public Administration() {
    }

    public void executeAdmid() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre de la escuela:");
        String nameSchool = scanner.nextLine();

        scanTeachers();
        scanCourses();
        scanStudents();

        scanCommands();
    }

    public void scanTeachers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuantos profesores quieres crear?:");
        int numTeachers = scanner.nextInt();
        // Skip the newline
        scanner.nextLine();
        for (int i = 0; i < numTeachers; i++) {
            System.out.println("Introduce el nombre del profesor " + i + ":");
            String name = scanner.nextLine();

            System.out.println("Introduce el salario del profesor " + i + ":");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            Teacher teacher = new Teacher(salary, name);
//            System.out.println(teacher.toString());
            registration.addTeacher(teacher);
        }
    }

    public void scanCourses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuantos cursos quieres crear?:");
        int numCourses = scanner.nextInt();
        // Skip the newline
        scanner.nextLine();
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Introduce el nombre del curso " + i + ":");
            String name = scanner.nextLine();

            System.out.println("Introduce el precio del curso " + i + ":");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Course course = new Course(name, price);
//            System.out.println(course.toString());
            registration.addCourse(course);
        }
    }

    public void scanStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuantos estudiantes quieres crear?:");
        int numStudents = scanner.nextInt();
        // Skip the newline
        scanner.nextLine();
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Introduce el nombre del estudiante " + i + ":");
            String name = scanner.nextLine();

            System.out.println("Introduce la dirección del estudiante " + i + ":");
            String address = scanner.nextLine();

            System.out.println("Introduce el email del estudiante " + i + ":");
            String email = scanner.nextLine();

            Student student = new Student(name, address, email);
            System.out.println(student.toString());
            registration.addStudent(student);
        }
    }

    void scanCommands() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n########################################################################");
            System.out.println("# INTRODUCE UN COMANDO VÁLIDO DE LA SIGUIENTE LISTA (EXIT PARA SALIR): #");
            System.out.println("########################################################################");
            printCommands();

            String commandStr = scanner.nextLine();

            if (commandStr.startsWith("ENROLL")) {
                String[] commandSplited = commandStr.split(" ");
                String studentId = replaceBrackets(commandSplited[1]);
                String courseId = replaceBrackets(commandSplited[2]);
//                System.out.println(studentId);
//                System.out.println(courseId);
                System.out.println("ejecutando ENROLL con los parametros: " + studentId + " " + courseId);
                registration.enroll(studentId, courseId);

            } else if (commandStr.startsWith("ASSIGN")) {
                String[] commandSplited = commandStr.split(" ");
                String teacherId = replaceBrackets(commandSplited[1]);
                String courseId = replaceBrackets(commandSplited[2]);
//                System.out.println(teacherId);
//                System.out.println(courseId);
                System.out.println("ejecutando ASSIGN con los parametros: " + teacherId + " " + courseId);
                registration.assing(teacherId, courseId);

            } else if (commandStr.startsWith("SHOW COURSES")) {
                registration.showCourses();

            } else if (commandStr.startsWith("LOOKUP COURSE")) {
                String[] commandSplited = commandStr.split(" ");
                String courseId = replaceBrackets(commandSplited[2]);
//                System.out.println(courseId);
                System.out.println("ejecutando LOOKUP COURSE con los parametros: " + courseId);
                registration.lookupCourse(courseId);

            } else if (commandStr.startsWith("SHOW STUDENTS")) {
                System.out.println("ejecutando SHOW STUDENTS:");
                registration.showStudents();

            } else if (commandStr.startsWith("LOOKUP STUDENT")) {
                String[] commandSplited = commandStr.split(" ");
                String studentId = replaceBrackets(commandSplited[2]);
//                System.out.println(studentId);
                System.out.println("ejecutando LOOKUP STUDENT con los parametros: " + studentId);
                registration.lookupStudent(studentId);

            } else if (commandStr.startsWith("SHOW TEACHERS")) {
                System.out.println("ejecutando SHOW TEACHERS:");
                registration.showTeachers();

            } else if (commandStr.startsWith("LOOKUP TEACHER")) {
                String[] commandSplited = commandStr.split(" ");
                String teacherId = replaceBrackets(commandSplited[2]);
//                System.out.println(teacherId);
                System.out.println("ejecutando LOOKUP TEACHER con los parametros: " + teacherId);
                registration.lookupTeacher(teacherId);

            } else if (commandStr.startsWith("SHOW PROFIT")) {
                System.out.println("ejecutando SHOW PROFIT:");
                registration.showProfit();

            } else if (commandStr.startsWith("EXIT")) {
                exit = true;
            }

        }
    }

    public String replaceBrackets(String idWithBrackets) {
        String studentId = idWithBrackets.substring(1);//eliminamoso el principio
        studentId = studentId.replaceFirst(".$", "");// eliminamos el final
        System.out.println("studentId=" + studentId);

        return studentId;
    }

    public void printCommands(){
        System.out.println("*********************************************");
        System.out.println("*\tENROLL [STUDENT_ID] [COURSE_ID]\t\t\t*");
        System.out.println("*\tASSIGN [TEACHER_ID] [COURSE_ID]\t\t\t*");
        System.out.println("*\tSHOW COURSES\t\t\t\t\t\t\t*");
        System.out.println("*\tLOOKUP COURSE [COURSE_ID]\t\t\t\t*");
        System.out.println("*\tSHOW STUDENTS\t\t\t\t\t\t\t*");
        System.out.println("*\tLOOKUP STUDENT [STUDENT_ID]\t\t\t\t*");
        System.out.println("*\tSHOW TEACHERS\t\t\t\t\t\t\t*");
        System.out.println("*\tLOOKUP TEACHER [TEACHER_ID]\t\t\t\t*");
        System.out.println("*\tSHOW PROFIT\t\t\t\t\t\t\t\t*");
        System.out.println("*\tEXIT\t\t\t\t\t\t\t\t\t*");
        System.out.println("*********************************************");
    }
}
