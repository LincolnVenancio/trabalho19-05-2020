package view;

import java.util.concurrent.Semaphore;

import controller.ThreadClass;

public class Principal {

	public static void main(String[] args) {

		int freq = 1;
		Semaphore sem = new Semaphore(freq);

		for (int pessoa = 1; pessoa < 5; pessoa++) {
			Thread corredor = new ThreadClass(pessoa, sem);
			corredor.start();
		}

	}

}
