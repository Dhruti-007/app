class BankTask implements Runnable {
    private String activityName;
    private int sleepTime;

    public BankTask(String activityName, int sleepTime) {
        this.activityName = activityName;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int count = 1; count <= 3; count++) {
            System.out.println("[" + Thread.currentThread().getName() + "] "
                    + activityName + " | Execution Count: " + count);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
    }
}

public class BankingAppDemo {
    public static void main(String[] args) {
        Runnable transactionProcessing = new BankTask("Processing Transaction", 800);
        Runnable balanceUpdating = new BankTask("Updating Balance", 1200);
        Runnable smsNotification = new BankTask("Sending SMS Notification", 1500);

        Thread t1 = new Thread(transactionProcessing);
        Thread t2 = new Thread(balanceUpdating);
        Thread t3 = new Thread(smsNotification);

        t1.setName("TransactionThread");
        t2.setName("BalanceUpdateThread");
        t3.setName("SMSNotificationThread");

        t1.start();
        t2.start();
        t3.start();
    }
}
