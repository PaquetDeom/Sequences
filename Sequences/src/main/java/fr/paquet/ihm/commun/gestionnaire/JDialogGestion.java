package fr.paquet.ihm.commun.gestionnaire;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.paquet.ihm.style.StyleBorder;
import main.MainFrame;

public abstract class JDialogGestion extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton buttonOk = new JButton("Valider");
	protected JButton buttonAnnul = new JButton("Annuler");
	protected Object object = null;
	protected JTreeGestionnaire jtreeGestionnaire = null;
	protected JPanelGestionnaireRight jPanelGestionnaireRight = null;

	protected abstract void setJtreeGestionnaire();

	public JTreeGestionnaire getJtreGestionnaire() {
		return jtreeGestionnaire;
	}

	protected abstract void setJPanelGestionnaireRight();

	private JPanelGestionnaireRight getJPanelGestionnaireRight() {
		return jPanelGestionnaireRight;
	}

	public JDialogGestion(String title, Object obj) {
		super(MainFrame.getUniqInstance());

		// construction de la fenetre
		setTitle(title);
		setSize(2000, 600);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// ajout des composants
		setObject(obj);
		setJtreeGestionnaire();
		setJPanelGestionnaireRight();
		setJSplitPaneLeft(getJtreGestionnaire());
		setJSplitPaneRight(getJPanelGestionnaireRight());
		//setJButtomPanel(new JPanel());

		// ajout du panel
		setContentPane(getMainPane());

		// listener
		buttonOk.addActionListener(this);
		buttonAnnul.addActionListener(this);
	}

	private void setObject(Object object) {
		this.object = object;
	}

	protected Object getObject() {
		return object;
	}

	private JPanel getMainPane() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(getTopPanel(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(getJButtonPanel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		return panel;
	}

	private JPanel topPanel = null;

	protected JPanel getTopPanel() {

		if (topPanel == null) {
			topPanel = new JPanel(new GridBagLayout());
			topPanel.setBorder(StyleBorder.BORDERPANEL.getBorder());
			topPanel.add(getSplitPane(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			//topPanel.add(getJButtomPanel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
					//GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		}
		return topPanel;
	}

	protected JPanel buttomPanel = null;
	
	protected abstract void setButtomPanel();

	public ButtomPanel getJButtomPanel() {
		
		return (ButtomPanel) buttomPanel;
	}

	private JSplitPane jS = null;

	protected JSplitPane getSplitPane() {
		if (jS == null) {
			jS = new JSplitPane();
			jS.setLeftComponent(getJSplitPaneLeft());
			jS.setRightComponent(getJSplitPaneRight());
		}
		return jS;
	}

	protected Component leftComponent = null;

	private void setJSplitPaneLeft(Component component) {
		this.leftComponent = component;
	}

	private Component getJSplitPaneLeft() {
		return leftComponent;
	}

	protected Component rightComponent = null;

	private Component getJSplitPaneRight() {
		return rightComponent;
	}

	protected void setJSplitPaneRight(Component component) {
		this.rightComponent = component;
	}

	private JPanel getJButtonPanel() {
		JPanel panel = new JPanel(new GridBagLayout());

		panel.add(new JPanel(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panel.add(buttonOk, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(buttonAnnul, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		return panel;
	}

}
