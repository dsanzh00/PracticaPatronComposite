/**
 * 				PRACTICA PATRON COMPUESTO
 * 				Ingenieria del Software
 * 
 * @author Sanz Herrero, Daniel
 * @author Valencia Michelena, Blanca
 * 
 * 
 */


package practicaPatronCompuesto;

public class Venta {

	public Cliente cliente;
	private double importe;
	private IOferta ofertaAplicar;
	
	public Venta(Cliente cliente, double importe) {
		this.cliente = cliente;
		this.importe = importe;
	}
	
	public IOferta getOfertaAplicar() {
		return this.ofertaAplicar;
	}
	
	public void setOfertaAplicar(IOferta oferta) {
		this.ofertaAplicar = oferta;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getImporte() {
		return this.importe;
	}
	
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public double calculaImporteFinal() {
	
		return ofertaAplicar.calculaImporteTotal(this);
		
	}

}
