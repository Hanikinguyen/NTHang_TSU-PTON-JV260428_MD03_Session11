import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {

        // Tạo danh sách số nguyên
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(35);

        // Sử dụng Lambda Expression để in các số chẵn
        System.out.println("Các số chẵn:");

        numbers.forEach(number -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        });

        // Sử dụng Lambda Expression để tính tổng
        int[] sum = {0};

        numbers.forEach(number -> sum[0] += number);

        System.out.println("Tổng các số: " + sum[0]);
    }
}
