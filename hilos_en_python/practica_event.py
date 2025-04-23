import threading
import time

event = threading.Event()

def waiter():
    print("Esperando un evento")
    event.wait()
    print("Evento detectado!")

def worker():
    print("Trabajando...")
    time.sleep(2)
    print("Trabajo terminado!")
    event.set()

threading.Thread(target=waiter).start()
threading.Thread(target=worker).start()

