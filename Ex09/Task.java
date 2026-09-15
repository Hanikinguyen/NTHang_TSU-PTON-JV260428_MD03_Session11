package Ex09;

import java.time.LocalDate;

public class Task {

    private int id;
    private String title;
    private User assignedTo;
    private LocalDate dueDate;
    private boolean completed;

    // Constructor đầy đủ
    public Task(int id, String title, User assignedTo,
                LocalDate dueDate, boolean completed) {

        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {

        return "ID: " + id
                + " | Công việc: " + title
                + " | Người thực hiện: " + assignedTo.getName()
                + " | Hạn: " + dueDate
                + " | Hoàn thành: "
                + (completed ? "Có" : "Chưa");
    }
}
