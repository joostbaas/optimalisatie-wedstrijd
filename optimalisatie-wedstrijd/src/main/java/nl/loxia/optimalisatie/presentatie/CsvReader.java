package nl.loxia.optimalisatie.presentatie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.loxia.optimalisatie.api.SetCoverProblem;
import nl.loxia.optimalisatie.api.Swod;

public class CsvReader {

	private CsvReader() {
		// util class
	}

	public static SetCoverProblem read(List<String> lines) {
		Map<Swod, List<String>> swodNaarMeldingen = new HashMap<Swod, List<String>>();

		if (lines.size() > 1) {
			List<String> alleMeldingen = parseAlleMeldingen(lines.get(0));
			for (int i = 1; i < lines.size(); i++) {
				Swod sw = getSwod(lines.get(i));
				List<String> meldingenVoorSwod = getMeldingenVoorSwod(
						lines.get(i), alleMeldingen);
				swodNaarMeldingen.put(sw, meldingenVoorSwod);
			}
		}

		return new SetCoverProblem(swodNaarMeldingen);
	}

	private static List<String> getMeldingenVoorSwod(String string,
			List<String> alleMeldingen) {
		List<String> result = new ArrayList<String>();
		String[] split = string.split(";");
		for (int i = 2; i < split.length; i++) {
			if ("1".equals(split[i])) {
				result.add(alleMeldingen.get(i - 2).replaceAll("^\"|\"$", ""));
			}
		}
		return result;
	}

	private static Swod getSwod(String string) {
		String[] split = string.split(";");
		String dossierNaam = split[0].replaceAll("^\"|\"$", "");

		return new Swod(dossierNaam, Integer.parseInt(split[1]));
	}

	private static List<String> parseAlleMeldingen(String eersteRegel) {
		String[] split = eersteRegel.split(";");
		List<String> result = new ArrayList<String>(split.length);
		for (int i = 2; i < split.length; i++) {
			result.add(split[i]);
		}
		return result;
	}

}
