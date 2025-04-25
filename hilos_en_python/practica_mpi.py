## suma_paralela.py
from mpi4py import MPI
import numpy as np

comm = MPI.COMM_WORLD
rank = comm.Get_rank()
size = comm.Get_size()

# Tamaño total del array (por ejemplo, 100 elementos)
N = 1000

# Solo el proceso 0 crea el arreglo completo
if rank == 0:
    data = np.arange(N, dtype='i')  # Arreglo: [0, 1, 2, ..., N-1]
    print(f"[Proceso 0] Arreglo completo: {data}")
else:
    data = None

# Dividir el arreglo en partes iguales para cada proceso
chunk_size = N // size
sub_data = np.empty(chunk_size, dtype='i')

# Distribuir los datos (scatter)
comm.Scatter(data, sub_data, root=0)

# Cada proceso suma su parte
local_sum = np.sum(sub_data)
print(f"[Proceso {rank}] Suma local: {local_sum}")

# Recolectar las sumas parciales y calcular la suma total (reduce)
total_sum = comm.reduce(local_sum, op=MPI.SUM, root=0)

# Mostrar resultado final en el proceso 0
if rank == 0:
    print(f"[Proceso 0] Suma total: {total_sum}")
