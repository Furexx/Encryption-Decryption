import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int height = scanner.nextInt();
        int bridges = scanner.nextInt();
        int[] allBridges = new int[bridges];
        for (int i = 0; i < allBridges.length; i++) {
            allBridges[i] = scanner.nextInt();
        }
        boolean crash = false;
        int lastBridge = 0;
        for ( int i = 0; i < allBridges.length; i++) {
            if (height >= allBridges[i]){
                crash = true;
                lastBridge = i+1;
                break;
            }

        }
        if (!crash){
            System.out.println("Will not crash");
        }else {
            System.out.printf("Will crash on bridge %d",lastBridge);
        }
    }
}