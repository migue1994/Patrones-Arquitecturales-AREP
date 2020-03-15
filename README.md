# Taller patrones estructurales

Este taller, tiene como objetivo presentar una pequeña aplicación web desplegada en una máquina virtual ec2 de amazon, esta debe ir conectada a una base de datos RDS, la cual contendrá todos los datos que se almacenen en el formulario de la aplicación, por otro lado, el fronted de la aplicación debe estar alojada en el almacenamiento estático de amazon, el cual es el servcio S3 que brinda esta compañía, con el fin de que el consumidor pueda ingresar desde cualquier navegador a la aplicación web creada anteriormente,y que esta funcione adecuandamente.

## Getting started

Para poder conpilar y hacer uso de la aplicación solo debe abrir una consola cmd y ubicarce en el directorio donde se encuentra descargado el proyecto, navegamos hastra donde se encuentra el archivo pom.xml y allí escribimos el siguiente comando.

``$ mvn spring-boot:run``

Esto ejecutará el servicio de springoboot, el cual contiene la API rest, junto con el fronted programado en JavaScript, una vez hecho esto, solo debe abrir en su navegador la dirección http://localhost:8080 donde se encontrará el formulario.

## Prerequisites

Para poder ejecutar este proyecto, debe tener instalado en su sitema operativo, las siguientes herramientas, en caso de que no las tenga, dejaré un link, que lo redirigirá a un tutorial de instalación.

-  [Java JDK](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm#JSJIG-GUID-A740535E-9F97-448C-A141-B95BF1688E6F)
- [Apache Maven](https://howtodoinjava.com/maven/how-to-install-maven-on-windows/)
- [Git](https://www.linode.com/docs/development/version-control/how-to-install-git-on-linux-mac-and-windows/)


## installing.

Para descargar este proyecto, solo debe abrir una consola cmd dentro de algún directorio, una vez alli, solo debe ingresar el siguiente comando:

``$ git clone https://github.com/migue1994/Taller-de-de-modularizaci-n-con-virtualizaci-n-e-Introducci-n-a-AWS.git``

Esto permitirá descagar todo el contenido de este repositorio en su máquina local, y así podra ejecutar el proyecto como se mencionó anteriormente

## Built with 

- Apache maven
- Java 8 JDK
- IntelliJ Idea

## Author

- Miguel Rivera

## License

[LICENSE.txt](LICENSE)

## Tutorial

### Configuración del S3

Iniciaremos configurando nuestro almacenamiento estático S3, el cual contendrá el frontend de la plicación web que creamos, para esto, solo debemos ir a nuestra cuenta de AWS, en los servicios encontraremos en la marte derecha, un menpu de alamacenamiento, que tendrá una opción que dice S3 como lo vemos en la siguiente imagen.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/InicioS3.PNG)

Al darle click, nos aparecerá esta pantalla, donde solo debemos presionar en el botón de crear bucket, un bucket es un contenedor en la nube, en donde se alojará el fronted de la aplicación.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/bucket.PNG)

Una vez hayamos dado click en crear, nos aparecerá el siguiente menú, donde se definirá el nombre del bucket, en este caso lo nombraré como patrones, luego damos en siguiente.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/crearbucket1.PNG)

Nos aparecerá otra interfás de configuración de propiedades, aquí solo dejamos las que hay por defecto y damos en siguiente.

Nos saldrá la configuración de opciones, en donde debemos desmarcar la casilla de bloquear todo el acceso público, esto con el fín de que nuestra UI, este disponible para cualquier usuario.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/configurarbucket2.PNG)

Despues nos aparecerá una configuración de seguridad, la cual dejaremos por defecto y daremos click en crear bucket.

Hecho esto, nos aparecerá el nuevo bucket en la lista de buckets de esta forma

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/bucketcreado.PNG)

Seleccionamos el nuevo buscket, y nos aparecerá la siguiente interfaz, donde podremos cargar nuestros archivos.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/interfazbucket.PNG)

Como vemos en la imagen anterior, hay un boton en la parte superior izquierda que nos permite cargar nuestros archivos, damos clicl allí y nos saldra esta ventana de carga, donde podremos cargar los archivos arrastrandolos o mediante la interfaz que todos conocemos, en micaso, solo arrastré los archivos

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/cargar.PNG)

Damos click en siguiente, nos aparecerá una ventana de configuración de usuarios, dejamos todo por defecto y daremos en siguiente, nos aparecerá una ventana de clase de almacenamiento, aquí eligiremos de acuerdo con la necesidad que tengamos en el momento, en este caso como la actividad  es de caracter académica, elegimos la opción estandar, que no tiene algún costo asociado, damos click en siguiente y por último en cargar.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/almacenamiento.PNG)

Una vez hemos hecho esto, solo damos en cargar, y ya nos aparecerán los archivos dentro del bucket.

Ahora solo debemos seleccionar todos los archivos, y en el botón de acciones, habrá una opcion que nos permitirá volver visibles todos los archivos, seleccionamos esa opción.

