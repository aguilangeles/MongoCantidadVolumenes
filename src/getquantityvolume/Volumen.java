/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getquantityvolume;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Volumen {

  public Volumen(String nombre, int cantidad) {
    this.nombre = nombre;
    this.cantidad = cantidad;
  }
  private String nombre;
  private int cantidad;

  @Override
  public String toString() {
    return  nombre + "\t" + cantidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  
}

