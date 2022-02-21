package fr.paquet.activite;

public enum DemarchePedagogique {

	INDUCTIVE, DEDUCTIVE, DIALECTIQUE;

	public String getTitre() {
		switch (this) {
		case INDUCTIVE:

			return "Inductive";
		case DEDUCTIVE:

			return "Déductive";
		case DIALECTIQUE:

			return "Dialectique";

		default:
			return null;
		}
	}

	public String getExplication() {
		switch (this) {
		case INDUCTIVE:

			return "Cette démarche consiste à aller du particulier au général, on part d'exemple concrets puis on construit peu à peu les principes généraux.";
		case DEDUCTIVE:

			return "Cette démarche consiste à aller du général au particulier, c'est à dire à proposer un principe général puis à proposer des exercices.";
		case DIALECTIQUE:

			return "Cette démarche consiste à mettre des connaissances en contracdiction les unes par rapport aux autres afin de formuler des principes généraux";

		default:
			return null;
		}
	}
}
