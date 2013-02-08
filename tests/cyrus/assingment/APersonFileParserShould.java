package cyrus.assingment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import cyrus.assignment.Person;
import cyrus.assignment.PersonFileParser;

public class APersonFileParserShould {

	private PersonFileParser fr;

	@Before
	public void init(){
		fr = new PersonFileParser();
	}
	
	@Test
	public void readLinesFromAFile(){
		Collection<String> persons = fr.read("input_files/comma.txt");
		assertTrue(persons.contains("Abercrombie, Neil, Male, Tan, 2/13/1943"));
		assertEquals(persons.size(),3);
	}
	
	@Test
	public void parseCommaFilesToCreatePeople(){
		String expected = 
				"[Abercrombie Neil Male 2/13/1943 Tan,"+
				" Bishop Timothy Male 4/23/1967 Yellow,"+
				" Kelly Sue Female 7/12/1959 Pink]";
		Collection<Person> persons = fr.getPersonInfoFromFile("input_files/comma.txt");
		assertEquals(expected, persons.toString());
	}
		
	@Test 
	public void parsePipeFilesToCreatePeople(){
		String expected = "[Smith Steve Male 3/3/1985 Red,"+
				" Bonk Radek Male 6/3/1975 Green,"+
				" Bouillon Francis Male 6/3/1975 Blue]";
		Collection<Person> persons = fr.getPersonInfoFromFile("input_files/pipe.txt");
		assertEquals(expected, persons.toString());
	}
	
	@Test 
	public void parseSpaceFilesToCreatePeople(){
		String expected = "[Kournikova Anna Female 6/3/1975 Red,"+
				" Hingis Martina Female 4/2/1979 Green,"+
				" Seles Monica Female 12/2/1973 Black]";
		Collection<Person> persons = fr.getPersonInfoFromFile("input_files/space.txt");
		assertEquals(expected, persons.toString());
	}
}
