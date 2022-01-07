import java.util.Scanner;

class Main {
    
    public static void main(String[] args) {
        // put your code here
         Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length ; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }

    int[][] newArr = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m ; j++) {
        newArr[j][n-1-i] = arr[i][j];
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n ; j++) {
        System.out.print(newArr[i][j] + " ");

      }
        System.out.println();
    }
    }
}
