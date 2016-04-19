
public class Infecciosa extends Enfermedad {

	public Infecciosa(String nombreEnfermedad, float cantCelulas){
		celulasAmenazadas = cantCelulas;
		nombre = nombreEnfermedad;
	}
	
	@Override
	public void Afectar(Persona unaPersona){
		unaPersona.temperatura = unaPersona.temperatura + celulasAmenazadas/1000;
	}
	
	public void Reproducirse(){
		celulasAmenazadas = celulasAmenazadas*2;
	}

	@Override
	public boolean esAgresiva(Persona unaPersona) {
		if(celulasAmenazadas > unaPersona.cantidadCelulas/10){
			return true;
		}else{
			return false;
		}
	}

}
