import mpi.*;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        // Initialize the MPI execution environment
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        // Define the problem: sum integers from 1 to N (here, N = 100)
        int N = 100;
        // Calculate the number of integers each process will handle
        int numbersPerProcess = N / size;
        // Determine the start and end values for this process
        int start = rank * numbersPerProcess + 1;
        int end = (rank == size - 1) ? N : (rank + 1) * numbersPerProcess;

        // Each process computes its partial sum in its assigned range
        int partialSum = 0;
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
        System.out.println("Process " + rank + " computed partialSum: " + partialSum);

        // Prepare buffers for the reduction operation
        int[] sendBuf = new int[]{ partialSum };
        int[] recvBuf = new int[1];

        // Use MPI Reduce to sum the partial sums across all processes.
        // The result is stored in process 0.
        MPI.COMM_WORLD.Reduce(sendBuf, 0, recvBuf, 0, 1, MPI.INT, MPI.SUM, 0);

        // Process 0 prints the total sum.
        if (rank == 0) {
            System.out.println("Total sum is: " + recvBuf[0]);
        }

        // Finalize the MPI execution environment.
        MPI.Finalize();
    }
}