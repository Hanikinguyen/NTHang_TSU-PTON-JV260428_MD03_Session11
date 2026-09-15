import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Danh sách lưu trữ tin nhắn
        List<Message> messages = new ArrayList<>();

        DateTimeFormatter dateFormatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int choice;

        do {
            System.out.println("\n===== ỨNG DỤNG CHAT =====");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem lịch sử chat");
            System.out.println("3. Lọc tin nhắn theo người gửi");
            System.out.println("4. Lọc tin nhắn theo ngày");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    // Gửi tin nhắn
                    System.out.print("Nhập tên người gửi: ");
                    String sender = scanner.nextLine();

                    System.out.print("Nhập nội dung tin nhắn: ");
                    String content = scanner.nextLine();

                    Message message = new Message(
                            sender,
                            content,
                            LocalDateTime.now()
                    );

                    messages.add(message);

                    System.out.println("Đã gửi tin nhắn!");
                    break;

                case 2:
                    // Xem lịch sử chat
                    System.out.println("\n===== LỊCH SỬ CHAT =====");

                    if (messages.isEmpty()) {
                        System.out.println("Chưa có tin nhắn.");
                    } else {
                        messages.forEach(System.out::println);
                    }

                    break;

                case 3:
                    // Lọc theo người gửi
                    System.out.print("Nhập tên người gửi cần tìm: ");
                    String searchSender = scanner.nextLine();

                    System.out.println("\n===== TIN NHẮN CỦA "
                            + searchSender + " =====");

                    messages.stream()
                            .filter(messageItem ->
                                    messageItem.getSender()
                                            .equalsIgnoreCase(searchSender))
                            .forEach(System.out::println);

                    break;

                case 4:
                    // Lọc theo ngày
                    System.out.print(
                            "Nhập ngày cần tìm (dd/MM/yyyy): "
                    );

                    String dateInput = scanner.nextLine();

                    try {
                        LocalDate searchDate =
                                LocalDate.parse(dateInput, dateFormatter);

                        System.out.println(
                                "\n===== TIN NHẮN NGÀY "
                                        + dateInput + " ====="
                        );

                        messages.stream()
                                .filter(messageItem ->
                                        messageItem.getTimestamp()
                                                .toLocalDate()
                                                .equals(searchDate))
                                .forEach(System.out::println);

                    } catch (DateTimeParseException e) {
                        System.out.println(
                                "Lỗi: Ngày không đúng định dạng!"
                        );
                        System.out.println(
                                "Vui lòng nhập theo dạng dd/MM/yyyy."
                        );
                    }

                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println(
                            "Lựa chọn không hợp lệ!"
                    );
            }

        } while (choice != 0);

        scanner.close();
    }
}

