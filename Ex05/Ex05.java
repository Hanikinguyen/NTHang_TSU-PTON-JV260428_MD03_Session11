import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Event> events = new ArrayList<>();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SỰ KIỆN =====");
            System.out.println("1. Thêm sự kiện");
            System.out.println("2. Hiển thị danh sách sự kiện");
            System.out.println("3. Kiểm tra sự kiện đang diễn ra");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhập tên sự kiện: ");
                    String name = scanner.nextLine();

                    try {
                        System.out.print("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
                        String startInput = scanner.nextLine();

                        System.out.print("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");
                        String endInput = scanner.nextLine();

                        LocalDateTime startDate =
                                LocalDateTime.parse(startInput, formatter);

                        LocalDateTime endDate =
                                LocalDateTime.parse(endInput, formatter);

                        if (!endDate.isAfter(startDate)) {
                            System.out.println(
                                    "Thời gian kết thúc phải sau thời gian bắt đầu!"
                            );
                            break;
                        }

                        Event event =
                                new Event(name, startDate, endDate);

                        events.add(event);

                        System.out.println("Thêm sự kiện thành công!");

                    } catch (DateTimeParseException e) {
                        System.out.println(
                                "Lỗi: Thời gian không đúng định dạng!"
                        );
                        System.out.println(
                                "Vui lòng nhập theo dạng: dd/MM/yyyy HH:mm"
                        );
                    }

                    break;

                case 2:
                    System.out.println("\n===== DANH SÁCH SỰ KIỆN =====");

                    if (events.isEmpty()) {
                        System.out.println("Chưa có sự kiện nào.");
                    } else {
                        events.forEach(System.out::println);
                    }

                    break;

                case 3:
                    LocalDateTime now = LocalDateTime.now();

                    System.out.println("\n===== SỰ KIỆN ĐANG DIỄN RA =====");
                    System.out.println("Thời gian hiện tại: "
                            + now.format(formatter));

                    boolean found = false;

                    for (Event event : events) {

                        if (!now.isBefore(event.getStartDate())
                                && !now.isAfter(event.getEndDate())) {

                            System.out.println(event);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Hiện tại không có sự kiện nào đang diễn ra.");
                    }

                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        scanner.close();
    }
}
