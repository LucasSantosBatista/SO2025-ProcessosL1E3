package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistroController {
	public DistroController() {
		super();
	}

	// Retorna sistema operacional
	private String getOS() {
		return System.getProperty("os.name");
	}

	public void exibeDistro() {
		// Inicia buffer para a escrita do processo
		StringBuffer buffer = new StringBuffer();

		// Valida sistema operacional
		if (getOS().contains("Linux")) {
			buffer.append("cat /etc/os-release");

			// Utiliza buffer.toString().split() para converter em String e vetor
			try {
				Process p = Runtime.getRuntime().exec(buffer.toString().split(" "));
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

				String line = "";

				while ((line = reader.readLine()) != null) {
					if (line.contains("PRETTY_NAME")) {
						String[] pretty = line.split("\"");
						System.out.println(pretty[1]);
					}
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

		} else {
			System.err.println("Sistema operacional atual não é uma distro Linux");
		}
	}
}
