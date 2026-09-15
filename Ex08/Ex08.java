package Ex08;

import java.time.LocalDate;
import java.util.List;

public class Ex08 {

    public static void main(String[] args) {

        // Khởi tạo danh sách đơn hàng
        List<Order> orders = List.of(

                new Order(
                        1,
                        "Quý",
                        LocalDate.of(2025, 3, 20),
                        LocalDate.of(2025, 3, 25)
                ),

                new Order(
                        2,
                        "Lan",
                        LocalDate.of(2025, 3, 21),
                        null
                ),

                new Order(
                        3,
                        "Minh",
                        LocalDate.of(2025, 3, 22),
                        LocalDate.of(2025, 3, 23)
                ),

                new Order(
                        4,
                        "Huyền",
                        LocalDate.of(2025, 3, 23),
                        null
                ),

                new Order(
                        5,
                        "Việt",
                        LocalDate.of(2025, 3, 23),
                        LocalDate.of(2025, 3, 30)
                )
        );

        // 1. Liệt kê các đơn hàng đã được giao
        System.out.println("===== ĐƠN HÀNG ĐÃ GIAO =====");

        orders.stream()
                .filter(order -> order.getDeliveryDate().isPresent())
                .forEach(order ->
                        System.out.println(order.toDisplayString())
                );


        // 2. Liệt kê các đơn hàng chưa được giao
        System.out.println("\n===== ĐƠN HÀNG CHƯA GIAO =====");

        orders.stream()
                .filter(order -> order.getDeliveryDate().isEmpty())
                .forEach(order ->
                        System.out.println(order.toDisplayString())
                );


        // 3. Đếm số đơn hàng đã giao
        // trong khoảng từ 17/03/2025 đến 23/03/2025

        LocalDate fromDate = LocalDate.of(2025, 3, 17);
        LocalDate toDate = LocalDate.of(2025, 3, 23);

        long count = orders.stream()
                .filter(order -> order.getDeliveryDate().isPresent())
                .filter(order -> {

                    LocalDate deliveryDate =
                            order.getDeliveryDate().get();

                    return !deliveryDate.isBefore(fromDate)
                            && !deliveryDate.isAfter(toDate);
                })
                .count();

        System.out.println("\n===== THỐNG KÊ =====");
        System.out.println(
                "Số đơn đã giao từ "
                        + fromDate
                        + " đến "
                        + toDate
                        + ": "
                        + count
        );


        // 4. In thông tin tất cả đơn hàng
        System.out.println("\n===== TẤT CẢ ĐƠN HÀNG =====");
        System.out.println("ID | Tên KH | Ngày đặt | Ngày giao");

        orders.forEach(order ->
                System.out.println(order.toDisplayString())
        );
    }
}
