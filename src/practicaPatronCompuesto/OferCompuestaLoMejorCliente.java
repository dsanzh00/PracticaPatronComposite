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

public class OferCompuestaLoMejorCliente extends OfertaCompuesta {

	public OferCompuestaLoMejorCliente() {
		
	}
	
	
	public double calculaImporteTotal(Venta venta) {
		double importe = Integer.MAX_VALUE;
		
		for (int i=0; i<items.size(); i++){

			double total = items.get(i).calculaImporteTotal(venta); 
			importe =  Math.min(total, importe);
		
		}
		
		return importe;
	}

}
