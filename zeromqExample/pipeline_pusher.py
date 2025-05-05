# producer_pipeline.py
import zmq
import time

context = zmq.Context()
socket = context.socket(zmq.PUSH)
socket.bind("tcp://*:5557")

for i in range(5):
    socket.send_string(f"Tarea {i}")
    print(f"Productor envió: Tarea {i}")
    time.sleep(1)
