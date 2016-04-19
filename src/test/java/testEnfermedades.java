import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class testEnfermedades {
	
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
	public void seReproduceInfecciosa(){
		float celulasAnteriores = malaria.celulasAmenazadas;
		malaria.Reproducirse();
		boolean resultado = celulasAnteriores < malaria.celulasAmenazadas;
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void confirmaAgresividadAutoinmune(){
		Logan.contraer(lupus);
		for(int i = 0; i<31; i++){
			Logan.pasarDia();
		}
		
		Assert.assertTrue(lupus.esAgresiva(Logan));
	}
	
	@Test
	public void noConfirmaAgresividadAutoinmune(){
		Logan.contraer(lupus);
		for(int i = 0; i<30; i++){
			Logan.pasarDia();
		}
		
		Assert.assertFalse(lupus.esAgresiva(Logan));
	}
	
	@Test
	public void confirmaAgresividadInfecciosa(){
		malaria.celulasAmenazadas=300001;
		Logan.contraer(malaria);
		
		Assert.assertTrue(malaria.esAgresiva(Logan));
	}
	
	@Test
	public void noConfirmaAgresividadInfecciosa(){
		malaria.celulasAmenazadas=300000;
		Logan.contraer(malaria);
		Assert.assertFalse(malaria.esAgresiva(Logan));
	}
}
