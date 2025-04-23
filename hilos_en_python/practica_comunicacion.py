import threading
import time
import queue


q = queue.Queue()

def producer():
    for i in range(5):
        q.put(f"Item {i+1}")
        print("Producido: Item ", i+1)
        time.sleep(1)

def consumer():
    while True:
        item = q.get()
        if item is None:
            break
        print("Consumido:", item)
        q.task_done()

t1 = threading.Thread(target=producer)
t2 = threading.Thread(target=consumer)
t1.start()
t2.start()
t1.join()
q.put(None)  # Señal de fin al consumidor
t2.join()

