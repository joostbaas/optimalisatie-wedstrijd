package nl.loxia.optimalisatie.api;

import com.google.common.base.Objects;

public class Swod {

	private final String dossierNaam;
	private final int aantalBladen;

	public Swod(String dossierNaam, int aantalBladen) {
		this.dossierNaam = dossierNaam;
		this.aantalBladen = aantalBladen;
	}

	// public String getDossierNaam() {
	// return dossierNaam;
	// }

	public int getAantalBladen() {
		return aantalBladen;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = true;
		result = result && obj != null;

		if (obj instanceof Swod) {
			Swod casted = (Swod) obj;
			result = result
					&& java.util.Objects
							.equals(dossierNaam, casted.dossierNaam);
			result = result
					&& java.util.Objects.equals(aantalBladen,
							casted.aantalBladen);
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(dossierNaam, aantalBladen);
	}
}
