import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] cinema = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int counter = 0;
        int row = 0;
        for (int c = 0; c < n; c++) {
            for (int d = 0; d < m; d++) {
                if (cinema[c][d] == 0) {
                    counter++;
                    if (counter == k) {
                        row = c + 1;
                        break;
                    }
                }
                if (cinema[c][d] == 1) {
                    counter = 0;
                }
            }
            if (counter == k){
                break;
            }
            counter = 0;
        }
        System.out.println(row);
    }
}