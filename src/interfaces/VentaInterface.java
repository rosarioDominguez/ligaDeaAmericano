/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmfa.src.interfaces;

import java.util.Date;



public interface VentaInterface {
	
	public void buscarProducto(String Categoria,String Equipo );
	public void buscarProducto(String argumentoDeBusqueda, boolean equipo);
	public void registrarVenta(String empleado, String tienda, float importe);
	public void registrarVentaDeEmpleado(String idVenta,String curpEmpleado,float importe);
	public void registrarCarroDeCompra(String[] carroDecompras,String idVenta);

}
