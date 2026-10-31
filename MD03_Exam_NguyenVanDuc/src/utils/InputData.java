package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputData {
    public static int getInt(Scanner scanner, String suggest) {
        while (true) {
            System.out.print(suggest);
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    public static String getString(Scanner scanner, String suggest) {
        while (true) {
            System.out.print(suggest);
            String str = scanner.nextLine();
            if(str.isEmpty()) {
                System.out.println("Vui lòng không để trống!");
                continue;
            }
            return str;
        }
    }

    public static LocalDateTime getDateTime(Scanner scanner, String suggest) {
        while (true) {
            System.out.print(suggest);
            String dateTime = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
                return localDateTime;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập đúng định dạng!");
            }
        }
    }
}
