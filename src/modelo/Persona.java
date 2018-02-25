/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmfa.src.modelo;

import java.util.Date;

public class Persona {
	private String curp,nombre,apellidoPaterno,apellidoMaterno;
	private int edad;
	private Date fechaDeNacimiento;
	
	public Persona(){
		curp="";
		nombre="";
		apellidoPaterno="";
		apellidoMaterno="";
		
	}
	
	public Persona(String curp,String nombre,String apellidoPaterno,String apellidoMaterno,int edad,Date fechaDeNacimiento ){
		
		this.curp= curp;
		this.nombre=nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno=apellidoPaterno;
		this.edad = edad;
		this.fechaDeNacimiento = fechaDeNacimiento;
		
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public String getCurp() {
		return curp;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public int getEdad() {
		return edad;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}