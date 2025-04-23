public class ConsumerRunnable implements Runnable {


    @Override
    public void run() {
        while (true) {
            synchronized(Shared.queue){
                while(Shared.queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, waiting");
                        Shared.queue.wait(); // Release the lock and wait
                        System.out.println("Consumer awakened");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                }
                // Dequeue an item from the queue   
                System.out.println(Thread.currentThread().getName() + " is consuming: " + " Queue size: " + Shared.queue.size());
            
                Shared.queue.remove();
                Shared.queue.notifyAll();
                try {
                    Thread.sleep(500); // Sleep for a short duration to simulate work
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted: " + e.getMessage());
                }
            }
        }
        
    }

    
}
