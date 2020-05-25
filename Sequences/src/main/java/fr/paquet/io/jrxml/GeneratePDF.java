package fr.paquet.io.jrxml;

import java.io.File;

import java.util.HashMap;

import fr.paquet.activite.Activite_1;
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

		if (!getSequenceVersion().getActivites().isEmpty())
			for (Activite_1 act : getSequenceVersion().getActivites()) {
				createActiviteParameters(act);
			}

		// Création du rapport
		CreateReport();

	}

	private void createSequenceParameters() {
		addSequenceParameters("titre", getSequenceVersion().getTitre());
		addSequenceParameters("numVersion", getSequenceVersion().getnVersion());
	}

	private void createActiviteParameters(Activite_1 activite) {
		addActiviteParameters("nActivite", activite.getnActivite());

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

	private HashMap<String, Object> activiteParameters = null;

	private HashMap<String, Object> getActiviteParameters() {
		if (activiteParameters == null)
			activiteParameters = new HashMap<String, Object>();
		return activiteParameters;
	}

	private void addActiviteParameters(String key, Object value) {

		if (!getActiviteParameters().containsKey(key))
			getActiviteParameters().put(key, value);

	}

	private File filePdf = null;

	private void CreateReport() throws Exception {

		// - Chargement et compilation du rapport
		// JasperDesign jasperDesign;
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport("./target/classes/jrxml/classic.jrxml");
			jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport
			JasperPrint jasperPrint = null;
			jasperPrint = JasperFillManager.fillReport(jasperReport, getSequenceParameters());

			// - Enregistrement du rapport au format PDF
			FileChooser fc = new FileChooser(this);
			setFilePdf(fc.getSelectedFile());
			JasperExportManager.exportReportToPdfFile(jasperPrint, getFilePdf().getAbsolutePath());

			new AlertWindow(AlertType.QUESTION, "Rapport créé Voulez-vous le voir ?");

		} catch (JRException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Le rapport n'a pas été généré");
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
