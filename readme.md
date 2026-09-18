![foto1](/Capturas/1.png)
PID: 11321 PPID: 8155
![foto2](/Capturas/3.png)
PID: 19284 PPID:19133
* ¿Porque cambia el ppid?
El ppid refleja la identidad de donde se esta lanzando ese programa por eso en el terminal sale un numero y en terminal del intellij sale otro.
* Con el comando:

Cambia el PID: de 19284 a 19955

* Ejecutadlo después con java -Xmx128m InformeSistema y comparad las cuatro cifras de
  memoria con las de la ejecución normal. Indicad cuáles cambian, cuáles no y por qué.
  ![foto3](/Capturas/4.png)
  ![foto3](/Capturas/5.png)
  ![img.png](src/img.png)
  Cambia el PID: de 19284 a 19955 cambia porque porque se asignan de manera dinámica cada vez que un programa o tarea inicia en el sistema operativo, y al cerrarse, ese número queda libre y se reutiliza o se incrementa para los nuevos procesos 
* qué ruta generaría en el otro sistema operativo, explicando de dónde sale la diferencia.

La diferencia se debe a que el código no escribe la ruta a mano (hardcoded), sino que la construye dinámicamente consultando dos propiedades del sistema Java

# 3 Qué tipo de programación encaja
* a) Un servidor web que atiende 500 peticiones a la vez en una máquina de 8 núcleos
- Es concurrente porque gestiona 500 peticiones solapando su ejecución mediante hilos para dar respuesta a todos los clientes sin bloquearse
* b) Renderizar una película de animación en un plazo de tres meses.
* c) Una app de móvil que descarga un fichero mientras seguís navegando.
* d) Un cálculo que no cabe en la RAM de un solo equipo.