package fr.paquet.ihm.style;

import java.awt.Color;

public enum StyleColor {

	PANELTITLE, PANELTITLESUPPORT;

	public Color getColor() {
		switch (this) {
		case PANELTITLE:
			return new Color(153, 204, 255);
		case PANELTITLESUPPORT:
			return new Color(102, 153, 204);

		default:
			return null;
		}
	}

}
