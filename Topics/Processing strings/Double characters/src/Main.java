import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        for (int i = 0; i < n.length(); i++) {
            System.out.print(n.charAt(i) + n.substring(i,i + 1));
        }

    }
}