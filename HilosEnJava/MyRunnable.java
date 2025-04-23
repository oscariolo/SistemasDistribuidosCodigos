public class MyRunnable implements Runnable {
    String name;
    int sleepTime;

    static int count = 1; // Static variable to keep track of the number of instances
    static int instances = 0; // Static variable to keep track of the number of instances

    MyRunnable(String name,int sleepTime) {
        // Constructor to initialize the thread with a name and sleep time
        this.name = name;
        this.sleepTime = sleepTime;
        
    }
    MyRunnable() {
        // Constructor to initialize the thread with a name and sleep time
        this.name = String.valueOf(instances++);
        this.sleepTime = 500;
        instances++;
        
    }

    @Override
    public void run() {
        // This method will be executed
        synchronized (this){ //when synchronized a thread will wait for the other thread to finish its execution
            for(int i = 0; i < 5; i++) {
            // Increment the static counter
            
            System.out.println(this.name + " is running:");
            System.out.println("Counter is: " + count);
            count++;
            try {
                // Sleep for a short duration to simulate work
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                // Handle the exception if the thread is interrupted
                System.out.println("Thread was interrupted: " + e.getMessage());
            }
            }
            System.out.println(" finished thread.");
        }
        
        
    
    }
}
