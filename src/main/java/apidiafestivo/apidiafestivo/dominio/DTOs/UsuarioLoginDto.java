package apidiafestivo.apidiafestivo.dominio.DTOs;

import apidiafestivo.apidiafestivo.dominio.Usuario;

public class UsuarioLoginDto {
    private Usuario usuario;
    private String token;

    public UsuarioLoginDto(Usuario usuario){
        this.usuario = usuario;
        this.token = "";
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public String getToke(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
