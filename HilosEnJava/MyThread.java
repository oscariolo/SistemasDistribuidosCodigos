import java.util.concurrent.Semaphore;

public class MyThread extends Thread{
    private Semaphore sem; // Semaphore for synchronization

    MyThread(String name){
        super(name);
    }

    MyThread(String name, Semaphore sem){
        super(name);
        this.sem = sem;
    }
    public void run(){
        if(this.sem != null){
            try{
                sem.acquire(); // Acquire the semaphore
                System.out.println(getName() + " acquired semaphore.");
                for(int i = 0; i < 5; i++){
                    System.out.println(getName() + " is running: ");
                    System.out.println("Counter is: " + Shared.count);
                    Shared.count++;
                    try{
                        Thread.sleep(500); // Sleep for a short duration to simulate work
                    } catch (InterruptedException e){
                        System.out.println("Thread was interrupted: " + e.getMessage());
                    }
                }
                System.out.println(getName() + " finished thread.");
            } catch (InterruptedException e){
                System.out.println("Thread was interrupted: " + e.getMessage());
            } finally {
                sem.release(); // Release the semaphore
                System.out.println(getName() + " released semaphore.");
            }
        }
        else{
        synchronized(Shared.class){ // Synchronize on the shared object
            for(int i = 0; i < 5; i++){
                System.out.println(getName() + " is running: ");
                System.out.println("Counter is: " + Shared.count);
                Shared.count++;
                try{
                    Thread.sleep(500); // Sleep for a short duration to simulate work
                } catch (InterruptedException e){
                    System.out.println("Thread was interrupted: " + e.getMessage());
                }
            }
            System.out.println(getName() + " finished thread.");
        }
        }
    }
}
