package test;

import hilos.*;

public class Test {

    public static void main(String[] args) {
	//Initializing current time
        long initialTime = System.currentTimeMillis();

	//Objects
        Hilo myThread = new Hilo("One", initialTime);
        Hilo myThread2 = new Hilo("Two", initialTime);

        Thread myThread3 = new Thread(new HiloI("Three", initialTime));
        Thread myThread4 = new Thread(new HiloI("Four", initialTime));

        //myThread.getThreadName("One");
        //myThread2.getThreadName("Two");
        myThread.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
    }
}
