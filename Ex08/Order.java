package Ex08;

import java.time.LocalDate;
import java.util.Optional;

public class Order {

    private int id;
    private String customerName;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;

    // Constructor rỗng
    public Order() {
    }

    // Constructor đầy đủ
    public Order(int id, String customerName,
                 LocalDate createdDate, LocalDate deliveryDate) {

        this.id = id;
        this.customerName = customerName;
        this.createdDate = createdDate;

        // Nếu deliveryDate = null thì Optional.empty()
        // Nếu có ngày giao thì Optional.of(deliveryDate)
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    // Hiển thị thông tin đơn hàng
    public String toDisplayString() {

        String delivery = deliveryDate
                .map(LocalDate::toString)
                .orElse("Chưa giao");

        return id + " | "
                + customerName + " | "
                + createdDate + " | "
                + delivery;
    }
}
