package nl.loxia.optimalisatie.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

public class SetCoverProblem {

	private final Map<Swod, List<String>> swodNaarMeldingen;

	public SetCoverProblem(Map<Swod, List<String>> swodNaarMeldingen) {
		this.swodNaarMeldingen = ImmutableMap
				.copyOf(swodNaarMeldingen);
	}

	public Set<Swod> getSwods() {
		return swodNaarMeldingen.keySet();
	}

	public Set<String> getAlleMeldingen() {
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
		return alleMeldingenInSolution.equals(getAlleMeldingen());
	}

	public Set<String> getMeldingen(Swod swod) {
		List<String> meldingen = swodNaarMeldingen.get(swod);
		return meldingen == null ? Collections.EMPTY_SET : new HashSet<String>(meldingen);
	}

	@Override
	public boolean equals(Object obj) {

		boolean result = true;
		result = result && obj != null;

		if (obj instanceof SetCoverProblem) {
			SetCoverProblem casted = (SetCoverProblem) obj;
			result = result
					&& Objects.equal(swodNaarMeldingen,
							casted.swodNaarMeldingen);
			result = result
					&& Objects.equal(swodNaarMeldingen,
							casted.swodNaarMeldingen);
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(swodNaarMeldingen);
	}

}
