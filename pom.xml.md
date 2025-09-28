# POM (Project Object Model)

## Que es?

Archivo de configuracion para proyectos Maven, vive en la raiz del proyecto. Define dependencias, plugins, y configuraciones del proyecto.

## Estructura

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" ...>
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.johnny</groupId>
  <artifactId>spring-mvc-demo</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <properties>
    <java.version>17</java.version>
  </properties>

  <dependencies>
    <!-- Aquí van tus librerías -->
  </dependencies>

  <build>
    <plugins>
      <!-- Aquí van tus plugins de compilación -->
    </plugins>
  </build>
</project>
```

### Dependencias

Se definen con 3 etiquetas:

```xml
<dependency> <!-- Etiqueta necesaria para cada dependencia -->
  <groupId>org.springframework</groupId> <!-- Grupo o organizacion que mantiene la libreria -->
  <artifactId>spring-core</artifactId> <!-- Nombre de la libreria -->
  <version>5.3.20</version> <!-- Version de la libreria -->
</dependency>
```

### Plugins

Los plugins controlan cómo se compila, empaqueta y ejecuta tu proyecto

```xml
<plugin> <!-- Define a Maven plugin -->
  <groupId>org.apache.maven.plugins</groupId> <!-- Grupo al que pertenece el plugin -->
  <artifactId>maven-compiler-plugin</artifactId> <!-- Nombre del plugin -->
  <version>3.8.1</version> <!-- Versión específica del plugin -->
  <configuration> <!-- Configuración personalizada para el plugin -->
    <source>${java.version}</source> <!-- Versión de Java usada para compilar el código fuente -->
    <target>${java.version}</target> <!-- Versión de Java para la generación de bytecode -->
  </configuration>
```

## Algunas etiquetas comunes

- `<modelVersion>`: Versión del modelo POM. Siempre es `4.0.0`.
- `<groupId>`: Identificador único del proyecto.
- `<artifactId>`: Nombre del artefacto generado.
- `<version>`: Versión del proyecto (ej. `1.0-SNAPSHOT`).
- `<packaging>`: Tipo de empaquetado (`jar`, `war`, etc.).
- `<name>`: Nombre legible del proyecto.
- `<url>`: URL del sitio del proyecto (opcional).
- `<properties>`: Variables reutilizables dentro del POM.
- `<dependencies>`: Lista de librerías externas necesarias.
- `<build>`: Configuración de compilación y plugins.

- `<parent>`: Herencia de otro POM (útil en proyectos multi-módulo).
- `<dependencyManagement>`: Define versiones centralizadas para dependencias compartidas.
- `<modules>`: Lista de subproyectos si usas estructura multi-módulo.
- `<repositories>`: Repositorios adicionales donde buscar dependencias.
- `<pluginRepositories>`: Repositorios para plugins de Maven.
- `<profiles>`: Configuraciones alternativas para distintos entornos (dev, prod, test).
- `<developers>`: Información sobre los autores del proyecto.
- `<scm>`: Datos del sistema de control de versiones (ej. Git).
- `<project>`: Raíz del archivo. Todo el `pom.xml` vive dentro de esta etiqueta.
