import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class testPersona {
	
	private Persona Logan;
	private Infecciosa malaria,otitis;
	private Autoinmune lupus;
	
	@Before
	public void inicializarPersona(){
		Logan = new Persona(3000000,36);
	}
	
	@Before
	public void inicializarEnfermedades(){
		malaria = new Infecciosa("Malaria",500);
		otitis = new Infecciosa("Otitis",100);
		lupus = new Autoinmune("Lupus",10000);
	}
	
	@Test
	public void contraeEnfermedades(){
		Logan.contraer(malaria);
		Assert.assertFalse(Logan.enfermedadesActuales.isEmpty());
	}
	
	@Test
	public void aumentaTemperaturayDisminuyenCelulas(){
		Logan.contraer(malaria);
		Logan.contraer(otitis);
		Logan.contraer(lupus);
		float temperaturaAnterior = Logan.temperatura;
		float cantidadCelulasAnterior = Logan.cantidadCelulas;
		
		boolean resultado;
		Logan.pasarDia();
		resultado = (Logan.temperatura>temperaturaAnterior && cantidadCelulasAnterior > Logan.cantidadCelulas);
		Assert.assertTrue(resultado);
	}
	
	

}
