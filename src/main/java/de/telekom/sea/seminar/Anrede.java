package de.telekom.sea.seminar;

public enum Anrede {
	FRAU, DIVERS, MANN;

	public static Anrede fromString(final String value) {
		switch (value) {
		case "Frau":
		case "frau":
		case "F":
		case "f":
			return FRAU;
		case "Mann":
		case "mann":
		case "M":
		case "m":
			return MANN;
		case "Divers":
		case "divers":
		case "D":
		case "d":
			return DIVERS;
		default:
			throw new IllegalArgumentException("Diese Anrede existiert nicht " + value);

		}
	}

	public String toString() {
		switch (this) {
		case FRAU:
			return "Frau";
		case MANN:
			return "Mann";
		case DIVERS:
			return "Divers";
		}
		throw new IllegalArgumentException("Diese Anrede existiert nicht");
	}

}
