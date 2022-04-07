package hilos;

public class HiloI implements Runnable {

    protected String threadNameR;
    private long initialTimeR;

    /*
    Constructor, it receives a String and the time
    */
    public HiloI(String threadNameR, long initialTimeR) {
        super();
        this.threadNameR = threadNameR;
        this.initialTimeR = initialTimeR;
    }

    /*
    Methods
    */
    @Override
    public void run() {
        System.out.println("Thread " + this.threadNameR + " starts");
        for (int i = 0; i < 2; i++) {
            this.waiting();
            System.out.println("\nUsing Runnable " + getClass().getSimpleName());
        }

        System.out.println("Thread " + this.threadNameR + " has finished. TIME ELAPSED: " + (System.currentTimeMillis() - this.initialTimeR) / 1000 + " seconds\n");
    }

    private void waiting() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
