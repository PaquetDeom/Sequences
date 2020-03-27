package fr.paquet.ihm.style;

import java.awt.Font;

public enum StyleFont {

	TEXTEAREASEQUENCE, TITLESEQ, TITLEACT;

	public Font getFont() {
		switch (this) {
		case TEXTEAREASEQUENCE:
			return new Font("Arial", Font.PLAIN, 14);
		case TITLESEQ:
			return new Font("Arial", Font.PLAIN, 16);
		case TITLEACT:
			return new Font("Arial", Font.PLAIN, 16);

		default:
			return null;
		}
	}
}
