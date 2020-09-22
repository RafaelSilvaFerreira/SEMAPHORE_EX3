package SemaforoCorrida;

import SemaforoCorrida.ThreadCorrida;
import java.util.concurrent.Semaphore;


public class Corrida{

public static Semaphore semaforo;

public static void main(){

	//int carrosTotal = 14;
	int carrosCorrendo = 5;
	//int carrosEscuderia = 0;
	semaforo = new Semaphore(carrosCorrendo);
	
	for (int i=0; i< 7; i++){
		Thread corrida= new ThreadCorrida(i,semaforo);
		corrida.start();
	}
}


}
