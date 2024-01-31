package com.UD4.angular.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Esta clase proporciona configuración para el manejo de CORS en la aplicación web.
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // Método para configurar las opciones de CORS.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Se permite el acceso desde cualquier origen para todos los endpoints de la aplicación.
        registry.addMapping("/**")
                // Se especifica el origen permitido (en este caso, http://localhost:4200).
                .allowedOrigins("http://localhost:4200")
                // Se definen los métodos HTTP permitidos para las solicitudes CORS (GET, POST, DELETE).
                .allowedMethods("GET", "POST", "DELETE");
    }
}
