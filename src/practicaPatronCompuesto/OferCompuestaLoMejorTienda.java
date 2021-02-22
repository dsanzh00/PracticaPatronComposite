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

public class OferCompuestaLoMejorTienda extends OfertaCompuesta{

	public OferCompuestaLoMejorTienda() {
		
	}
	
	
	public double calculaImporteTotal(Venta venta) {
		double importe = Integer.MIN_VALUE;
		
		for (int i=0; i<items.size(); i++){

			double total = items.get(i).calculaImporteTotal(venta); 
			importe =  Math.max(total, importe);
			
		}
		
		return importe;
	}
}
