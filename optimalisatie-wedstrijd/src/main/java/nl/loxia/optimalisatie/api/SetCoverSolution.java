package nl.loxia.optimalisatie.api;

import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.Objects;

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

	@Override
	public boolean equals(Object obj) {
		boolean result = true;
		result = result && obj != null;

		if (obj instanceof SetCoverSolution) {
			SetCoverSolution casted = (SetCoverSolution) obj;
			result = result && Objects.equal(swods, casted.swods);
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(swods);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getCost()).append(',');

		for (Swod swod : new TreeSet<Swod>(swods)) {
			sb.append(swod.getDossierNaam()).append(',');
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}
}
