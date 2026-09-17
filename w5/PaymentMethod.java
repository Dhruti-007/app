import java.util.Scanner;

interface PaymentMethod {
    void makePayment(double amount);
}

class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI ID: " + upiId);
    }
}

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card ending with " +
                cardNumber.substring(cardNumber.length() - 4));
    }
}

class NetBankingPayment implements PaymentMethod {
    private String bankName;

    public NetBankingPayment(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid Rs." + amount + " using Net Banking (" + bankName + ")");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select payment method: 1-UPI 2-Credit Card 3-Net Banking");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        PaymentMethod payment;

        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.print("Enter UPI ID: ");
                payment = new UPIPayment(sc.nextLine());
                break;
            case 2:
                sc.nextLine();
                System.out.print("Enter Card Number: ");
                payment = new CreditCardPayment(sc.nextLine());
                break;
            case 3:
                sc.nextLine();
                System.out.print("Enter Bank Name: ");
                payment = new NetBankingPayment(sc.nextLine());
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        payment.makePayment(amount); // polymorphic call
    }
}