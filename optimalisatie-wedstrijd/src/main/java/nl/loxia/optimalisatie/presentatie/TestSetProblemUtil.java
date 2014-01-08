package nl.loxia.optimalisatie.presentatie;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import nl.loxia.optimalisatie.api.SetCoverProblem;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class TestSetProblemUtil {

	public static SetCoverProblem create() {
		URL resource = TestSetProblemUtil.class.getResource("testset.csv");
		try {
			List<String> readLines = Resources.readLines(resource, Charsets.UTF_8);
			return CsvReader.read(readLines);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
