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

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PruebasPatronCompositeTest {

	
	Cliente cliAna;
	Cliente cliJuan;
	Cliente cliPedro;
	
@Before
public void prepara(){
	cliAna=new Cliente("Ana",15);
	cliJuan=new Cliente("Juan",50);
	cliPedro=new Cliente("Pedro",70);
}


@Test
public void testOfertaEdadMenorSiAplica() {
	// test con una sola oferta: 15% a menores de 18 años (Se aplica la oferta)
	System.out.println("1. Caso de prueba SIMPLE: aplica descuento por ser menor de edad");
	
	Venta venta=new Venta(cliAna,100);
	IOferta oferSimple=new OfertaEdadMenor(15); // crea una oferta para menores de 18 años del 15%
	// asigna la oferta a la venta
	venta.setOfertaAplicar(oferSimple);
	// comprueba que el importe de la venta es 85, es decir, aplica el descuento porque Ana tiene 15 años
	Assert.assertEquals(venta.calculaImporteFinal(),85.0,0.0);
}


@Test
public void testOfertaEdadMenorNoAplica() {
	// test con una sola oferta: 15% a menores de 18 años (Se aplica la oferta)
    System.out.println("2. Caso de prueba SIMPLE: NO aplica descuento por ser menor de edad");
	Venta venta=new Venta(cliPedro,100);
	IOferta oferSimple=new OfertaEdadMenor(15); // crea una oferta para menores de 18 años del 15%
	venta.setOfertaAplicar(oferSimple);
	
	// comprueba que el importe de la venta es 100, es decir, no aplica el descuento porque Pedro tiene 70 años
	Assert.assertEquals(venta.calculaImporteFinal(),100.0,0.0);
}

@Test
public void testOfertaJubiladoAplica() {
		// test con una sola oferta: 50% a jubilados (Se aplica la oferta)
	System.out.println("3. Caso de prueba SIMPLE: Aplica descuento por ser jubilado ");
	Venta venta=new Venta(cliPedro,100);
	IOferta oferSimple=new OfertaJubilado(50); // crea una oferta para menores de 18 años del 15%
		// asigna la oferta a la venta
	venta.setOfertaAplicar(oferSimple);
		// comprueba que el importe de la venta es 85, es decir, aplica el descuento porque Ana tiene 15 años
	Assert.assertEquals(venta.calculaImporteFinal(),50.0,0.0);
	  
	  
}

	@Test
	public void testOfertaJubiladoNoAplica() {
		// test con una sola oferta: 50% a jubilados (No se aplica la oferta)
		System.out.println("4. Caso de prueba SIMPLE: NO aplica descuento por ser jubilado ");
		Venta venta=new Venta(cliAna,100);
		IOferta oferSimple=new OfertaJubilado(50); // crea una oferta para menores de 18 años del 15%
		// asigna la oferta a la venta
		venta.setOfertaAplicar(oferSimple);
		// comprueba que el importe de la venta es 85, es decir, aplica el descuento porque Ana tiene 15 años
		Assert.assertEquals(venta.calculaImporteFinal(),100.0,0.0);
		
	
	}
	
	
	@Test
	public void testOfertaUmbralAplica() {
		// test con una sola oferta: descuento de 25 € si el importe es mayor de 150€
		 System.out.println("5. Caso de prueba SIMPLE: Aplica descuento por umbral ");
		 Venta venta=new Venta(cliJuan,200);
			IOferta oferSimple=new OfertaImporteMayorUmbral(25, 150); // crea una oferta para menores de 18 años del 15%
			// asigna la oferta a la venta
			venta.setOfertaAplicar(oferSimple);
			// comprueba que el importe de la venta es 85, es decir, aplica el descuento porque Ana tiene 15 años
			Assert.assertEquals(venta.calculaImporteFinal(),150.0,0.0);
		 // TODO
			
	
	}

		@Test
		public void testOfertaUmbralNoAplica() {
			// test con una sola oferta: descuento de 25 € si el importe es mayor de 150€
			 System.out.println("6. Caso de prueba SIMPLE: NO aplica descuento por umbral ");
			 Venta venta=new Venta(cliJuan,100);
				IOferta oferSimple = new OfertaImporteMayorUmbral(25, 150); // crea una oferta para menores de 18 años del 15%
				// asigna la oferta a la venta
				venta.setOfertaAplicar(oferSimple);
				// comprueba que el importe de la venta es 85, es decir, aplica el descuento porque Ana tiene 15 años
				Assert.assertEquals(100.0,venta.calculaImporteFinal(),0.0);
			

		}
		
	@Test
	public void testOfertaCompuesta_MejorCliente_Jubilado_Umbral_aplicaAmbas() {
		// test con oferta COMPUESTA con dos ofertas aplicando LO MEJOR PARA EL CLIENTE ((se queda con el importe total más bajo)
		//    aplica descuento del 50% por jubilado y por umbral (si el importe es mayor o igual del 150€ descuenta 25€) 
		System.out.println("7. Caso de prueba COMPUESTO lo mejor para el cliente: aplica descuento por jubilado y por umbral:");
		Venta venta=new Venta(cliPedro,200);
		
		// Crea la oferta compuesta
		OferCompuestaLoMejorCliente oferC_LoMejorCliente= new OferCompuestaLoMejorCliente();
		
		// Crea las ofertas simples para luego añadirlas a la compuesta
		IOferta oferUmbral=new OfertaImporteMayorUmbral(25,150); // crea una oferta para descontar 25€ si importe >=150
		IOferta oferJubilado=new OfertaJubilado(50); // crea una oferta para jubilados del 50%
		
		//añade las ofertas simples a la compuesta
		oferC_LoMejorCliente.addOferta(oferJubilado);
		oferC_LoMejorCliente.addOferta(oferUmbral);
		
		// Asigna la oferta compuesta a la venta
		venta.setOfertaAplicar(oferC_LoMejorCliente);
		
		//Comprueba que el importe final de la venta aplicando la oferta compuesta es 100 (aplica la oferta por jubilado porque es lo favorece más al cliente)
		Assert.assertEquals(venta.calculaImporteFinal(),100.0,0.0);
	}
		
	@Test
	public void testOfertaCompuesta_MejorCliente_Jubilado_Umbral_aplicaAmbas2() {
		//  otro test similar al anterior para comprobar que aplica la oferta por umbral 
		// test con oferta COMPUESTA con dos ofertas aplicando LO MEJOR PARA EL CLIENTE ((se queda con el importe total más bajo)
				//    aplica descuento del 50% por jubilado y por umbral (si el importe es mayor o igual del 150€ descuenta 25€) 
				System.out.println("8. Caso de prueba COMPUESTO lo mejor para el cliente: aplica descuento por jubilado y por umbral:");
				Venta venta=new Venta(cliPedro,200);
				
				// Crea la oferta compuesta
				OferCompuestaLoMejorCliente oferC_LoMejorCliente= new OferCompuestaLoMejorCliente();
				
				// Crea las ofertas simples para luego añadirlas a la compuesta
				IOferta oferUmbral=new OfertaImporteMayorUmbral(25,150); // crea una oferta para descontar 25€ si importe >=150
				IOferta oferJubilado=new OfertaJubilado(10); // crea una oferta para jubilados del 10%
				
				//añade las ofertas simples a la compuesta
				oferC_LoMejorCliente.addOferta(oferJubilado);
				oferC_LoMejorCliente.addOferta(oferUmbral);
				
				// Asigna la oferta compuesta a la venta
				venta.setOfertaAplicar(oferC_LoMejorCliente);
				
				//Comprueba que el importe final de la venta aplicando la oferta compuesta es 100 (aplica la oferta por jubilado porque es lo favorece más al cliente)
				Assert.assertEquals(venta.calculaImporteFinal(),150.0,0.0);

	}
	
	@Test
	public void testOfertaCompuesta_MejorTienda_Jubilado_Umbral_aplicaAmbas2() {
		// test con oferta COMPUESTA con dos ofertas aplicando LO MEJOR PARA LA TIENDA ((se queda con el importe total más ALTO)
		//    aplica descuento del 50% por jubilado y por umbral (si el importe es mayor o igual del 150€ descuenta 50€) 
	
		System.out.println("9. Caso de prueba COMPUESTO lo mejor para la tienda: aplica descuento por jubilado y por umbral:");
		Venta venta=new Venta(cliPedro,200);
		
		// Crea la oferta compuesta
		OferCompuestaLoMejorTienda oferC_LoMejorTienda= new OferCompuestaLoMejorTienda();
		
		// Crea las ofertas simples para luego añadirlas a la compuesta
		IOferta oferUmbral=new OfertaImporteMayorUmbral(25,150); // crea una oferta para descontar 50€ si importe >=150
		IOferta oferJubilado=new OfertaJubilado(50); // crea una oferta para jubilados del 50%
		
		//añade las ofertas simples a la compuesta
		oferC_LoMejorTienda.addOferta(oferJubilado);
		oferC_LoMejorTienda.addOferta(oferUmbral);
		
		// Asigna la oferta compuesta a la venta
		venta.setOfertaAplicar(oferC_LoMejorTienda);
		
		//Comprueba que el importe final de la venta aplicando la oferta compuesta es 150 (aplica la oferta por UMBRAL porque es lo favorece más a LA TIENDA)
		Assert.assertEquals(venta.calculaImporteFinal(),150.0,0.0);
	}
		
	@Test
	public void testOfertaCompuesta_MejorTienda_Jubilado_Umbral_aplicaAmbas() {
		// otro test similar al anterior para comprobar que aplica la oferta por JUBILADO 
		// test con oferta COMPUESTA con dos ofertas aplicando LO MEJOR PARA LA TIENDA ((se queda con el importe total más ALTO)
		//    aplica descuento del 50% por jubilado y por umbral (si el importe es mayor o igual del 150€ descuenta 50€) 
			
				System.out.println("10. Caso de prueba COMPUESTO lo mejor para la tienda: aplica descuento por jubilado y por umbral:");
				Venta venta=new Venta(cliPedro,200);
				
				// Crea la oferta compuesta
				OferCompuestaLoMejorTienda oferC_LoMejorTienda= new OferCompuestaLoMejorTienda();
				
				// Crea las ofertas simples para luego añadirlas a la compuesta
				IOferta oferUmbral=new OfertaImporteMayorUmbral(50,150); // crea una oferta para descontar 50€ si importe >=150
				IOferta oferJubilado=new OfertaJubilado(10); // crea una oferta para jubilados del 10%
				
				//añade las ofertas simples a la compuesta
				oferC_LoMejorTienda.addOferta(oferJubilado);
				oferC_LoMejorTienda.addOferta(oferUmbral);
				
				// Asigna la oferta compuesta a la venta
				venta.setOfertaAplicar(oferC_LoMejorTienda);
				
				//Comprueba que el importe final de la venta aplicando la oferta compuesta es 150 (aplica la oferta por UMBRAL porque es lo favorece más a LA TIENDA)
				Assert.assertEquals(venta.calculaImporteFinal(),180.0,0.0);

	
	}
	
	@Test 
	public void testOfertaCompuestaEmail() {
		System.out.println("11. Caso COMPUESTO lo mejor para la tienda: Aplicando otra oferta compuesta y una simple");
		Venta venta = new Venta(cliPedro, 200);
		
		OferCompuestaLoMejorTienda ofer_LoMejorTienda = new OferCompuestaLoMejorTienda();
		OferCompuestaLoMejorTienda ofer2 = new OferCompuestaLoMejorTienda();
		
		IOferta oferUmbral = new OfertaImporteMayorUmbral(20, 100); //Crea una oferta para descontar 20% si importe >= 100   160
		IOferta oferUmbral2 = new OfertaImporteMayorUmbral(30, 150); //Crea una oferta para descontar 30% si importe >= 150  140
		IOferta oferJubilado = new OfertaJubilado(25); //Crea una oferta para descontar 25% si es jubilado  150
		
		ofer2.addOferta(oferUmbral2);
		ofer2.addOferta(oferJubilado);
		
		ofer_LoMejorTienda.addOferta(ofer2);
		ofer_LoMejorTienda.addOferta(oferUmbral);
		
		venta.setOfertaAplicar(ofer_LoMejorTienda);
		
		Assert.assertEquals(venta.calculaImporteFinal(), 160.0, 0.0);

		
	}
	

}
