package Unit1.Feb19;

public class Feb19 {

    public static void main(String[] args) {
        Student student1 = new Student("Connor Mulligan", 15, 29837, 10);
        Student student2 = new Student("Bob", 16, 12345, 10);
        System.out.println(student1);
        System.out.println(student2);

        System.out.println(student1.getID());
        student1.setID(98765);
        System.out.println(student1.getID());
    }
}