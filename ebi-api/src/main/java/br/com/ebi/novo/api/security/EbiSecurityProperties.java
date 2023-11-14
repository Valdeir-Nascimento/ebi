package br.com.ebi.novo.api.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Validated
@Component
@ConfigurationProperties("ebi.oauth")
public class EbiSecurityProperties {

    @NotBlank
    private String providerUrl;

}
