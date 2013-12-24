package nl.loxia.optimalisatie.api;

import com.google.common.base.Objects;

public class Swod implements Comparable<Swod> {

	private final String dossierNaam;
	private final int aantalBladen;

	public Swod(String dossierNaam, int aantalBladen) {
		this.dossierNaam = dossierNaam;
		this.aantalBladen = aantalBladen;
	}

	public String getDossierNaam() {
		return dossierNaam;
	}

	public int getAantalBladen() {
		return aantalBladen;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = true;
		result = result && obj != null;

		if (obj instanceof Swod) {
			Swod casted = (Swod) obj;
			result = result && Objects.equal(dossierNaam, casted.dossierNaam);
			result = result && Objects.equal(aantalBladen, casted.aantalBladen);
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(dossierNaam, aantalBladen);
	}

	@Override
	public String toString() {
		return String.format("%s (%d)", getDossierNaam(), getAantalBladen());
	}

	@Override
	public int compareTo(Swod o) {
		return dossierNaam.compareTo(o.dossierNaam);
	}
}
