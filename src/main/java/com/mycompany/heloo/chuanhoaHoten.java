package com.mycompany.heloo;
import java.util.Scanner;

public class chuanhoaHoten {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống sau khi nhập số lượng

        while (t-- > 0) {
            String name = sc.nextLine();
            String afterN = normalize(name);
            System.out.println(afterN);
        }

        sc.close(); // Đóng scanner sau khi hoàn tất
    }

    private static String normalize(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)));
            sb.append(" ");
        }
        for(String w : words){
            sb.append(w.substring(0));
            sb.append(" ");
        }
        
        // Xóa khoảng trắng thừa ở cuối và trả về chuỗi
        return sb.toString().trim();
    }
}
