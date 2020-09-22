package SemaforoCorrida;

import java.util.concurrent.Semaphore;

public class ThreadCorrida extends Thread {
private int id;
private static int[] grid = new int[14];l


private Semaphore semaforo;

public ThreadCorrida(int num, 
	Semaphore semaforo){
	this.id = num;
	this.semaforo = semaforo;
}


@Override
public void run(){//-----------------------------

	for(int piloto=1; piloto<=2; piloto++){
		System.out.println("Corredor#"+
			piloto+
			" da escuderia"+
			id+
			" entrou na corrida"+
		"!");
	
		try {
			semaforo.acquire();
			corredorCorre(piloto);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
	}
}

private void corredorCorre(int piloto){//--------

	int menorVolta=9999;
	for(int volta=1; volta<=3; volta++){
		
		int tempoVolta= (int)(Math.random()*3000);
		try{
			Thread.sleep(tempoVolta);
			System.out.println("Piloto"+
				piloto+
				" da escuderia"+
				id+
				" completou uma volta em"+
				tempoVolta+
				" unidades de tempo"+
			"!");
			
			if (tempoVolta <= menorVolta){
				menorVolta = tempoVolta;
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	//adicionar ao grid (((((((((((-)))))))))))
	
}

}
