import java.util.ArrayList;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {

        // Tạo danh sách 10 sinh viên
        List<Student> students = new ArrayList<>();

        students.add(new Student("An", 20, 8.5));
        students.add(new Student("Bình", 21, 6.5));
        students.add(new Student("Chi", 20, 9.0));
        students.add(new Student("Dũng", 22, 7.5));
        students.add(new Student("Hà", 21, 5.5));
        students.add(new Student("Lan", 20, 8.0));
        students.add(new Student("Minh", 22, 6.0));
        students.add(new Student("Nam", 21, 9.5));
        students.add(new Student("Phương", 20, 7.8));
        students.add(new Student("Tuấn", 22, 4.5));

        // Lọc sinh viên có điểm lớn hơn 7.0
        System.out.println("Sinh viên có điểm lớn hơn 7.0:");

        students.stream()
                .filter(student -> student.getGrade() > 7.0)
                .forEach(System.out::println);

        // Sắp xếp sinh viên theo tên
        System.out.println("\nDanh sách sinh viên theo tên:");

        students.stream()
                .sorted((student1, student2) ->
                        student1.getName().compareTo(student2.getName()))
                .forEach(System.out::println);
    }
}