package ross.spike.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Map;
import ross.spike.demo.services.SupabaseService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PatchMapping;

@CrossOrigin(origins = "*") // Necesario para evitar problemas de CORS.
@RestController // Necesario para que Spring reconozca esta clase como un controlador
                // REST. Ademas de que permite devolver directamente objetos que se serializan a
                // JSON y se pueden usar los decoradores `Metodo`Mapping('uri').
public class SupabaseController {
  SupabaseService supabaseService;

  public SupabaseController(SupabaseService supabaseService) {
    this.supabaseService = supabaseService;
  }

  @GetMapping("/getMovies") // es un decorador que indica que este metodo maneja solicitudes HTTP GET a la
                            // URI /getMovies.
  public Mono<String> getMovies(@RequestParam(required = false) String id,
      @RequestParam(required = false) String select) {
    return this.supabaseService.getMovies(id, select);
  }

  // curl -X POST http://localhost:8080/addMovie -H "Content-Type:
  // application/json" -d '{"name":"Gayrard gay"}'

  @PostMapping("/addMovie") // es un decorador que indica que este metodo maneja solicitudes HTTP POST a la
                            // URI /addMovie.
  public Mono<String> addMovie(@RequestBody(required = true) Map<String, Object> data) {
    return this.supabaseService.addMovie(data);
  }
  // honey@archlinux-laptop demo]$ curl -X -PUT
  // http://localhost:8080/updateMovie?id=1 -H "Content-Type: application/json" -d
  // '{"name"="jose"}'
  // {"timestamp":"2025-09-27T00:38:08.867+00:00","status":405,"error":"Method Not
  // Allowed","path":"/updateMovie"}[honey@archlinux-laptop demo]$

  @PatchMapping("/updateMovie") // es un decorador que indica que este metodo maneja solicitudes HTTP PUT a la
                                // URI /updateMovie.
  public Mono<String> updateMovie(@RequestParam(required = true) String id,
      @RequestBody(required = true) Map<String, Object> data) {
    return this.supabaseService.updateMovie(id, data);
  }
  // @RequestParam indica que el parametro id se obtiene de la cadena de consulta
  // @RequestBody indica que el parametro data se obtiene del cuerpo de la
  // solicitud
  // Nota: aunque tenga required=true si se envia un json vacion -> {} lo toma
  // como valido, para que no lo tome hay que programar ese control en el servicio
}
