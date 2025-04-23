import threading

# def increment_counter(process):
#     global counter
#     for _ in range(10):
#         with lock:
#             print(f"Proceso {process} incrementa el contador a: {counter}")
#             counter += 1

# counter = 0
# lock = threading.Lock()

# threads = [threading.Thread(target=increment_counter, args=(_+1,)) for _ in range(5)]
# [t.start() for t in threads]
# [t.join() for t in threads]

# print(f"Valor final del contador: {counter}")



lock = threading.RLock()

def recursive_task(n):
    with lock:
        print(f"Profundidad: {n}")
        if n > 0:
            recursive_task(n - 1)

threading.Thread(target=recursive_task, args=(10,)).start()

