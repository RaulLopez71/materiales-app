package com.example.materiales_app;

import com.example.materiales_app.entity.Material;
import com.example.materiales_app.repo.MaterialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner seed(MaterialRepository repo){

        return args -> {
            if(repo.count() == 0){
                Material m = new Material();
                m.setNombre("Placa de yeso de 1/2\"");
                m.setUnidad("pza");
                m.setPrecio(new BigDecimal("45.50"));
                repo.save(m);

            }
            System.out.println("Materiales en BD: " + repo.count());
        };

    }
}
