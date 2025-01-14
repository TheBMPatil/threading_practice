public class ThreadStates {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            try {
                // Simulate TIMED_WAITING state
                Thread.sleep(1000);

                // Simulate WAITING state
                synchronized (lock) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // NEW state: Thread is created but not started
        System.out.println("State after thread creation: " + thread.getState());

        thread.start();
        System.out.println("State after thread.start(): " + thread.getState());

        try {
            // Allow the thread to transition to TIMED_WAITING
            Thread.sleep(200);
            System.out.println("State when thread is RUNNABLE or TIMED_WAITING: " + thread.getState());

            // Simulate BLOCKED state
            synchronized (lock) {
                Thread.sleep(200); // Hold the lock for a moment
                System.out.println("State when thread is BLOCKED: " + thread.getState());
            }

            // Wait for the thread to enter WAITING state
            Thread.sleep(200);
            System.out.println("State when thread is WAITING: " + thread.getState());

            // Notify the thread to complete
            synchronized (lock) {
                lock.notify();
            }

            // Wait for the thread to terminate
            thread.join();
            System.out.println("State after thread termination: " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
