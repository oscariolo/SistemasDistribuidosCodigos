public class ProducerRunnable implements Runnable {

    @Override
    public void run() {
        while(true){
        synchronized(Shared.queue) {
            while(Shared.queue.size() == 5) {
                try{
                    // Wait until the queue is not full
                    System.out.println(Thread.currentThread().getName() + " is waiting to produce: ");
                    Shared.queue.wait();
                } catch (InterruptedException e)    {
                    System.out.println("Thread was interrupted: " + e.getMessage());
                }
            }
            // Dequeue an item from the queue    
            Shared.queue.add(10);
            System.out.println(Thread.currentThread().getName() + " is producing: " + "Queue size: " + Shared.queue.size());
            Shared.queue.notifyAll();
            
          
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
        }
    }
    }
    
}
