package fr.paquet.io.jrxml;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

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

		// Création du rapport
		CreateReport();

	}

	private void createSequenceParameters() {
		try {
			addSequenceParameters("sequenceId", getSequenceVersion().getId());
		} catch (Exception e) {
			e.printStackTrace();
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

	private File filePdf = null;

	private void CreateReport() throws Exception {

		// - Chargement et compilation du rapport
		// JasperDesign jasperDesign;

		// - Enregistrement du rapport au format PDF
		FileChooser fc = new FileChooser(this);
		setFilePdf(fc.getSelectedFile());

		try {
			File f = new File("./target/classes/jrxml/sequence2.jrxml");
			System.out.println(f.getAbsolutePath());
			FileInputStream in = new FileInputStream(f);
			JasperReport jasperReportSeq = JasperCompileManager.compileReport(in);
			jasperReportSeq.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport de sequence
			JasperPrint jasperPrintSeq = JasperFillManager.fillReport(jasperReportSeq, getSequenceParameters(),
					Connect.getConnectionToSequenceDb());

			// - Envoi de la sequence dans le pdf
			JasperExportManager.exportReportToPdfFile(jasperPrintSeq, getFilePdf().getAbsolutePath());

			new AlertWindow(AlertType.INFORMATION, "La création du rapport est faite");

		} catch (JRException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Erreur lors de la génération du rapport");
		}

	}

	private File getFilePdf() {
		return filePdf;
	}

	private void setFilePdf(File filePdf) {
		this.filePdf = filePdf;
	}

	public SequenceVersion getSequenceVersion() {
		return sequenceVersion;
	}

	public void setSequenceVersion(SequenceVersion sequenceVersion) {
		this.sequenceVersion = sequenceVersion;
	}
}
