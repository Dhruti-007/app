class ExamTask implements Runnable {
    private String activityName;
    private int sleepTime;

    public ExamTask(String activityName, int sleepTime) {
        this.activityName = activityName;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] "
                    + activityName + " - execution " + i);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
    }
}

public class OnlineExamDemo {
    public static void main(String[] args) {
        Runnable timerTask = new ExamTask("Displaying remaining time", 1000);
        Runnable autoSaveTask = new ExamTask("Auto-saving answers", 1500);
        Runnable networkCheckTask = new ExamTask("Checking network connection", 2000);

        Thread t1 = new Thread(timerTask);
        Thread t2 = new Thread(autoSaveTask);
        Thread t3 = new Thread(networkCheckTask);

        t1.setName("TimerThread");
        t2.setName("AutoSaveThread");
        t3.setName("NetworkCheckThread");

        t1.start();
        t2.start();
        t3.start();
    }
}
