/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmfa.src.modelo;

import java.util.Date;

public class Venta {
	private int idVenta,tienda;
	private Date fechaVenta;
	private float importe;
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}
	
	public Venta(int idVenta, int tienda, Date fechaVenta,float importe) {
		this.idVenta=idVenta;
		this.tienda=tienda;
		this.fechaVenta=fechaVenta;
		this.importe=importe;
		
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public float getImporte() {
		return importe;
	}
	public int getTienda() {
		return tienda;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public void setTienda(int tienda) {
		this.tienda = tienda;
	}
}
