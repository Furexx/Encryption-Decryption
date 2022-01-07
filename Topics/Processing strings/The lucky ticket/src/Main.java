import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String ticket = scanner.nextLine();
        char[] ticketNums = ticket.toCharArray();
        int[] nums = new int[ticketNums.length];
        for (int i = 0; i < ticketNums.length; i++) {
            nums[i] = Character.getNumericValue(ticketNums[i]);
        }
        if ((nums[0]+nums[1]+nums[2]) == (nums[3]+nums[4]+nums[5])){
            System.out.println("Lucky");
        }else {
            System.out.println("Regular");
        }
    }
}