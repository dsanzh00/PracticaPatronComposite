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

public class OfertaEdadMenor implements IOferta{
	// CLASE PARA OFERTAS APLICADAS A MENORES DE EDAD (<18 AÑOS)

	private double descuento;
	
	public OfertaEdadMenor(double descuento) {
	
		this.descuento=descuento;
	}

	public double calculaImporteTotal(Venta venta) {
		
		double importe = venta.getImporte();
		
		if(venta.cliente.getEdad() < 18) {
			importe = venta.getImporte() - venta.getImporte()*(this.descuento/100);
		}
		
		return importe;
	
	}
	

}
