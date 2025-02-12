package Unit1.Feb19;

public class Student {
    private String name;
    private int age;
    private int ID;
    private int grade;

    /**
     * Creates a student which has a name, age, ID, and grade value
     * @param name the student's name
     * @param age the student's age
     * @param ID the student's id
     * @param grade the student's grade (0-12)
     */
    public Student(String name, int age, int ID, int grade) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.grade = grade;
    }

    public String toString() {
        return "{name: " + name + ", age: " + age + ", ID: " + ID + ", grade: " + grade + "}";
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public int getID() {
        return this.ID;
    }
    public int getGrade() {
        return this.grade;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
}