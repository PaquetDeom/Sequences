package fr.paquet.ihm.commun;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public enum CommunStyle {

	PANELTITLE, BORDER, BORDERTITLEAREA, TEXTAREASEQUENCE;

	public Color getColor() {
		switch (this) {
		case PANELTITLE:
			return new Color(153, 204, 255);

		default:
			return null;
		}
	};

	public Border getBorder() {
		switch (this) {
		case BORDER:
			return BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "");
		case BORDERTITLEAREA:
			return BorderFactory.createLineBorder(Color.BLACK);
		default:
			return null;
		}
	}

	public Font getFont() {
		switch (this) {
		case TEXTAREASEQUENCE:
			return new Font("Arial", Font.PLAIN, 14);

		default:
			return null;
		}
	}
}
