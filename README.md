Codigos bien chingones de distribuidos

INSTRUCCIONES PARA JAVA MPJ

-Descargar mpj y descomprimir de la pagina: http://mpjexpress.org/index.html
-Desde la terminal ejecutar lo siguiente:
  export MPJ_HOME=/path/to/mpj/
  export PATH=$MPJ_HOME/bin:$PATH

-Haz tu programa en Java usando MPI
-Compila desde la terminal 
  javac -cp .:$MPJ_HOME/lib/mpj.jar HelloWorld.java
-Ejecuta
  mpjrun.sh -np 4 HelloWorld
