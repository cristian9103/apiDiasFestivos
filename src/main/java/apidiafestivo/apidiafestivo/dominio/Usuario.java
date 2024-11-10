package apidiafestivo.apidiafestivo.dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_usuario")
    @GenericGenerator(name = "secuencia_usuario", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "usuario", length = 100, unique = true)
    private String usuario;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "clave")
    private String clave;

    @Column(name = "roles")
    private String roles;

}
