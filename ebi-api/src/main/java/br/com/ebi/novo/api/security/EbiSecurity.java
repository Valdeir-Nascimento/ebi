package br.com.ebi.novo.api.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class EbiSecurity {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean isAutenticado() {
        return getAuthentication().isAuthenticated();
    }

    public Integer getUsuarioId() {
        Jwt jwt = (Jwt) getAuthentication().getPrincipal();
        return jwt.getClaim("usuario_id");
    }

    public boolean hasAuthority(String authorityName) {
        return getAuthentication().getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(authorityName));
    }

    public boolean temEscopoEscrita() {
        return hasAuthority("SCOPE_WRITE");
    }

    public boolean temEscopoLeitura() {
        return hasAuthority("SCOPE_READ");
    }

    public boolean podeConsultarTipoAtvidade() {
        return temEscopoLeitura() && isAutenticado();
    }

    public boolean podeGerenciarCadastroTipoAtvidade() {
        return temEscopoEscrita() && hasAuthority("EDITAR_TIPO_ATVIDADE");
    }


}
