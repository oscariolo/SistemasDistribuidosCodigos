# publisher_pubsub.py
import zmq
import time

context = zmq.Context()
socket = context.socket(zmq.PUB)
socket.bind("tcp://*:5556")

while True:
    socket.send_string("noticia Últimas noticias del día")
    print("Publicador: Enviado mensaje")
    time.sleep(1)
