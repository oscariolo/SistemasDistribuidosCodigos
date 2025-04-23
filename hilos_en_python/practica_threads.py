import threading
import time
import queue

# def print_numbers():
#     for i in range(1, 11):
#         print(i)
#         threading.Event().wait(1)

# def print_letters():
#     for letter in 'abcdefghij':
#         print(letter)
#         threading.Event().wait(3)

# thread1 = threading.Thread(target=print_numbers)
# thread2 = threading.Thread(target=print_letters)

# thread1.start()
# thread2.start()

# thread1.join()
# thread2.join()

# print("Done")



# def increment_counter(process):
#     global counter
#     for _ in range(10):
#         with lock:
#             print(f"Proceso {process} incrementa el contador a: {counter}")
#             counter += 1

# counter = 0
# lock = threading.RLock()

# threads = [threading.Thread(target=increment_counter, args=(_+1,)) for _ in range(5)]
# [t.start() for t in threads]
# [t.join() for t in threads]

# print(f"Valor final del contador: {counter}")



# lock = threading.RLock()

# def recursive_task(n):
#     with lock:
#         print(f"Profundidad: {n}")
#         if n > 0:
#             recursive_task(n - 1)

# threading.Thread(target=recursive_task, args=(10,)).start()



# sem = threading.Semaphore(2)
# sem = threading.BoundedSemaphore(2)

# def access_resource(i):
#     print(f"Hilo {i} esperando")
#     sem.acquire()
#     print(f"El hilo {i} ha entrado")
#     time.sleep(1)
#     sem.release()
#     print(f"El hilo {i} ha salido")

# [threading.Thread(target=access_resource, args=(i+1,)).start() for i in range(10)]



# sem = threading.BoundedSemaphore(1)

# def forzar_error():
#     sem.release()

# threading.Thread(target=forzar_error).start()



# condition = threading.Condition()
# shared_data = []

# def consumer():
#     with condition:
#         print("El consumidor está esperando...")
#         condition.wait()
#         print("El consumidor recibió:", shared_data[0])

# def producer():
#     with condition:
#         shared_data.append("Datos!")
#         print("El productor ha enviado datos.")
#         time.sleep(2)
#         condition.notify()

# threading.Thread(target=consumer).start()
# threading.Thread(target=producer).start()



# event = threading.Event()

# def waiter():
#     print("Esperando un evento")
#     event.wait()
#     print("Evento detectado!")

# threading.Thread(target=waiter).start()
# print("Preparando el evento")
# time.sleep(2)
# event.set()


# barrier = threading.Barrier(3)

# def worker(i):
#     print(f"Hilo {i} esperando en la barrera")
#     time.sleep(i)
#     barrier.wait()
#     print(f"Hilo {i} ha cruzado la barrera")

# [threading.Thread(target=worker, args=(i+1,)).start() for i in range(6)]



q = queue.Queue()

def producer():
    for i in range(5):
        q.put(f"Item {i+1}")
        print("Producido:", i+1)
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