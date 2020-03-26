package fr.paquet.ihm.commun;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;

public class CommunTitle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommunTitle(Title title) throws Exception {
		super();

		// creation du layout
		setLayout(new GridLayout(0, title.getcolumn(), 0, 0));

		int i = 0;

		for (String a : title.getTitle()) {
			JLabel label = new JLabel(a);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(StyleFont.TITLESEQ.getFont());
			JPanel panel = new JPanel();
			panel.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
			panel.setBackground(StyleColor.PANELTITLE.getColor());
			panel.add(label);
			add(panel);
			i++;
		}

		// attributs du panel

	}

}
