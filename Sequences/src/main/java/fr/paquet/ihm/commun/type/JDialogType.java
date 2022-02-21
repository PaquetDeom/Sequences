package fr.paquet.ihm.commun.type;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import fr.paquet.ihm.action.ActionNouveau;
import fr.paquet.ihm.nouveau.sequence.JDialogNewSequence;
import main.MainFrame;

public class JDialogType extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionNouveau action = null;

	public JDialogType(ActionNouveau action) {
		super(MainFrame.getUniqInstance());
		
		this.action = action;

		// construction de la fenêtre
		setTitle("Que voulez-vous créer");
		setResizable(false);
		setSize(600, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);

		// ajout du panel
		setContentPane(new JPanel());

		// listener
		getBtnSequence().addActionListener(this);
		getBtnModule().addActionListener(this);
		getBtnProgression().addActionListener(this);

	}

	private JButton getBtnProgression() {

		return new JButton("Progression");
	}

	private JButton getBtnModule() {

		return new JButton("Module");
	}

	private JButton getBtnSequence() {

		return new JButton("Sequence");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton button = (JButton) event.getSource();
		
		if (button.getText().equals("Sequence"))
			new JDialogNewSequence();
		if (button.getText().equals("Module"))
			this.dispose();
		if (button.getText().equals("Progression"))
			this.dispose();
		

	}

}
