package nl.loxia.optimalisatie.api;

import java.util.Set;

public final class SetCoverSolution {

	private final Set<Swod> swods;

	public SetCoverSolution(Set<Swod> swods) {
		this.swods = swods;
	}

	public Set<Swod> getSwods() {
		return swods;
	}

	public int getCost() {
		int result = 0;
		for (Swod swod : swods) {
			result += swod.getAantalBladen();
		}
		return result;
	}

}
