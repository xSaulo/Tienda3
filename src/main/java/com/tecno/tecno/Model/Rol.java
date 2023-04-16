package com.tecno.tecno.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_rol;

    @NotEmpty
    private String nombre;

}
