import java.util.ArrayList;
import java.util.Iterator;

public class Persona {

	public ArrayList<Enfermedad> enfermedadesActuales = new ArrayList<Enfermedad>();
	public float cantidadCelulas;
	public float temperatura;
	public boolean coma = false;

	public Persona(int cantCelulas,int grados){
		cantidadCelulas = cantCelulas;
		temperatura = grados;
	}

	public void contraer(Enfermedad nuevaEnfermedad){
		enfermedadesActuales.add(nuevaEnfermedad);
	}

	public void pasarDia(){
		Iterator<Enfermedad> i = enfermedadesActuales.iterator();
		while(i.hasNext()){
			Enfermedad enfermedad = i.next();
			enfermedad.Afectar(this);
			if(temperatura>45 || cantidadCelulas < 1000000){
				coma=true;
			}
		}
	}

	public void consultarEstado(){
		Enfermedad enfermedadMaxima = null;
		float max=0;
		float totalAmenazadas = 0;
		Iterator<Enfermedad> i = enfermedadesActuales.iterator();
		while(i.hasNext()){
			Enfermedad enfermedad = i.next();
			
			if(enfermedad.celulasAmenazadas>max){
				enfermedadMaxima = enfermedad;
				max = enfermedad.celulasAmenazadas;
			}
			if(enfermedad.esAgresiva(this)){
				totalAmenazadas = totalAmenazadas + enfermedad.celulasAmenazadas;
			}

		}
		System.out.println("La cantidad total de celulas amenazadas por enfermedades agresivas es "+ totalAmenazadas);
		System.out.println("La enfermedad con mas celulas amenazadas es " + enfermedadMaxima.nombre + " con " + enfermedadMaxima.celulasAmenazadas + " celulas amenazadas");
		System.out.println("Esta en coma: " + coma);
		
	}


}
