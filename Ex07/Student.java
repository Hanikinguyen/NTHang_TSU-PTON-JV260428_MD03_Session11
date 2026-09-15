package Ex07;

public class Student {
    private String name;
    private String major;
    private double score;

    public Student(String name, String major, double score) {
        this.name = name;
        this.major = major;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Tên: " + name
                + ", Chuyên ngành: " + major
                + ", Điểm: " + score;
    }
}