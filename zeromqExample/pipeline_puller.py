# worker_pipeline.py
import zmq

context = zmq.Context()
socket = context.socket(zmq.PULL)
socket.connect("tcp://localhost:5557")

while True:
    msg = socket.recv_string()
    print(f"Consumidor recibió: {msg}")
