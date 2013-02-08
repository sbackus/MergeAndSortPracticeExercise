package cyrus.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class PersonFileParser {

	private ArrayList<Person> persons;
	
	public PersonFileParser(){
		persons = new ArrayList<Person>();
	}
	
	public Collection<String> read(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return lines;
	}

	public ArrayList<Person> getPersonInfoFromFile(String fileName) {
		for (String line : read(fileName)){
			if (line.matches(".*, .*, .*, .*, .*")){
				String[] personData = line.split(", ");
				persons.add(new Person(personData[0],personData[1],personData[2],personData[4],personData[3]));
			}
			else if (line.matches(".* \\| .* \\| .* \\| .* \\| .* \\| .*")){
				String[] personData = line.split(" \\| ");
				persons.add(new Person(personData[0],personData[1],personData[3],personData[5],personData[4]));
			}
			else{
				String[] personData = line.split(" ");
				persons.add(new Person(personData[0],personData[1],personData[3],personData[4],personData[5]));
			}
		}
		return persons;
	}
	
}
