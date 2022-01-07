import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String  n = scanner.nextLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        if (alphabet.contains(n)) {
            System.out.println("true");
        } else{
            System.out.println("false");
        }
    }
}