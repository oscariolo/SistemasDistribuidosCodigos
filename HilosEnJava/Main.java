import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        
        //threadswithdifferentrunnables();
        //threadswithsamerunnable();
        //threadswithsharedobject();
        //threadswithSemaphore();
        //threadscommunication();
        //threadswithatomic();
    }

    public static void threadswithdifferentrunnables() {
         //Ejemplo de hilos con diferentes runnables
         MyRunnable runnable1 = new MyRunnable("Thread 1", 500);
         MyRunnable runnable2 = new MyRunnable("Thread 2", 1000);
        // Create two threads with different runnables
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for the threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted: " + e.getMessage());
        }
    }

    public static void threadswithsamerunnable(){
        MyRunnable runnable1 = new MyRunnable();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);

        // Start the threads
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted: " + e.getMessage());
        }

    }

    public static void threadswithsharedobject() {

        // Create two threads with the same shared object
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for the threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted: " + e.getMessage());
        }
    }

    public static void threadscommunication(){

        //Create runnables with locks
        ProducerRunnable producer = new ProducerRunnable();
        ConsumerRunnable consumer = new ConsumerRunnable();
        ProducerRunnable producer2 = new ProducerRunnable();
        

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");
        Thread producerThread2 = new Thread(producer2, "Producer2");


        // Start the threads
        producerThread.start();
        consumerThread.start();

        //producerThread2.start();

       
    }

    public static void threadswithSemaphore() {
        // Create a semaphore with 1 permit
        Semaphore semaphore = new Semaphore(2);

        // Create two threads with the same semaphore
        MyThread thread1 = new MyThread("Thread 1", semaphore);
        MyThread thread2 = new MyThread("Thread 2", semaphore);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void threadswithatomic() {
        // Create two threads with the same shared object
        ResourceModifier thread1 = new ResourceModifier("Thread 1");
        ResourceModifier thread2 = new ResourceModifier("Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();

       
    }

}