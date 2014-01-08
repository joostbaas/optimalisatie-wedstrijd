package nl.loxia.optimalisatie.presentatie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

@SuppressWarnings("static-method")
public class TestSetProblemUtilTest {

	@Test
	public void create() {
		assertThat(TestSetProblemUtil.create(), is(notNullValue()));
	}
	
}
