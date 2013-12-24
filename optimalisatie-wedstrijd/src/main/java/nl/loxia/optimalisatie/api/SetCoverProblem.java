package nl.loxia.optimalisatie.api;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SetCoverProblem {

	private final Map<Swod, List<String>> swodNaarMeldingen;

	public SetCoverProblem(Map<Swod, List<String>> swodNaarMeldingen) {
		this.swodNaarMeldingen = swodNaarMeldingen;
	}

	public Set<Swod> getSwods() {
		return swodNaarMeldingen.keySet();
	}

	public Set<String> getMeldingen() {
		Set<String> result = new TreeSet<String>();
		for (List<String> meldingen : swodNaarMeldingen.values()) {
			result.addAll(meldingen);
		}
		return result;
	}

	public boolean isSolution(SetCoverSolution candidate) {
		Set<String> alleMeldingenInSolution = new HashSet<String>();
		for (Swod swod : candidate.getSwods()) {
			alleMeldingenInSolution.addAll(swodNaarMeldingen.get(swod));
		}
		return alleMeldingenInSolution.equals(getMeldingen());
	}

}
