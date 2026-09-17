class TrafficJunction extends Thread {
    private String trafficStatus;
    private int sleepTime;

    public TrafficJunction(String junctionName, String trafficStatus, int sleepTime) {
        super(junctionName); // sets thread name via Thread's constructor
        this.trafficStatus = trafficStatus;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + getName() + "] Traffic Status: " + trafficStatus
                    + " (Report " + i + ")");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }
    }
}

public class TrafficManagementDemo {
    public static void main(String[] args) {
        TrafficJunction junction1 = new TrafficJunction("Junction-A", "Heavy Traffic", 1000);
        TrafficJunction junction2 = new TrafficJunction("Junction-B", "Moderate Traffic", 1500);
        TrafficJunction junction3 = new TrafficJunction("Junction-C", "Light Traffic", 2000);

        // Names already set via constructor; setName() shown here for clarity
        junction1.setName("Junction-A");
        junction2.setName("Junction-B");
        junction3.setName("Junction-C");

        junction1.start();
        junction2.start();
        junction3.start();
    }
}
