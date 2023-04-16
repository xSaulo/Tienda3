package com.tecno.tecno.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class Articulo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id_articulo;

  private String descripcion;
  private String detalle;
  private double precio;
  private int existencias;
  private String imagen;
  private boolean activo;

  @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
  @ManyToOne
  private Categoria categoria;

  public Articulo() {
  }

  public Articulo(String descripcion, String detalle, double precio, int existencias, String imagen, boolean activo,
      Categoria categoria) {
    this.descripcion = descripcion;
    this.detalle = detalle;
    this.precio = precio;
    this.existencias = existencias;
    this.imagen = imagen;
    this.activo = activo;
    this.categoria = categoria;
  }

  public Articulo(int id_articulo, String descripcion, String detalle, double precio, int existencias, String imagen,
      boolean activo, Categoria categoria) {
    this.id_articulo = id_articulo;
    this.descripcion = descripcion;
    this.detalle = detalle;
    this.precio = precio;
    this.existencias = existencias;
    this.imagen = imagen;
    this.activo = activo;
    this.categoria = categoria;
  }

}
