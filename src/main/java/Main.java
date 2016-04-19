
public class Main {

	public static void main(String[] args) {
		Infecciosa malariaA = new Infecciosa("Malaria",500);
		Infecciosa otitis = new Infecciosa("Otitis",100);
		Autoinmune lupus = new Autoinmune("Lupus",10000);
		Infecciosa malariaB = new Infecciosa("Malaria", 800);
		Persona Logan = new Persona(3000000,36);
		Logan.contraer(malariaA);
		Logan.contraer(otitis);
		Logan.contraer(lupus);
		Persona Frank = new Persona(3500000,36);
		
		Frank.contraer(malariaB);
		malariaA.Reproducirse();
		Logan.pasarDia();
		Logan.consultarEstado();
		
		for(int i = 0; i < 30; i++){
			Logan.pasarDia();
		}
		Logan.consultarEstado();
		
	}

}
