package nl.loxia.optimalisatie.api;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

@SuppressWarnings("static-method")
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
	public void getAlleMeldingen() {
		SetCoverProblem setCoverProblem = new SetCoverProblem(swodNaarMeldingen);

		Set<String> expected = new HashSet<String>(asList("AAA-001", "AAA-002",
				"AAA-003"));
		assertThat(setCoverProblem.getAlleMeldingen(), is(expected));
	}

	@Test
	public void getMeldingenVoorSwod() {
		SetCoverProblem setCoverProblem = new SetCoverProblem(swodNaarMeldingen);

		Set<String> expected = new HashSet<String>(asList("AAA-001", "AAA-002"));
		assertThat(setCoverProblem.getMeldingen(new Swod("A", 1)), is(expected));
	}

	@Test
	public void getMeldingenVoorNietBestaandSwod() {
		SetCoverProblem setCoverProblem = new SetCoverProblem(new HashMap<Swod, List<String>>());
		
		assertThat(setCoverProblem.getMeldingen(new Swod("A", 1)), is(empty()));
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

	@Test
	public void equalsEnHashCode() {
		SetCoverProblem setCoverProblem1 = new SetCoverProblem(
				swodNaarMeldingen);
		SetCoverProblem setCoverProblem2 = new SetCoverProblem(
				swodNaarMeldingen);

		assertThat(setCoverProblem1, equalTo(setCoverProblem2));
		assertThat(setCoverProblem2, equalTo(setCoverProblem1));

		Map<Swod, List<String>> otherMap = ImmutableMap.of(
				new Swod("Other", 1), asList("AAA-001", "AAA-002"));
		assertThat(setCoverProblem1,
				not(equalTo(new SetCoverProblem(otherMap))));

		assertThat(setCoverProblem2.hashCode(),
				equalTo(setCoverProblem1.hashCode()));
	}

	@Test
	public void hashCodeKanNietVeranderen() {
		SetCoverProblem setCoverProblem = new SetCoverProblem(swodNaarMeldingen);
		int hashCodeVoor = setCoverProblem.hashCode();

		swodNaarMeldingen.put(new Swod("F", 2), asList("een"));

		int hashCodeNa = setCoverProblem.hashCode();
		assertThat(hashCodeVoor, equalTo(hashCodeNa));
	}

}
