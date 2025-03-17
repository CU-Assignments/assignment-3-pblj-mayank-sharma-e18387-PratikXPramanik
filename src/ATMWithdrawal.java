import java.util.Scanner;

class ATM {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            if (pin != CORRECT_PIN) {
                throw new SecurityException("Error: Invalid PIN.");
            }
            
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            if (amount > balance) {
                throw new IllegalArgumentException("Error: Insufficient balance. Current Balance: " + balance);
            }
            
            balance -= amount;
            System.out.println("Withdrawal Successful. Remaining Balance: " + balance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final Balance: " + balance);
            scanner.close();
        }
    }
}