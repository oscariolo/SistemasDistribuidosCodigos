# subscriber_pubsub.py
import zmq

context = zmq.Context()
socket = context.socket(zmq.SUB)
socket.connect("tcp://localhost:5556")
socket.setsockopt_string(zmq.SUBSCRIBE, "noticia")

while True:
    msg = socket.recv_string()
    print(f"Suscriptor recibió: {msg}")
