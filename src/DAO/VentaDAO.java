/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmfa.src.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
//import java.sql.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import lmfa.src.modelo.Persona;
import lmfa.src.modelo.Producto;

public class VentaDAO  {
	
	private String query,nombreEquipo,categoria;
	private Producto unProducto;
	
	public VentaDAO(){
		
		query = "";
		nombreEquipo = "";
		categoria = "";
		unProducto = new Producto();
	}
	
	public Connection crearConexion() {
		
		Connection myConn = null;
		try{
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "99-red-117-dreams");

		}
		catch (Exception exc) {
				exc.printStackTrace();
			}	
			return myConn;
		}
	
	public LinkedList<String> getCategorias(){
		
		LinkedList<String> categorias = new LinkedList<String> (); 
	
		query = "SELECT Categoria FROM categoria_producto";
		
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			while(myRs.next()){
				
				categoria = myRs.getString("Categoria");
				categorias.add(categoria);
			}
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}
	
	public LinkedList<String> getEquipos(){
		
		LinkedList<String> equipos = new LinkedList<String> (); 
		query = "SELECT Nombre_Equipo FROM equipo";
		
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			while(myRs.next()){
				
				nombreEquipo = myRs.getString("Nombre_Equipo");
				equipos.add(nombreEquipo);
				
			}
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipos;
	}
	public float getVentasAlPeriodo(String periodo,String empleado){
		
		float ventasDelPeriodo = 0;
		
		query = "SELECT Ventas FROM empleado_tiene_record_de_venta WHERE CURP = '"+empleado+"' AND Periodo = '"+periodo+"'";
		
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			while(myRs.next()){
				
				ventasDelPeriodo = myRs.getFloat("IngresosDelPeriodo");
				
			}
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventasDelPeriodo;
		
	}
	public float getIngresosAlPeriodo(String tienda, String periodo){
		
		float ingresosDelPeriodo = 0;
		
		query = "SELECT IngresosDelPeriodo FROM record_de_tienda WHERE Tienda = '"+tienda+"' AND Periodo = '"+periodo+"'";
		
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			while(myRs.next()){
				
				ingresosDelPeriodo = myRs.getFloat("IngresosDelPeriodo");
				
			}
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingresosDelPeriodo;
	}
	public void registrarCarroDeCompra(String tienda,String periodo){
		
	}
	
	
	public void actualizarRecordVendedor(String periodo, String empleado){
		
		float ventas = 0;
		
		ventas = getVentasAlPeriodo(periodo, empleado);
		query = "UPDATE empleado_tiene_record_de_venta SET IngresosDelPeriodo = "+ventas+" WHERE CURP = '"+empleado+"'AND Periodo = '"+periodo+"'";
		
		try{
			
			Connection conn = crearConexion();
			Statement aStatement = conn.createStatement();
			aStatement.executeUpdate(query);
			cerrarConexion(null,aStatement, conn);
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
		
		
	}
	public void actualizarRecordDeTienda(String tienda, String periodo){
		
		float ingresos = 0;
		ingresos += getIngresosAlPeriodo(tienda, periodo);
		query = "UPDATE tienda_tiene_record_de_venta SET IngresosDelPeriodo = "+ingresos+" WHERE Nombre_Tienda = '"+tienda+"'AND Periodo = '"+periodo+"'";
		
		try{
			
			Connection conn = crearConexion();
			Statement aStatement = conn.createStatement();
			aStatement.executeUpdate(query);
			cerrarConexion(null,aStatement, conn);
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
	}
	
	public LinkedList<Producto> buscarProductos(String categoria,String equipo){
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		
		query = "SELECT * FROM producto WHERE Categoria = '"+categoria+"' AND Equipo = '"+equipo+"'";
			
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			while(myRs.next()){
				
				unProducto = new Producto(myRs.getInt("ID_Producto"),myRs.getString("Categoria"),myRs.getString("Equipo"),myRs.getFloat("Precio"));
				productos.add(unProducto);
				
			}
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productos;
		
	}
	
	public void registrarVenta(String periodo, String empleado, float importe, String tienda){
		
		int numeroVenta = getNumeroVenta(periodo,tienda);
		query = "INSERT INTO `lmfa`.`venta` (Tienda, Periodo, Numero_DeVenta, Importe, Empleado) VALUES ('"+tienda+"', '"+periodo+"', '"+numeroVenta+"', '"+importe+"', '"+empleado+"');";
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			aStmnt.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "VENTA REGISTRADA");
			cerrarConexion(null, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int getNumeroVenta(String periodo,String tienda){
		
		int numero = 0;
		
		query = "SELECT COUNT(NUMERO_DeVenta)FROM lmfa.venta WHERE Tienda = '"+tienda+"' AND Periodo = '"+periodo+"'";
		
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			  while(myRs.next()){
				  numero = myRs.getInt(1)+1;
			    }
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numero;
		 
	}
	
	public LinkedList<Producto> buscarProductos(String argumento,boolean esEquipo){
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		
		if(esEquipo){
			
			query = "SELECT * FROM producto WHERE Equipo = '"+argumento+"'";
		}else if(!esEquipo){
			query = "SELECT * FROM producto WHERE Categoria = '"+argumento+"'";
		}
		
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			while(myRs.next()){
				
				unProducto = new Producto(myRs.getInt("ID_Producto"),myRs.getString("Categoria"),myRs.getString("Equipo"),myRs.getFloat("Precio"));
				productos.add(unProducto);
				
			}
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productos;
		
	}
	
	
	public void cerrarConexion(ResultSet rs, Statement st, Connection conn){
		
		if (rs != null) {
	        try {
	            rs.close();
	        } catch (SQLException e) {e.printStackTrace();}
	    }
	    if (st != null) {
	        try {
	            st.close();
	        } catch (SQLException e) { e.printStackTrace();}
	    }
	    if (conn != null) {
	        try {
	            conn.close();
	            
	        } catch (SQLException e) { e.printStackTrace();}
	    }
		
	}
}
