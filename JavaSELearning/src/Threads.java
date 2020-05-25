public class Threads {
    public static void main(String[] args) {
/*        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("running " + Thread.currentThread().getName());
            }
        };

        Thread threadIvana = new Thread(runnable, "Ivana");
        Thread threadLjupce = new Thread(runnable, "Ljupce");
        Thread threadJasmina = new Thread(runnable, "Jasmina");

        threadIvana.start();
        threadLjupce.start();
        threadJasmina.start();*/

        // new -> runnable <-> running -> waiting/blocking/sleeping und dead
        // each tread must be in runnable state in order to be taken by the processor or runner or to goes to running state.
        // from sleep it gets back to runnable but it does not means that it will be chosen, it may be more then that thread that
        // wait in the runnable pool and other can be chosen. it is not like async in js
        // yield method makes the current running thread to go back into runnable state, so that the other threads with same priority can execute.
        // with sleep on a thread we say to it to sleep sometime so that other threads from runnable pool can be executed.
        // when time ends by wakeup event that thread is get back to runnable pool again
        // scheduler can use time slots (runnable, running) so that each thread can have a chance to run or can use something else
        // with join method we put the thread in blocked state, that (is not runnable, nor running) means
        // t.join() t will become running and must finish, or the blocked thread is blocked until t is finished or in dead state
        // and then it can be put into the runnable pool again.

        Runnable runnableWithSleep = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("running " + i);
                if (i % 10 == 0) {
                    System.out.println("It is teenth. " + i);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnableWithSleep);
        Thread thread2 = new Thread(runnableWithSleep);
        thread1.start();
        thread2.start();

    }
}
