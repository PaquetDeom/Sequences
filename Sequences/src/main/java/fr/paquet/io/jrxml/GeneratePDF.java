package fr.paquet.io.jrxml;

import java.io.File;

import java.util.HashMap;

import fr.paquet.ihm.alert.AlertListener;
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

public class GeneratePDF implements AlertListener {

	private SequenceVersion sequenceVersion = null;
	private HashMap<String, Object> parameters = null;

	public GeneratePDF(SequenceVersion sequenceVersion) throws Exception {
		super();
		setSequenceVersion(sequenceVersion);

		// création des paramètres
		addParameters("titre", getSequenceVersion().getTitre());
		addParameters("numVersion", getSequenceVersion().getnVersion());

		// Création du rapport
		CreateReport();

	}

	private void addParameters(String key, Object value) {

		getParameters().put(key, value);

	}

	private HashMap<String, Object> getParameters() {
		if (parameters == null)
			parameters = new HashMap<String, Object>();
		return parameters;
	}

	private File filePdf = null;

	private void CreateReport() throws Exception {

		// - Chargement et compilation du rapport
		// JasperDesign jasperDesign;
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport("./target/classes/jrxml/classic.jrxml");
			jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, getParameters());

			// - Enregistrement du rapport au format PDF
			FileChooser fc = new FileChooser(this);
			setFilePdf(fc.getSelectedFile());
			JasperExportManager.exportReportToPdfFile(jasperPrint, getFilePdf().getAbsolutePath());

			new AlertWindow(AlertType.QUESTION, "Rapport créé Voulez-vous le voir ?", this);

		} catch (JRException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Le rapport n'a pas été généré");
		}

	}

	@Override
	public void buttonClick(String button) {
		// TODO

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
