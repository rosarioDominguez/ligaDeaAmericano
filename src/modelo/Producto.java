/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmfa.src.modelo;

public class Producto {
	private int idProducto;
	private String categoria,equipo;
	private float precio;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int idProducto,String categoria,String equipo,float precio ) {
		
		this.idProducto=idProducto;
		this.categoria=categoria;
		this.equipo=equipo;
		this.precio=precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getEquipo() {
		return equipo;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
