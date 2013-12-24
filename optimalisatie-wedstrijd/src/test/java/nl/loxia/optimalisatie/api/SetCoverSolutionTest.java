package nl.loxia.optimalisatie.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SetCoverSolutionTest {

	private final Set<Swod> swods = new HashSet<Swod>();

	@Before
	public void before() {
		swods.add(new Swod("A", 1));
		swods.add(new Swod("B", 1));
	}

	@Test
	public void getSwods() {
		SetCoverSolution solution = new SetCoverSolution(swods);

		assertThat(solution.getSwods(), is(swods));
	}

	@Test
	public void getCost() {
		SetCoverSolution solution = new SetCoverSolution(swods);

		assertThat(solution.getCost(), is(2));

	}

}
