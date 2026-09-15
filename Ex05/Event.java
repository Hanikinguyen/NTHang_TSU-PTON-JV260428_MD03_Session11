import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Tên sự kiện: " + name
                + ", Bắt đầu: " + startDate.format(formatter)
                + ", Kết thúc: " + endDate.format(formatter);
    }
}
