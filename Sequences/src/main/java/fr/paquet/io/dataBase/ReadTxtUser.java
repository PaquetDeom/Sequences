package fr.paquet.io.dataBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ReadTxtUser {

	/**
	 * Constructeur
	 * 
	 * @param pEchaf
	 * @param file
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public ReadTxtUser(BufferedReader buff) {

		super();

		// Création de la liste de String une String par ligne
		addLines(buff);

	}

	private List<String> lines = null;

	private void addLines(BufferedReader buff) {
		try {

			int ligneVide = 0;
			while (ligneVide < 20) {

				// lit 1 ligne du fichier CSV et rempli un tableau de String correspondant aux
				// zones de la ligne
				String ligne = buff.readLine();

				if (ligne == null || ligne.trim().length() == 0)
					ligneVide++;

				else {

					getLines().add(ligne);
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> getLines() {
		if (lines == null)
			lines = new ArrayList<String>();
		return lines;
	}

}