Hecho esto, solo nos queda abrir el archivo index en el navegador, se nos verá así

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/amaxons3.PNG)

Sin embargo, la aplicación aún no es funcional y debemos conectarla al backend.

### Configuración del sistema EC2

Para crear una instancia EC2, simplemente ingresamos a servicios y buscamos la opción del EC2, que esta en el menú de informática, una vez a quí solo damos en el botón de lanzar instancia.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/instancias2.PNG)

Hecho esto, nos saldrá una cantidad de pasos a realizar, comensando con la elección del tipo de instancia que se desea crear, en este caso vamos a seleccionar la Amazon Linux AMI 2018.03.0, que cuenta con java y algunos programas más que nos serán de utilidad.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/seleccion.PNG)

Proseguiremos seleccionando el tamaño de la máquina como se muestra en la imagen y luego damos en next.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/step2.PNG)

Despues nos saldrá un menú de que pide la configuración de la instancia, aquí solo damos en siguiente.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/step3.PNG)

El almacenamiento lo dejamos como aparece por defecto con 8GB de memoria y damos click en next.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/step4.PNG)

En la ventana de tags, lo dejamos por defecto y damos en siguiente.

En la ventana de Security group, debemmos crear uno nuevo, con el fin de poder controlar la entrada y salida de esta instancia, vamos a configurar como se ve en la imagen.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/step6.PNG)

Como vemos, lo que hice fue adicionar 2 nuevas reglas que me permiten abrir los puertos 5432 y el 8080 correspondientes a postgresql y el de tomcat, que es donde se ejecuta el servicio rest.

Hecho esto damos en review and launcn, nos saldrá un resumen de la instancia, damos en launch.

Nos saldrá una ventana que nos pedirá un llave para realizar la conexiónde manera remota, en mi caso yo ya tengo una creada, pero en caso contrario, solo seleccionamos crear una nueva llave, la cual se nos descargará y es la que usaremos más tarde para conectar con la máquina.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/keypair.PNG)

Ya la podremos ver en nuestra lista de instancias.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/instancias.PNG)

Ahora debemos conectar la máquina de manera remota, para ello, debemos abrir una ventana de consola donde descargamos la llave y escribimos el siguiente código.

``$ ssh -i "migue1994.pem" ec2-user@ec2-3-88-130-241.compute-1.amazonaws.com``

nos deberá aparecer esto.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/ec2.PNG)

Estando aquí, debemos instalar algunas herramientas que son [git](https://linuxconcept.com/install-git-on-rhel-7-operating-system/), [maven](https://docs.aws.amazon.com/neptune/latest/userguide/iam-auth-connect-prerq.html) y java

para instalar llava, debemos introducir los siguientes códigos.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/installljava.PNG)

Una vez que hayamos realizado lo anterior, solo debemos clonar el contenido que tengo en este repositorio, que contiene el backend de la aplicación.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/clonando.PNG)

Con esto, ya tenemos configurado nuestro S3 y EC2, ahora procederemos a crear la base de datos.

### Base de datos RDS

Para crear la base de datos, debemos ir nuevamente al menú de servicios y seleccionar la opción de RDS que se encuentra en el menú de bases de datos.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/rds.PNG)

Estando ahí solo damos en el botón de create data base.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/createdatabase.PNG)

nos saldrá una ventana donde debmos configurar la base de datos.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/motor.PNG)

Definimos una contraseña.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/pass.PNG)

por último, damos click en el boton de create database.

Esperamos por un tiempo mientras se crea la base de datos, despues la seleccionamos y presionamos en el botón modify, esto es para poder modificar ciertas configuraciones que hicieron falta.

Entre ellas, debemos volver la base de datos pública, con el fín de que podamos conectarla a la aplicación web, y debemos selecionar el VPC que creamos anteriormente, para que estas puedan hablarse.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/basepublica.PNG)

Luego debemos conectarla base de datos, para esto debemos extraer el endpoint que se muestra cuendo seleccionamos la instancia en la lista de bases de datos que tenemos.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/settings.PNG)

Vamos al archivo configuration.properties que se encuentra en la aplicación web y modificamos el archivo, de tal manera que se vea así

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/applicationproperties.PNG)

Una vez hecho esto, solo actualizamos nuestro repoositorio git, y realizamos pull en nuestra máquina remota, ahora solo debemos ejecutar el servicio rest, mediante el código ``$ mvn spring-boot:run`` en nuestra máquina remota, nos aparecerá la siguiente pantalla.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/spring.PNG)

Por último, debemos actualizar la url hacia donde apunta el fronend de la aplicación con el vpn de la máquina ec2 que creamos.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/updatefront.PNG)

Hecho esto, solo debemos voler a cargar el archivo js que modificamos al bucket que creamos al principio, y ya podremos ejecutar correctamente la aplicación como se puede ver en la siguiente imagen.

![](https://github.com/migue1994/Patrones-Arquitecturales-AREP/blob/master/img/app.PNG)

