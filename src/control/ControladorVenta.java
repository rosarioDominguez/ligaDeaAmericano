package lmfa.src.control;

import java.lang.reflect.GenericArrayType;
import java.util.Calendar;
import java.util.Date;
import lmfa.src.DAO.VentaDAO;
import lmfa.src.interfaces.VentaInterface;
import lmfa.src.modelo.Venta;


import lmfa.src.vista.PanelVenta;

public class ControladorVenta implements VentaInterface{
	
	private Venta unaVenta;
	private VentaDAO ventaDAO;
	private PanelVenta panelVenta;
	
	
	public ControladorVenta() {
		
		unaVenta = new Venta();
		ventaDAO = new VentaDAO();
		panelVenta = new PanelVenta(this,"JUAN", "VIPJ960925HDFLNN06", "BOSTON", "B-01",ventaDAO.getEquipos(),ventaDAO.getCategorias());
		
	}
	
	public PanelVenta getPanelVenta(){
		
		return panelVenta;
	}
	
	
	@Override
	public void buscarProducto(String categoria, String equipo) {
	
		panelVenta.updateTablaBusquedaProductos(ventaDAO.buscarProductos(categoria, equipo));
		
	}
	@Override
	public void buscarProducto(String argumentoDeBusqueda, boolean esEquipo) {
		panelVenta.updateTablaBusquedaProductos(ventaDAO.buscarProductos(argumentoDeBusqueda, esEquipo));
		
	}
	@Override
	public void registrarVenta(String empleado, String tienda, float importe) {
		StringBuilder periodo = new StringBuilder();
		Date fecha = new Date();
		periodo.append(fecha.getYear()+1900).append("-").append(fecha.getMonth()+1);
		ventaDAO.registrarVenta(periodo.toString(), empleado, importe, tienda);
		
	}
	@Override
	public void registrarVentaDeEmpleado(String idVenta, String curpEmpleado, float importe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarCarroDeCompra(String[] carroDecompras, String idVenta) {
		// TODO Auto-generated method stub
		
	}

	

}
