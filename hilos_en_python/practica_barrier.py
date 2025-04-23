import threading
import time

barrier = threading.Barrier(3)

def worker(i):
    print(f"Hilo {i} esperando en la barrera")
    time.sleep(i)
    barrier.wait()
    print(f"Hilo {i} ha cruzado la barrera")

[threading.Thread(target=worker, args=(i+1,)).start() for i in range(6)]