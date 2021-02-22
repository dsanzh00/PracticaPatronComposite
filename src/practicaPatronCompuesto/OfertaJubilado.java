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

public class OfertaJubilado implements IOferta{
	// CLASE PARA OFERTAS APLICADAS A JUBILADOS (>65 ANIOS)

		private double descuento;
		public OfertaJubilado(double descuento) {
		
			this.descuento=descuento;
		}

		public double calculaImporteTotal(Venta venta) {
			double importe = venta.getImporte();
			
			if(venta.cliente.getEdad() > 65) {
				importe = venta.getImporte() - venta.getImporte()*(this.descuento/100);
			}
			
			return importe;
			
		}
}
