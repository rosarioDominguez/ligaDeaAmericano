/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmfa.src.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import lmfa.src.modelo.Persona;

public class PersonaDAO{
	
	private LinkedList<Persona> personas;
	private Persona unaPersona;
	private String query;
	
	public PersonaDAO() {
		
		
		unaPersona = new Persona();
		query = "";
		
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
	
	public void insertarPersona(String curp,String nombre,String apellidoPaterno,String apellidoMaterno, Date fechaDeNacimiento, int edad){
		
		Date sqlDate = new java.sql.Date(fechaDeNacimiento.getYear()-1900,fechaDeNacimiento.getMonth()-1,fechaDeNacimiento.getDate());

		query = "INSERT INTO persona (CURP, Nombre, Apellido_Paterno, Apellido_Materno, Edad, Fecha_nacimiento) VALUES ('"+curp+"', '"+nombre+"','"+apellidoPaterno+"', '"+apellidoMaterno+"', '"+edad+"', '"+sqlDate+"')";
		
		try {
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			aStmnt.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "SREGISTRO AGREGADO");
			cerrarConexion(null,aStmnt, conn);
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
	}
	
	public void actualizarPersona(String curp,String nombre,String apellidoPaterno,String apellidoMaterno, Date fechaDeNacimiento, int edad){
		
		Date sqlDate = new java.sql.Date(fechaDeNacimiento.getYear()-1900,fechaDeNacimiento.getMonth()-1,fechaDeNacimiento.getDate());
		
		query = "UPDATE persona SET Nombre ='"+nombre+"', Apellido_Paterno ='"+apellidoPaterno+"', Apellido_Materno='"+apellidoMaterno+"', Edad='"+edad+"', Fecha_nacimiento='"+sqlDate+"' WHERE CURP='"+curp+"'";
		try{
			Connection conn = crearConexion();
			Statement aStatement = conn.createStatement();
			aStatement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");
			cerrarConexion(null,aStatement, conn);
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
	}
public void borrarPersona(String curp){
	
	query  = "DELETE FROM persona WHERE CURP='"+curp+"'";
	
	try{
		Connection conn = crearConexion();
		Statement aStatement = conn.createStatement();
		aStatement.executeUpdate(query);
		JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
		cerrarConexion(null,aStatement, conn);
		
		
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		
	}
	
}
	
	public LinkedList<Persona> getPersonas(){
		
		LinkedList<Persona> personas = new LinkedList<Persona>();
		
		crearConexion();
		query = "SELECT * FROM lmfa.persona;";
		try {
			
			Connection conn = crearConexion();
			Statement aStmnt = conn.createStatement();
			ResultSet myRs = aStmnt.executeQuery(query);
			
			while(myRs.next()){
				
				
				unaPersona = new Persona(myRs.getString("CURP"),myRs.getString("Nombre"),myRs.getString("Apellido_Paterno"),myRs.getString("Apellido_Materno"),myRs.getInt("Edad"),myRs.getDate("Fecha_nacimiento"));
				personas.add(unaPersona);
				
			}
			cerrarConexion(myRs, aStmnt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
		
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
	            System.out.println("CONEXXION CERRADA");
	        } catch (SQLException e) { e.printStackTrace();}
	    }
		
	}
	
	
}
