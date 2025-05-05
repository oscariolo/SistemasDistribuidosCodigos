import zmq
import time

context = zmq.Context()
sender = context.socket(zmq.PUSH)
sender.bind("tcp://*:5557")

print("Enviando números para calcular factorial...\n")
for i in range(1, 16):
    sender.send_json({"id": i, "numero": i})
    print(f"Productor: Tarea enviada (factorial de {i})")
    time.sleep(0.2)
