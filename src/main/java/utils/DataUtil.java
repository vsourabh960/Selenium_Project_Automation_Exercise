package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to read test data from CSV files
 * CSV format: key1,key2,key3
 *             value1,value2,value3
 */
public class DataUtil {
	
	/**
	 * Reads CSV file and returns list of maps with header-value pairs
	 * @param fileName Name of the CSV file (without path)
	 * @return List of maps containing test data
	 */
	public static List<Map<String, String>> readTestDataFromCSV(String fileName) {
		List<Map<String, String>> testData = new ArrayList<>();
		
		try {
			// Construct path to test data directory
			Path filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testdata", fileName);
			
			BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()));
			String headerLine = reader.readLine();
			
			if (headerLine == null) {
				reader.close();
				return testData;
			}
			
			String[] headers = headerLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			String line;
			
			while ((line = reader.readLine()) != null) {
				if (line.trim().isEmpty()) continue; // Skip empty lines
				
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				Map<String, String> dataMap = new HashMap<>();
				
				for (int i = 0; i < headers.length; i++) {
					String value = (i < values.length) ? values[i].replaceAll("\"", "") : "";
					dataMap.put(headers[i].trim(), value.trim());
				}
				
				testData.add(dataMap);
			}
			
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Failed to read test data from: " + fileName, e);
		}
		
		return testData;
	}
}
