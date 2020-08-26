package fr.paquet.io.jrxml;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.io.FileChooser;
import fr.paquet.sequence.SequenceVersion;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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

	// convert List to JRBeanCollectionDataSource
	private JRBeanCollectionDataSource competenceSequenceDataSource = null;

	private JRBeanCollectionDataSource getCompetenceSequenceDataSource() {
		if (competenceSequenceDataSource == null && !getSequenceVersion().getCompetenceIntermediaires().isEmpty())
			competenceSequenceDataSource = new JRBeanCollectionDataSource(
					getSequenceVersion().getCompetenceIntermediaires());
		return competenceSequenceDataSource;
	}

	private JRBeanCollectionDataSource savoirSequenceDataSource = null;

	private JRBeanCollectionDataSource getSavoirSequenceDataSource() {
		if (savoirSequenceDataSource == null && !getSequenceVersion().getSavoirAssocies().isEmpty())
			savoirSequenceDataSource = new JRBeanCollectionDataSource(getSequenceVersion().getSavoirAssocies());
		return savoirSequenceDataSource;
	}

	private void createSequenceParameters() {
		addSequenceParameters("titreSequence", getSequenceVersion().getTitre());
		addSequenceParameters("numVersion", getSequenceVersion().getnVersion());
		addSequenceParameters("classe", getSequenceVersion().getClasse());
		addSequenceParameters("auteur", getSequenceVersion().getAuteur().toString());
		addSequenceParameters("referentiel", getSequenceVersion().getReferentiel().toString());
		addSequenceParameters("competence", getCompetenceSequenceDataSource());
		addSequenceParameters("savoir", getSavoirSequenceDataSource());
		addSequenceParameters("problematique", getSequenceVersion().getProblematique());
		addSequenceParameters("contexte", getSequenceVersion().getContexte());
		addSequenceParameters("prerequis", getSequenceVersion().getPrerequis());
		addSequenceParameters("elementRetenir", getSequenceVersion().getElementsARetenir());
		addSequenceParameters("lienDiscipline", getSequenceVersion().getLien());
		addSequenceParameters("modaliteEval", getSequenceVersion().getEval());

	}

	private void createActiviteParameters(Activite_1 activite) {
		HashMap<String, Object> hM = new HashMap<String, Object>();

		hM.put("titreSequence", getSequenceVersion().getTitre());
		hM.put("numVersion", getSequenceVersion().getnVersion());
		hM.put("classe", getSequenceVersion().getClasse());
		hM.put("auteur", getSequenceVersion().getAuteur().toString());
		hM.put("referentiel", getSequenceVersion().getReferentiel().toString());

		hM.put("nActivite", activite.getnActivite());

		getListActiviteParameters().add(hM);

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

	private List<HashMap<String, Object>> listActiviteParameters = null;

	public List<HashMap<String, Object>> getListActiviteParameters() {
		if (listActiviteParameters == null)
			listActiviteParameters = new ArrayList<HashMap<String, Object>>();
		return listActiviteParameters;
	}

	private File filePdf = null;

	private void CreateReport() throws Exception {

		// - Chargement et compilation du rapport
		// JasperDesign jasperDesign;

		// - Enregistrement du rapport au format PDF
		FileChooser fc = new FileChooser(this);
		setFilePdf(fc.getSelectedFile());

		try {
			File f=new File("./target/classes/jrxml/classicSequence.jrxml");
			System.out.println(f.getAbsolutePath());
			FileInputStream in=new FileInputStream(f);
			JasperReport jasperReportSeq = JasperCompileManager
					.compileReport(in);
			jasperReportSeq.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport de sequence
			JasperPrint jasperPrintSeq = JasperFillManager.fillReport(jasperReportSeq, getSequenceParameters(),new JREmptyDataSource(1));

			// - Envoi de la sequence dans le pdf
			JasperExportManager.exportReportToPdfFile(jasperPrintSeq, getFilePdf().getAbsolutePath());

			/**if (!getSequenceVersion().getActivites().isEmpty()) {

				for (HashMap<String, Object> hM : getListActiviteParameters()) {
					JasperReport jasperReportAct = JasperCompileManager
							.compileReport("./target/classes/jrxml/classicActivite.jrxml");
					jasperReportAct.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

					// - Execution du rapport de sequence
					JasperPrint jasperPrintAct = null;
					jasperPrintAct = JasperFillManager.fillReport(jasperReportAct, hM);

					// - Envoi de la sequence dans le pdf
					JasperExportManager.exportReportToPdfFile(jasperPrintAct, getFilePdf().getAbsolutePath());
				}
			}*/

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
