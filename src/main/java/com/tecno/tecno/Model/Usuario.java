package com.tecno.tecno.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_usuario;

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private Rol[] rol;

}
