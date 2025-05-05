import java.util.concurrent.atomic.AtomicInteger;

public class ResourceModifier extends Thread {
    private static AtomicInteger counter = new AtomicInteger(0);
    

    public ResourceModifier(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int updatedValue = counter.incrementAndGet();
            System.out.println(getName() + " updated counter to: " + updatedValue);
            try {
                Thread.sleep(500); // simulate work
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
        System.out.println(getName() + " finished execution.");
    }
    
}