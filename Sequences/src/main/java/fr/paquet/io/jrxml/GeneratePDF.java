package fr.paquet.io.jrxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.io.FileChooser;
import fr.paquet.sequence.SequenceVersion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;

public class GeneratePDF {

	private SequenceVersion sequenceVersion = null;

	public GeneratePDF(SequenceVersion sequenceVersion) throws Exception {
		super();
		setSequenceVersion(sequenceVersion);

		// création des paramètres
		createSequenceParameters();

		// Création du répertoire au nom de la séquence
		createDirectory(getSequenceVersion());

		// Création du rapport
		createReport();

	}

	private HashMap<String, Object> activiteParameters = null;

	private HashMap<String, Object> getActiviteParameters() {
		if (activiteParameters == null)
			activiteParameters = new HashMap<String, Object>();
		return activiteParameters;
	}

	private void addActiviteParameters(String key, Object value) {

		this.activiteParameters = null;
		getActiviteParameters().put(key, value);

	}

	private void createActiviteParameters(Activite_1 activite) {
		try {
			addActiviteParameters("activiteId", activite.getId());
		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "L'activite n'existe pas");
		}

	}

	private void createSequenceParameters() {
		try {
			addSequenceParameters("sequenceId", getSequenceVersion().getId());
		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "La séquence n'existe pas");
		}

	}

	private HashMap<String, Object> sequenceParameters = null;

	private HashMap<String, Object> getSequenceParameters() {
		if (sequenceParameters == null)
			sequenceParameters = new HashMap<String, Object>();
		return sequenceParameters;
	}

	private void addSequenceParameters(String key, Object value) {

		if (!getSequenceParameters().containsKey(key))
			getSequenceParameters().put(key, value);

	}

	private void createDirectory(SequenceVersion sequenceVersion) {
		FileChooser fc = new FileChooser(this);
		new File(fc.getPath()).mkdir();
		this.path = fc.getPath();

	}

	private String path = null;

	private void createReport() throws Exception {

		createSequencePdf();

		int i = 0;

		while (i < getSequenceVersion().getActivites().size()) {

			Activite_1 activite = getSequenceVersion().getActivites().get(i);

			createActiviteParameters(activite);
			createActivitePdf(activite);

			i++;
		}

		new AlertWindow(AlertType.INFORMATION, "La création du rapport est faite");

	}

	private void createActivitePdf(Activite_1 activite) {
		// - Enregistrement du rapport au format PDF

		File filePdf = new File(this.path + "/activite" + activite.getnActivite());

		try {
			File f = new File("./target/classes/jrxml/activite.jrxml");
			// System.out.println(f.getAbsolutePath());
			FileInputStream in = new FileInputStream(f);
			JasperReport jasperReportSeq = JasperCompileManager.compileReport(in);
			jasperReportSeq.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport de sequence
			JasperPrint jasperPrintSeq = JasperFillManager.fillReport(jasperReportSeq, getActiviteParameters(),
					Connect.getConnectionToSequenceDb());

			// - Envoi de la sequence dans le pdf
			JasperExportManager.exportReportToPdfFile(jasperPrintSeq, filePdf.getAbsolutePath());

		} catch (JRException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Erreur lors de la génération du rapport");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Erreur lors de la rcréation du fichier");

		}
	}

	private void createSequencePdf() {
		// - Enregistrement du rapport au format PDF

		File filePdf = new File(this.path + "/00sequence");

		try {
			File f = new File("./target/classes/jrxml/sequence2.jrxml");
			// System.out.println(f.getAbsolutePath());
			FileInputStream in = new FileInputStream(f);
			JasperReport jasperReportSeq = JasperCompileManager.compileReport(in);
			jasperReportSeq.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport de sequence
			JasperPrint jasperPrintSeq = JasperFillManager.fillReport(jasperReportSeq, getSequenceParameters(),
					Connect.getConnectionToSequenceDb());

			// - Envoi de la sequence dans le pdf
			JasperExportManager.exportReportToPdfFile(jasperPrintSeq, filePdf.getAbsolutePath());

		} catch (JRException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Erreur lors de la génération du rapport");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Erreur lors de la rcréation du fichier");

		}
	}

	public SequenceVersion getSequenceVersion() {
		return sequenceVersion;
	}

	public void setSequenceVersion(SequenceVersion sequenceVersion) {
		this.sequenceVersion = sequenceVersion;
	}
}
