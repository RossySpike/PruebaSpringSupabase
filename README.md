# PRUEBA DE SPRING CON SUPABASE

La directorio demo contiene el codigo java, mientras que el directorio pagina-prueba contiene un archivo index.html con el que se puede interactuar con los endpoint. Es un mini ejemplo de como podemos tratar el backend para el proyecto de IS.

## Importante

**Recomiendo leer todos los archivos `.md`**

Use:

- maven.
- java 21.

El codigo esta ahi mas o menos trate de usar el `Modelo Vista Controlador` en el proyecto de java sin embargo al ser muy breve la vista quedo de por fuera (o al menos no vi una forma de integrar una vista explicita, en menos palabras: skill issue.)

Recomiendo ejecutar primero el server luego abrir la pagina porque si usan el plugin de live-preview o cualquier cosa que inicie una comunicacion a traves de localhost puede generar problemas porque el server siempre va a querer agarrar localhost:8080

Recomiendo investigar el WebClient de spring, es una forma mas moderna de hacer requests http en java, y si vamos a usar supabase pues es a traves de el que haremos las consultas.

### Como ejecutar

```bash
mvn spring-boot:run
```
