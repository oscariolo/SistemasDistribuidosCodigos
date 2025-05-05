import zmq
import math
import sys
import time

context = zmq.Context()
receiver = context.socket(zmq.PULL)
receiver.connect("tcp://localhost:5557")

def calcular_factorial(n):
    return math.factorial(n)

while True:
    tarea = receiver.recv_json()
    numero = tarea["numero"]
    resultado = calcular_factorial(numero)
    print(f"[Worker {sys.argv[1]}] factorial({numero}) = {resultado}")
    time.sleep(0.5)  # Simula tiempo de procesamiento
