package ross.spike.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.Map;

@Service
public class SupabaseService {
  private final WebClient client;

  // @Value inyecta el valor de la propiedad supabase.url y de la propiedad
  // supabase.api-key que fueron declaradas en el archivo `application.properties`
  public SupabaseService(@Value("${supabase.url}") String baseUrl,
      @Value("${supabase.api-key}") String apiKey) {
    try {

      // Inicializa el cliente WebClient desde la url de supabase y envia la api key
      // para que permita la conexion
      client = WebClient.builder().baseUrl(baseUrl).defaultHeader("apikey", apiKey)
          .defaultHeader("Authorization", "Bearer " + apiKey).build();
    } catch (Exception e) {
      throw new RuntimeException("Error initializing SupabaseService: " + e.getMessage(), e);
    }
  }

  public Mono<String> getMovies(String id, String select) {
    StringBuilder uriBuilder = new StringBuilder("/movie");

    // Los controles de flujo son para revisar si se enviaron los parametros, de
    // hacerlo imita lo que seria un select 'fila' en sql
    boolean hasQuery = false;
    if (select != null && !select.isBlank()) {
      uriBuilder.append("?select=").append(select);
      hasQuery = true;
    }

    if (id != null && !id.isBlank()) {
      uriBuilder.append(hasQuery ? "&" : "?");
      uriBuilder.append("id=eq.").append(id);
    }
    return client.get()
        .uri(uriBuilder.toString())
        .retrieve().onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals,
            response -> response.bodyToMono(String.class).map(Exception::new))
        .bodyToMono(String.class)
        .doOnError(error -> {
          System.err.println("Error al llamar a Supabase: " + error.getMessage());
        });

  }

  public Mono<String> addMovie(Map<String, Object> data) {
    return client.post()
        .uri("/movie")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(data)
        .retrieve().onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals,
            response -> response.bodyToMono(String.class).map(Exception::new))
        .bodyToMono(String.class)
        .doOnError(error -> {
          System.err.println("Error al llamar a Supabase: " + error.getMessage());
        });

  }

  public Mono<String> updateMovie(String id, Map<String, Object> data) {
    if (data == null || data.isEmpty()) {
      return Mono.error(new IllegalArgumentException("Request body must contain at least one field to update"));
    }
    return client.patch().uri("/movie?id=eq." + id).contentType(MediaType.APPLICATION_JSON).bodyValue(data).retrieve()
        .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals,
            response -> response.bodyToMono(String.class).map(Exception::new))
        .bodyToMono(String.class)
        .doOnError(error -> {
          System.err.println("Error al llamar a Supabase: " + error.getMessage());
        });

  }
}
