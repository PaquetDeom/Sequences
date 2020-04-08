package fr.paquet.io.dataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import fr.paquet.dataBase.User;

public class WriteFileUser {

	public WriteFileUser(User user) throws IOException {
		super();

		// vider le répertoire user
		deletedirectory(new File("./target/classes/user"));

		// créer le fichier user.txt
		File file = new File("./target/classes/user/user.txt");
		file.createNewFile();

		// écrit dans le fichier
		String s = System.getProperty("line.separator");
		FileWriter fw = new FileWriter(file, true);

		fw.write(user.getUtilisateur());
		fw.write(s);
		fw.write(user.getPass());

		fw.close();

	}

	private void deletedirectory(File path) {

		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {

				files[i].delete();
			}
		}
	}
}
