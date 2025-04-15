import java.util.UUID;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;

    public Teacher(double salary, String name) {
        this.teacherId = UUID.randomUUID().toString();
        this.salary = salary;
        this.name = name;
    }

    public Teacher(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
