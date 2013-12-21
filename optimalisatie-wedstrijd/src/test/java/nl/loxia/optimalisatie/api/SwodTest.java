package nl.loxia.optimalisatie.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SwodTest {

	@Test
	public void equalsEnHashCode() {
		Swod swod1 = new Swod("A", 1);
		Swod swod2 = new Swod("A", 1);

		assertThat(swod1, equalTo(swod2));
		assertThat(swod1, not(equalTo(new Swod("A", 2))));
		assertThat(swod1, not(equalTo(new Swod("B", 1))));
		assertThat(swod1, not(equalTo(new Object())));
		assertThat(swod1, not(equalTo(null)));

		assertThat(swod2, equalTo(swod1));
		assertThat(swod1.hashCode(), equalTo(swod2.hashCode()));
	}
}
