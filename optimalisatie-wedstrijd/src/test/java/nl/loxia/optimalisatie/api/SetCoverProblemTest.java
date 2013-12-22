package nl.loxia.optimalisatie.api;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SetCoverProblemTest {

	private final Map<Swod, List<String>> swodNaarMeldingen = new HashMap<Swod, List<String>>();

	@Before
	public void before() {
		swodNaarMeldingen.put(new Swod("A", 1), asList("AAA-001", "AAA-002"));
		swodNaarMeldingen.put(new Swod("B", 3), asList("AAA-001", "AAA-003"));
	}

	@Test
	public void getSwods() {
		SetCoverProblem setCoverProblem = new SetCoverProblem(swodNaarMeldingen);

		Set<Swod> expected = new HashSet<Swod>(asList(new Swod("A", 1),
				new Swod("B", 3)));
		assertThat(setCoverProblem.getSwods(), is(expected));
	}

	@Test
	public void getMeldingen() {
		SetCoverProblem setCoverProblem = new SetCoverProblem(swodNaarMeldingen);

		Set<String> expected = new HashSet<String>(asList("AAA-001", "AAA-002",
				"AAA-003"));
		assertThat(setCoverProblem.getMeldingen(), is(expected));
	}

	@Test
	public void isSolution() {
		Set<Swod> swods = swodNaarMeldingen.keySet();
		SetCoverSolution solution = new SetCoverSolution(swods);

		SetCoverProblem setCoverProblem = new SetCoverProblem(swodNaarMeldingen);

		assertThat(setCoverProblem.isSolution(solution), is(true));
	}

	@Test
	public void isNotASolution() {
		Set<Swod> swods = new HashSet<Swod>();
		swods.add(new Swod("A", 1));
		SetCoverSolution solution = new SetCoverSolution(swods);

		SetCoverProblem setCoverProblem = new SetCoverProblem(swodNaarMeldingen);

		assertThat(setCoverProblem.isSolution(solution), is(false));
	}

}
