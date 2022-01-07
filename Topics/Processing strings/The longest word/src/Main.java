import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        int max = 0;
        String longest = null;
        for (String s: words){
            if (max < s.length()){
                max = s.length();
                longest = s;
            }
        }

        System.out.println(longest);
    }
}