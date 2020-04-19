package fr.paquet.commun;

public enum TypeDiplome {

	CAP, BACPRO, BACSTI, BTS;

	public String getType() {
		switch (this) {
		case CAP:

			return "CAP";
		case BACPRO:
			return "Bac professionnel";
		case BACSTI:
			return "Bac technologique";
		case BTS:
			return "BTS";

		default:
			return null;
		}
	}

	public String[] getClasse() {

		switch (this) {
		case CAP:

			return new String[] { "première", "terminale" };
		case BACPRO:
			return new String[] { "seconde", "première", "terminale" };
		case BACSTI:
			return new String[] { "seconde", "première", "terminale" };
		case BTS:
			return new String[] { "première année", "seconde année" };

		default:
			return null;
		}
	}
}
