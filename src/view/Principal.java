package view;

import controller.DistroController;

public class Principal {
	public static void main(String[] args) {
		DistroController control = new DistroController();
		
		control.exibeDistro();
	}
}
