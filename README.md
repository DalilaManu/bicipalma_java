# Bicipalma
Proyecto en Java (Maven)

## Descripción del proyecto
**BiciPalma** es una aplicación desarrollada en Java cuyo objetivo es simular el funcionamiento básico de un sistema de préstamo de bicicletas públicas.  
El proyecto permite gestionar:

- Estaciones de bicicletas  
- Bicicletas y su estado  
- Tarjetas de usuario  
- Operaciones de anclaje y retirada  
- Consultas del estado de la estación  

---

## Estructura del proyecto

El proyecto sigue una arquitectura por paquetes dentro del directorio `src/main/java`:

``
edu.teamrocket.bicipalma
 ├── appalma
 │     └── BiciPalma.java        Clase principal (main)
 └── domain
       ├── bicicleta
       │      └── Bicicleta.java
       ├── estacion
       │      └── Estacion.java
       └── tarjetausuario
              └── TarjetaUsuario.java
```

Además, incluye un directorio `src/test/java` con pruebas unitarias:

```
edu.teamrocket.bicipalma
 └── domain
       ├── BicicletaTest.java
       └── EstacionTest.java
```

---

## Ejecución de tests

Desde terminal:

```
mvn test
```

---

##  Autoría

Proyecto desarrollado por **Dalila y Yolanda** como parte de una práctica académica para aprender Java, Maven y principios de diseño orientado a objetos.
