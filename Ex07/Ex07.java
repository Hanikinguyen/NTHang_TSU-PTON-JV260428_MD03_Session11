package Ex07;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex07 {

    public static void main(String[] args) {

        // Tạo danh sách sinh viên
        List<Student> students = List.of(
                new Student("Quý", "IT", 8.5),
                new Student("Lan", "Business", 7.2),
                new Student("Minh", "IT", 9.0),
                new Student("Huyền", "Design", 6.8),
                new Student("Long", "IT", 7.9),
                new Student("Trang", "Business", 8.1),
                new Student("Việt", "IT", 8.0),
                new Student("Tú", "Design", 7.5),
                new Student("Phúc", "Business", 6.9),
                new Student("An", "AI", 9.5)
        );

        // Thống kê số lượng sinh viên theo chuyên ngành
        Map<String, Long> statistics = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.counting()
                ));

        // Sắp xếp số lượng giảm dần
        statistics.entrySet()
                .stream()
                .sorted((entry1, entry2) ->
                        Long.compare(entry2.getValue(), entry1.getValue()))
                .map(entry ->
                        "Chuyên ngành: " + entry.getKey()
                                + " | Số lượng: " + entry.getValue())
                .forEach(System.out::println);
    }
}
