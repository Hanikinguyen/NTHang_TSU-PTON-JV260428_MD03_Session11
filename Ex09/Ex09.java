package Ex09;

import java.time.LocalDate;
import java.util.List;

public class Ex09 {

    public static void main(String[] args) {

        // =========================
        // 1. Tạo danh sách người dùng
        // =========================

        User u1 = new User(
                1,
                "Quý",
                "quy@example.com"
        );

        User u2 = new User(
                2,
                "Lan",
                null
        );

        User u3 = new User(
                3,
                "Huyền",
                "huyen@example.com"
        );


        // =========================
        // 2. Tạo danh sách công việc
        // =========================

        List<Task> tasks = List.of(

                new Task(
                        1,
                        "Viết báo cáo",
                        u1,
                        LocalDate.of(2025, 3, 20),
                        false
                ),

                new Task(
                        2,
                        "Thiết kế slide",
                        u1,
                        LocalDate.of(2025, 3, 25),
                        true
                ),

                new Task(
                        3,
                        "Họp nhóm",
                        u2,
                        LocalDate.of(2025, 3, 18),
                        false
                ),

                new Task(
                        4,
                        "Nộp tài liệu",
                        u3,
                        LocalDate.of(2025, 3, 22),
                        true
                ),

                new Task(
                        5,
                        "Chuẩn bị thuyết trình",
                        u2,
                        LocalDate.of(2025, 3, 19),
                        true
                )
        );


        // =========================
        // 3. Công việc quá hạn
        //    và chưa hoàn thành
        // =========================

        LocalDate today = LocalDate.now();

        System.out.println("===== CÔNG VIỆC QUÁ HẠN VÀ CHƯA HOÀN THÀNH =====");

        tasks.stream()
                .filter(task ->
                        task.getDueDate().isBefore(today)
                                && !task.isCompleted()
                )
                .forEach(System.out::println);


        // =========================
        // 4. Thống kê số công việc
        //    đã hoàn thành
        // =========================

        long completedTasks = tasks.stream()
                .filter(Task::isCompleted)
                .count();

        System.out.println("\n===== THỐNG KÊ =====");
        System.out.println(
                "Số công việc đã hoàn thành: "
                        + completedTasks
        );


        // =========================
        // 5. In danh sách người dùng
        // =========================

        List<User> users = List.of(u1, u2, u3);

        System.out.println("\n===== DANH SÁCH NGƯỜI DÙNG =====");

        users.forEach(user -> {

            String email = user.getEmail()
                    .orElse("Chưa có email");

            System.out.println(
                    "Tên: " + user.getName()
                            + " | Email: " + email
            );
        });
    }
}
