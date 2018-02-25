package lmfa.src.interfaces;

import java.sql.Date;

public interface PersonaInterface {
	/*
	public void recibeCURP(String curp);
	public void recibeNombre(String nombre);
	public void recibeApellidoPaterno(String apellidoPaterno);
	public void recibeApellidoMaterno(String apellidoMaterno);
	public void recibeFechaNacimiento(Date fechaDeNacimiento);
	public void recibeEdad(int edad);
	*/
	public void insertarPersona(String curp, String nombre, String apellidoPaterno,String apellidoMaterno,Date fechaDeNacimiento, int edad);
	
	public void actualizarPersona(String curp, String nombre, String apellidoPaterno,String apellidoMaterno,Date fechaDeNacimiento, int edad);
	public void borrarPersona(String curp); 
	
	
	
	
}