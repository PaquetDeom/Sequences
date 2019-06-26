package fr.paquet.ihm.nouveau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.CommunJDialogTextField;
import fr.paquet.sequence.Sequence;
import main.MainFrame;

public class JDialogNewSequence extends CommunJDialogTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogNewSequence(String title, String titleLabel) {
		super(title, titleLabel);

	}

	@Override
	protected void setButtonOk(JButton buttonOk) {

		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					Sequence sequence = new Sequence(getTitleField().getText());

					MainFrame.getUniqInstance().addPanel(sequence);

				} catch (Exception e) {
					JDialogNewSequence.this.dispose();
					new AlertWindow(AlertType.ERREUR, "création de la séquence impossible");
					e.printStackTrace(System.out);
				}
				JDialogNewSequence.this.dispose();
			}

		});
		this.buttonOk = buttonOk;

	}

	@Override
	protected void setButtonAnnul(JButton buttonAnnul) {
		buttonAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JDialogNewSequence.this.dispose();

			}
		});

		this.buttonAnnul = buttonAnnul;

	}

	@Override
	protected void setTitleField(JTextField titleField) {
		titleField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		this.titleField = titleField;

	}

	@Override
	protected void setTitleLabel(JLabel TitleLabel) {
		this.titleLabel = TitleLabel;

	}

}
