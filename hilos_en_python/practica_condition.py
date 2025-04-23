import threading
import time

condition = threading.Condition()
shared_data = []

def consumer():
    with condition:
        print("El consumidor está esperando...")
        condition.wait()
        print("El consumidor recibió:", shared_data[0])

def producer():
    with condition:
        shared_data.append("Datos!")
        print("El productor ha enviado datos.")
        time.sleep(2)
        condition.notify()

threading.Thread(target=consumer).start()
threading.Thread(target=producer).start()

