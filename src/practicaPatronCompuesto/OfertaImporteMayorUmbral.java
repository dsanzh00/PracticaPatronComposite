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

public class OfertaImporteMayorUmbral implements IOferta {
	// CLASE PARA OFERTAS APLICADAS A MAYOR UMBRAL

		private double descuento;
		private double umbral;
		
		public OfertaImporteMayorUmbral(double descuento, double umbral) {
			this.descuento = descuento;
			this.umbral = umbral;
		}

		public double calculaImporteTotal(Venta venta) {
			double importe = venta.getImporte();
			
			if(venta.getImporte() > this.umbral) {
				importe =venta.getImporte() - venta.getImporte()*(this.descuento/100);
			}
			
			return importe;
		}
}
