package com.tecno.tecno.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credito")
public class Credito {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id_credito;

  private double limite;

  public Credito() {
  }

  public Credito(double limite) {
    this.limite = limite;
  }

  public Credito(int id_credito, double limite) {
    this.id_credito = id_credito;
    this.limite = limite;
  }

}
