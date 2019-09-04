package fr.paquet.ihm.style;

import java.awt.Color;

public enum StyleColor {

	PANELTITLE;

	public Color getColor() {
		switch (this) {
		case PANELTITLE:
			return new Color(153, 204, 255);

		default:
			return null;
		}
	}

}
