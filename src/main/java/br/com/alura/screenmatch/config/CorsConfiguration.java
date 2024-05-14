package br.com.alura.screenmatch.config;

//definições de parametros para a API trabalhar

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

//implementar o WebMvcConfigurer para dizer que é utilziado padrão MVC
//informando através do método addCorsMappings como a comunicação
//deve acontecer e quais operações são permitidas
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5501/")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }


}
