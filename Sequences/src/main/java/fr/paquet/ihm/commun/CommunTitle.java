package fr.paquet.ihm.commun;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CommunTitle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommunTitle(Title title) {
		super();

		// creation du layout
		setLayout(new GridLayout(0, title.getcolumn(), 0, 0));

		for (String a : title.getTitle()) {
			JLabel label = new JLabel(a);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JPanel panel = new JPanel();
			panel.setBorder(CommunStyle.BORDERTITLEAREA.getBorder());
			panel.setBackground(CommunStyle.PANELTITLE.getColor());
			panel.add(label);
			add(panel);
		}
	}

}
