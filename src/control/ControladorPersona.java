package lmfa.src.control;

import java.sql.Date;

import lmfa.src.interfaces.PersonaInterface;
import lmfa.src.modelo.Persona;

import lmfa.src.DAO.PersonaDAO;
import lmfa.src.vista.PanelPersona;

public class ControladorPersona implements PersonaInterface {

	private PanelPersona miPanelPersona;
	private PersonaDAO pDAO;
	private java.sql.Date fechaSQL;
	//private ConsultorBD consultor;
	//private InsertorBD insertor;
	private Persona unaPersona;
	
	public ControladorPersona(){
		
		miPanelPersona = new PanelPersona(this);
		pDAO = new PersonaDAO();
		
		unaPersona = new Persona();
		miPanelPersona.updateTabla(pDAO.getPersonas());
		
	}
	
	public PanelPersona getPanelPersona() {
		return miPanelPersona;
	}
	/*
	@Override
	public void recibeCURP(String curp) {
		
		unaPersona.setCurp(curp);
	}

	@Override
	public void recibeNombre(String nombre) {
		unaPersona.setNombre(nombre);
		
	}

	@Override
	public void recibeApellidoPaterno(String apellidoPaterno) {
		unaPersona.setApellidoPaterno(apellidoPaterno);
		
	}

	@Override
	public void recibeApellidoMaterno(String apellidoMaterno) {

		unaPersona.setApellidoMaterno(apellidoMaterno);
	}

	@Override
	public void recibeFechaNacimiento(Date fechaDeNacimiento) {
		unaPersona.setFechaDeNacimiento(fechaDeNacimiento);
		
	}

	@Override
	public void recibeEdad(int edad) {
		unaPersona.setEdad(edad);
		
	}*/

	@Override
	public void insertarPersona(String curp, String nombre, String apellidoPaterno, String apellidoMaterno,
			Date fechaDeNacimiento, int edad) {
		//fechaSQL = new java.sql.Date(fechaDeNacimiento.getTime()); 
		pDAO.insertarPersona(curp, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, edad);
		miPanelPersona.updateTabla(pDAO.getPersonas());
		
	}
	@Override
	public void actualizarPersona(String curp, String nombre, String apellidoPaterno, String apellidoMaterno,
			Date fechaDeNacimiento, int edad) {
		
		//fechaSQL = new java.sql.Date(fechaDeNacimiento.getTime()); 
		pDAO.actualizarPersona(curp, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, edad);
		miPanelPersona.updateTabla(pDAO.getPersonas());
			
		
	}
	@Override
	public void borrarPersona(String curp) {
		pDAO.borrarPersona(curp);
		miPanelPersona.updateTabla(pDAO.getPersonas());
		
	}



}
