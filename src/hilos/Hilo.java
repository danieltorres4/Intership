package hilos;

public class Hilo extends Thread {

    String threadName;
    long initialTime;
    
    /*
    Constructor, it receives a String and the time
    */
    public Hilo(String threadName, long initialTime) {
        this.threadName = threadName;
        this.initialTime = initialTime;
    }

    /*
    Methods
    */
    @Override
    public void run() {
        System.out.println("Thread " + this.threadName + " starts");
        for (int i = 0; i < 2; i++) {
            this.waiting(); //waiting time
            System.out.println("\nUsing Thread " + getName());
        }

	//Getting thread's total time
        System.out.println("Thread " + this.threadName + " has finished. TIME ELAPSED: " + (System.currentTimeMillis() - this.initialTime) / 1000 + " seconds\n");

    }
	
    //Getter
    public void getThreadName(String threadName) {
        this.threadName = threadName;
    }

    private void waiting() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
