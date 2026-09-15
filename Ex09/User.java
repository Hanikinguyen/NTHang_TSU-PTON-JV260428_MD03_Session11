package Ex09;

import java.util.Optional;

public class User {

    private int id;
    private String name;
    private Optional<String> email;

    // Constructor đầy đủ
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    @Override
    public String toString() {

        String emailDisplay = email.orElse("Chưa có email");

        return "Tên: " + name
                + " | Email: " + emailDisplay;
    }
}
