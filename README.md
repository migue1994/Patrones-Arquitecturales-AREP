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

