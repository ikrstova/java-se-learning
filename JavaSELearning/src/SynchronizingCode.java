public class SynchronizingCode implements Runnable {

    private Account account = new Account();

    public static void main(String[] args) {
        SynchronizingCode theJob = new SynchronizingCode();
        Thread FredThread = new Thread(theJob, "Fred");
        Thread LucyThread = new Thread(theJob, "Lucy");
        FredThread.start();
        LucyThread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            makeWithdrawn(10);
            if (account.getBalance() < 0) {
                System.out.println("The amount is overdrawn.");
            }
        }
    }

    private synchronized void makeWithdrawn(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println("the thread which is going to make a withdraw is " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(amount);
            System.out.println("The withdraw is done by: " + Thread.currentThread().getName());
        } else {
            System.out.println("There is not enough amount for " + Thread.currentThread().getName() + " to withdrawn from " + account.getBalance());
        }
    }

}

class Account {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
