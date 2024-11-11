package apidiafestivo.apidiafestivo.aplicacion.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfiguracionSeguridad {

    @Autowired
    private FiltroSeguridad filtro;

    @Bean
    public UserDetailsService servicioUsuarios(){
        return new UsuarioDetallesServicio();
    }

    // Configuración seguridad Http
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
        return https.csrf(csrf -> csrf.disable()) // Deshabilita la protección CSRF
        .authorizeHttpRequests(authz -> authz
                                    .requestMatchers("/api/usuarios/login/**").permitAll()
                                    .anyRequest().authenticated()
                                    ) //endpints sin token
        .addFilterAfter(filtro, UsernamePasswordAuthenticationFilter.class)
        .build();
    }
}
