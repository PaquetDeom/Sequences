package fr.paquet.ihm.commun;

import java.awt.Color;

public enum CommunStyle {

	PANELTITLE;

	public Color getColor() {
		switch (this) {
		case PANELTITLE:
			return new Color(153, 204, 255);

		default:
			return null;
		}
	};
}
