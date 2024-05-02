package tech.grypsiarze;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://grypsiarze.tech", "https://localhost:3000") // Dodaj adres URL Twojej aplikacji React
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Dodaj dozwolone metody HTTP
                .allowedHeaders("*"); // Dodaj dozwolone nagłówki (możesz również wymienić je ręcznie)
    }
}