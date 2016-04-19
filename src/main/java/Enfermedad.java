
public abstract class Enfermedad {

	String nombre;
	float celulasAmenazadas;
	
	public abstract boolean esAgresiva(Persona unaPersona);
	public abstract void Afectar(Persona unaPersona);

}
