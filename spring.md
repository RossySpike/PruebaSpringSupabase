# 🧰 Campos de Spring Initializr

Estos campos definen la identidad técnica y estructural de tu proyecto Spring Boot. Son clave para la organización del código, la generación del artefacto y la interoperabilidad con herramientas como Maven, Gradle y tu IDE.

---

## 📦 Group

- **¿Qué es?**  
  Identificador organizacional del proyecto. Equivale al `groupId` en Maven o al `group` en Gradle.

- **Ejemplo:**  
  `com.johnny.kiosko`

- **Importancia:**
  - Define el namespace raíz del proyecto.
  - Se usa como parte del nombre del paquete (`com.johnny.kiosko.Logica`).
  - Ayuda a evitar conflictos entre proyectos.
  - Convención: usar dominio invertido (`com.google`, `org.springframework`, etc.).

---

## 🧱 Artifact

- **¿Qué es?**  
  Nombre del artefacto generado (archivo `.jar` o `.war`). Equivale al `artifactId` en Maven.

- **Ejemplo:**  
  `kiosko-builder`

- **Importancia:**
  - Define el nombre del archivo compilado (`kiosko-builder.jar`).
  - Identifica el módulo en repositorios Maven.
  - Útil para distinguir microservicios o subproyectos.

---

## 🏷️ Name

- **¿Qué es?**  
  Nombre legible del proyecto. Usado en metadatos y configuraciones internas.

- **Ejemplo:**  
  `KioskoBuilder`

- **Importancia:**
  - Aparece en el `manifest` del `.jar`.
  - Puede mostrarse en logs, dashboards, o herramientas de monitoreo.
  - No afecta directamente al código fuente.

---

## 📝 Description

- **¿Qué es?**  
  Breve resumen del propósito del proyecto.

- **Ejemplo:**  
  `"Sistema de gestión de kioskos universitarios"`

- **Importancia:**
  - Se incluye en el `pom.xml` o `build.gradle`.
  - Útil para documentación, CI/CD, y colaboración.
  - Ayuda a comunicar la intención del proyecto a otros desarrolladores.

---

## 🧪 Package name

- **¿Qué es?**  
  Nombre base del paquete Java donde se colocará la clase principal (`Application.java`) y el resto del código.

- **Ejemplo:**  
  `com.johnny.kiosko`

- **Importancia:**
  - Define la estructura del código fuente (`src/main/java/com/johnny/kiosko/...`).
  - Evita conflictos de clases entre bibliotecas.
  - Clave para mantener una arquitectura limpia y modular.

---

## 🔗 Relación entre campos

| Campo          | Relación con otros                                      |
| -------------- | ------------------------------------------------------- |
| `Group`        | Se usa como parte del `Package name` y del `groupId`    |
| `Artifact`     | Define el nombre del `.jar` y del `artifactId`          |
| `Name`         | Puede coincidir con `Artifact`, pero es más descriptivo |
| `Description`  | Solo metadatos, no afecta el código                     |
| `Package name` | Derivado de `Group`, pero puede personalizarse          |

---

# Comandos

- Ejectuar: mvn spring-boot:run
