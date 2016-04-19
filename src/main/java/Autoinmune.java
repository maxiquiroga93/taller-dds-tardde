
public class Autoinmune extends Enfermedad {
	int CantidadDias = 0;

	public Autoinmune(String nombreEnfermedad, float cantCelulas) {
		celulasAmenazadas=cantCelulas;
		nombre = nombreEnfermedad;
	}

	@Override
	public boolean esAgresiva(Persona unaPersona) {
		if(CantidadDias > 30){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void Afectar(Persona unaPersona) {
		unaPersona.cantidadCelulas = unaPersona.cantidadCelulas-celulasAmenazadas;
		CantidadDias = CantidadDias + 1;
	}

}
