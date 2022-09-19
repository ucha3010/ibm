El programa tiene hecho un sencillo front para poder utilizarlo.

Los pasos serían:
1. Tener phpMyAdmin instalado.
2. Encender MySQL (con el XAMPP por ejemplo)
3. Exportar la tabla supplier contenida en el archivo script.sql
4. La conexión a BBDD está en el archivo src\main\resources\application.yml y tiene configurado por defecto como usuario y contraseña la palabra root
5. Ejecutar el programa TestibmApplication
6. Abrir un navegador e ingresar en http://localhost:8080/