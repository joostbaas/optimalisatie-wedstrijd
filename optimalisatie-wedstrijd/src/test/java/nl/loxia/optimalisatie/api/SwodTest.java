package nl.loxia.optimalisatie.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

@SuppressWarnings("static-method")
public class SwodTest {

	private static final Swod SWOD_A = new Swod("A", 1);
	private static final Swod SWOD_B = new Swod("B", 1);

	@Test
	public void equalsEnHashCode() {
		Swod swod1 = SWOD_A;
		Swod swod2 = SWOD_A;

		assertThat(swod1, equalTo(swod2));
		assertThat(swod1, not(equalTo(new Swod("A", 2))));
		assertThat(swod1, not(equalTo(SWOD_B)));
		assertThat(swod1, not(equalTo(new Object())));
		assertThat(swod1, not(equalTo(null)));

		assertThat(swod2, equalTo(swod1));
		assertThat(swod1.hashCode(), equalTo(swod2.hashCode()));
	}

	@Test
	public void testToString() {
		assertThat(SWOD_A.toString(), is("A (1)"));
	}

	@Test
	public void testCompare() {
		assertThat(SWOD_A.compareTo(SWOD_B), is(-1));
		assertThat(SWOD_B.compareTo(SWOD_A), is(1));
		assertThat(SWOD_A.compareTo(SWOD_A), is(0));
	}
}
