import java.util.Scanner;

public class inMatran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();  // Đọc số lượng test cases
        StringBuilder result = new StringBuilder();  // Để lưu kết quả đầu ra
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();  // Đọc kích thước ma trận N x N
            int[] a = new int[N * N];  // Mảng chứa tất cả các phần tử của ma trận
            
            // Đọc tất cả các phần tử của ma trận vào mảng a
            for (int i = 0; i < N * N; i++) {
                a[i] = sc.nextInt();
            }
            
            // Xử lý và in ma trận theo yêu cầu
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    // Hàng chẵn: từ trái qua phải
                    for (int j = 0; j < N; j++) {
                        result.append(a[i * N + j]).append(" ");
                    }
                } else {
                    // Hàng lẻ: từ phải qua trái
                    for (int j = N - 1; j >= 0; j--) {
                        result.append(a[i * N + j]).append(" ");
                    }
                }
            }
            
            result.append("\n");  // Thêm xuống dòng cho mỗi ma trận
        }
        
        // In tất cả kết quả
        System.out.print(result.toString());
        sc.close();
    }
}