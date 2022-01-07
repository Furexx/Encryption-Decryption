import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String dna = scanner.nextLine();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < dna.length(); i++) {
            int count = 1;
            while (i+1 < dna.length() && dna.charAt(i) == dna.charAt(i+1)){
                count++;
                i++;
            }


                buffer.append(dna.charAt(i));
                buffer.append(count);
        }
        System.out.println(buffer);
    }
}