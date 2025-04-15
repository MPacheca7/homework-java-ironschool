import java.util.UUID;

public class Course {
    private String courseId = UUID.randomUUID().toString();
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

    public Course(String name, double price) {
        setName(name);
        if (price < 0.0) {
            throw new IllegalArgumentException("Error el precio no puede ser nulo");
        } else {
            setPrice(price);
        }
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", moneyEarned=" + moneyEarned +
                ", teacher=" + teacher +
                '}';
    }
}
