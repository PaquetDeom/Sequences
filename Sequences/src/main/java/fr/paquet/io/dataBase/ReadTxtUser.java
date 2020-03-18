package fr.paquet.io.dataBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
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
	public ReadTxtUser() throws Exception {

		super();

		BufferedReader buff;
		buff = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("./target/classes/user/user.txt")), "UTF-8"));

		// Création de la liste de String une String par ligne
		addLines(buff);

		
		buff.close();

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
