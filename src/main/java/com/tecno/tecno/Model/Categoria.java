package com.tecno.tecno.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_categoria;

  private String descripcion;
  private boolean activo;

  public Categoria() {
  }

  public Categoria(boolean activo, String descripcion) {
    this.activo = activo;
    this.descripcion = descripcion;
  }

  public Categoria(int id_categoria, boolean activo, String descripcion) {
    this.id_categoria = id_categoria;
    this.activo = activo;
    this.descripcion = descripcion;
  }

}
