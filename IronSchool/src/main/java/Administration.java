import java.util.Scanner;

public class Administration {
    private Registration registration = new Registration();

    public Administration() {
    }

    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    public void executeAdmid() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_CYAN_BACKGROUND + "\uD83C\uDFEBIntroduce el nombre de la escuela:" + ANSI_RESET);
        String nameSchool = scanner.nextLine();

        scanTeachers();
        scanCourses();
        scanStudents();

        scanCommands();
    }

    public void scanTeachers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_PURPLE_BACKGROUND + "\uD83D\uDC68\u200D\uD83C\uDFEB¿Cuantos profesores quieres crear?:" + ANSI_RESET);
        int numTeachers = scanner.nextInt();
        // Skip the newline
        scanner.nextLine();
        for (int i = 0; i < numTeachers; i++) {
            System.out.println(ANSI_PURPLE + "Introduce el nombre del profesor:" + ANSI_RESET);
            String name = scanner.nextLine();

            System.out.println(ANSI_PURPLE + "Introduce el salario del profesor:" + ANSI_RESET);
            double salary = scanner.nextDouble();
            scanner.nextLine();

            Teacher teacher = new Teacher(salary, name);
//            System.out.println(teacher.toString());
            registration.addTeacher(teacher);
        }
    }

    public void scanCourses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_GREEN_BACKGROUND + "\uD83D\uDCDA¿Cuantos cursos quieres crear?:" + ANSI_RESET);
        int numCourses = scanner.nextInt();
        // Skip the newline
        scanner.nextLine();
        for (int i = 0; i < numCourses; i++) {
            System.out.println(ANSI_GREEN + "Introduce el nombre del curso:" + ANSI_RESET);
            String name = scanner.nextLine();

            System.out.println(ANSI_GREEN + "Introduce el precio del curso:" + ANSI_RESET);
            double price = scanner.nextDouble();
            scanner.nextLine();

            Course course = new Course(name, price);
//            System.out.println(course.toString());
            registration.addCourse(course);
        }
    }

    public void scanStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_YELLOW_BACKGROUND +"\uD83D\uDC69\u200D\uD83C\uDF93¿Cuantos estudiantes quieres crear?:" + ANSI_RESET);
        int numStudents = scanner.nextInt();
        // Skip the newline
        scanner.nextLine();
        for (int i = 0; i < numStudents; i++) {
            System.out.println(ANSI_YELLOW + "Introduce el nombre del estudiante:" + ANSI_RESET);
            String name = scanner.nextLine();

            System.out.println(ANSI_YELLOW + "Introduce la dirección del estudiante:" + ANSI_RESET);
            String address = scanner.nextLine();

            System.out.println(ANSI_YELLOW + "Introduce el email del estudiante:" + ANSI_RESET);
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
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDD04\tENROLL \uD83D\uDC68\u200D\uD83C\uDF93[STUDENT_ID] \uD83D\uDCDA[COURSE_ID]\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDD04\tASSIGN \uD83D\uDC69\u200D\uD83C\uDFEB[TEACHER_ID] \uD83D\uDCDA[COURSE_ID]\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDCDA\tSHOW COURSES\t\t\t\t\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDCDA\tLOOKUP COURSE [COURSE_ID]\t\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDC68\u200D\uD83C\uDF93\tSHOW STUDENTS\t\t\t\t\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDC68\u200D\uD83C\uDF93\tLOOKUP STUDENT [STUDENT_ID]\t\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDC69\u200D\uD83C\uDFEB\tSHOW TEACHERS\t\t\t\t\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDC69\u200D\uD83C\uDFEB\tLOOKUP TEACHER [TEACHER_ID]\t\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\uD83D\uDCB5\tSHOW PROFIT\t\t\t\t\t\t\t\t*" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "*\tEXIT\t\t\t\t\t\t\t\t\t*" + ANSI_RESET);
        System.out.println("*********************************************");
    }
}
