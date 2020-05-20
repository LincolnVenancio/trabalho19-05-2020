package controller;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadClass extends Thread {

	private int pessoa;
	int distanciaPercorrida = 0;
	int corredor = 200;
	private static int Chegada;
	private Semaphore sem;

	public ThreadClass(int pessoa, Semaphore semaforo) {
		this.pessoa = pessoa;
		this.sem = semaforo;
	}

	@Override
	public void run() {
		Andar();
		try {
			sem.acquire();
			AbrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sem.release();
		}
	}

	private void Andar() {
		Random random = new Random();
		int deslocamento = (int) ((random.nextDouble() * 2) + 4);
		while (distanciaPercorrida < corredor) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Pessoa " + pessoa + " andou " + distanciaPercorrida + " metros.");
		}

	}

	private void AbrirPorta() {
	Random random = new Random();
	int tempo = (int) ((random.nextDouble() * 1000) + 1000);
		Chegada++;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pessoa " + pessoa + " cruzou a porta e ficou em " + Chegada + "º Lugar");
	}

}