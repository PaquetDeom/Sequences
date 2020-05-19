package fr.paquet.ihm.io;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import fr.paquet.io.jrxml.GeneratePDF;

public class FileChooser extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file = null;

	public FileChooser(GeneratePDF gP) {

		super();

		FileSystemView.getFileSystemView().getHomeDirectory();
		this.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
		this.setDialogTitle("Sauvegarde : ");
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int returnValue = showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			setFile(getSelectedFile());

		}

	}

	public File getFile() {
		return file;
	}

	private void setFile(File file) {
		this.file = file;
	}

}
