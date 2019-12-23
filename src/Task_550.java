import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Task_550 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		ProgrammerDay test = new ProgrammerDay(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ProgrammerDay {
	private int year;

	public ProgrammerDay(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String data = input.lines().collect(Collectors.joining());
			year = Integer.parseInt(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isLeapYear() {
		return year % 400 == 0 ||
				(year % 4 == 0 && year % 100 != 0);
	}

	private String formatYear() {
		String formatYear;
		if (year < 10) {
			formatYear = "000" + year;
		} else if (year < 100) {
			formatYear = "00" + year;
		} else if (year < 1000) {
			formatYear = "0" + year;
		} else {
			formatYear = String.valueOf(year);
		}
		return formatYear;
	}

	@Override
	public String toString() {
		return isLeapYear() ? "12/09/" + formatYear() : "13/09/" + formatYear();
	}
}