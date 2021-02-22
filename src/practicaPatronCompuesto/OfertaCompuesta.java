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

import java.util.ArrayList;

public abstract class OfertaCompuesta implements IOferta {
	
	protected ArrayList<IOferta> items = new ArrayList<IOferta>();
	
	public OfertaCompuesta() {
		
	}

	public void addOferta(IOferta oferta) {
		items.add(oferta);
	}
	
	public ArrayList<IOferta> getItems(){
		return items;
	}
	
	public void setItems(ArrayList<IOferta> items) {
		this.items = items;
	}

}
