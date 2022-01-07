import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int half = ((word.length()) / 2)+1;
        if (word.length() % 2 != 0) {
          System.out.print(word.substring(0,half-1));
            System.out.println(word.substring(half));
        }
        else {
            System.out.print(word.substring(0,half-2));
            System.out.print(word.substring(half));
        }
    }
    }