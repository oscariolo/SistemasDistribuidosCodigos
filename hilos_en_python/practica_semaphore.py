import threading
import time

# # sem = threading.Semaphore(2)
# sem = threading.BoundedSemaphore(2)

# def access_resource(i):
#     print(f"Hilo {i} esperando")
#     sem.acquire()
#     print(f"El hilo {i} ha entrado")
#     time.sleep(1)
#     sem.release()
#     print(f"El hilo {i} ha salido")

# [threading.Thread(target=access_resource, args=(i+1,)).start() for i in range(10)]


# sem = threading.Semaphore(2)
sem = threading.BoundedSemaphore(2)

def forzar_error():
    sem.release()

threading.Thread(target=forzar_error).start()

