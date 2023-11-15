package br.com.ebi.novo.api;

import br.com.ebi.novo.api.io.Base64ProtocolResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "br.com.ebi.novo.api.repository")
@EntityScan(basePackages = "br.com.ebi.novo.api.entity")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new Base64ProtocolResolver());
        app.run(args);
    }

}
