package nl.loxia.optimalisatie.presentatie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import nl.loxia.optimalisatie.api.SetCoverProblem;
import nl.loxia.optimalisatie.api.Swod;

import org.junit.Test;

import com.google.common.collect.Sets;

@SuppressWarnings("static-method")
public class CsvReaderTest {

	@Test
	public void geenRegelsDanLeeg() {
		List<String> list = new ArrayList<String>();

		SetCoverProblem problem = CsvReader.read(list);

		assertThat(problem.getSwods(), is(empty()));
		assertThat(problem.getAlleMeldingen(), is(empty()));
	}

	@Test
	public void enkeleRegel() {
		List<String> list = Arrays
				.asList("\"dossier\\melding\";\"aantal bladen\";\"*PER-001\";\"*SGN-103\";",
						"\"Almelo - Hengelo\";4;1;1");

		SetCoverProblem problem = CsvReader.read(list);

		assertThat(problem.getSwods(), is(Collections.singleton(new Swod("Almelo - Hengelo", 4))));
		assertThat(problem.getAlleMeldingen(), is((Set<String>)Sets.newHashSet("*PER-001","*SGN-103")));
	}

	@Test
	public void meerdereRegels() {
		List<String> list = Arrays
				.asList("\"dossier\\melding\";\"aantal bladen\";\"*PER-001\";\"*SGN-103\";",
						"\"Almelo - Hengelo\";4;1;1", "\"Nog een dossier\";6;0;1");
		
		SetCoverProblem problem = CsvReader.read(list);
		
		Swod sw1 = new Swod("Almelo - Hengelo", 4);
		Swod sw2 = new Swod("Nog een dossier", 6);
		assertThat(problem.getSwods(), is((Set<Swod>)Sets.newHashSet(sw1, sw2)));
		assertThat(problem.getAlleMeldingen(), is((Set<String>)Sets.newHashSet("*PER-001","*SGN-103")));
		assertThat(problem.getMeldingen(sw1), is((Set<String>)Sets.newHashSet("*PER-001","*SGN-103")));
		assertThat(problem.getMeldingen(sw2), is((Set<String>)Sets.newHashSet("*SGN-103")));
	}
}
