package org.vaadin.hezamu.jsftest;

import java.util.Random;

public class PersonFactory {
	public static Person createRandomPerson(int id) {
		/* Create dummy data by randomly combining first and last names */
		String[] fnames = { "Peter", "Alice", "Joshua", "Mike", "Olivia",
				"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene",
				"Lisa", "Marge" };
		String[] lnames = { "Smith", "Gordon", "Simpson", "Brown", "Clavel",
				"Simons", "Verne", "Scott", "Allison", "Gates", "Rowling",
				"Barks", "Ross", "Schneider", "Tate" };
		String[] domains = { "gmail", "google", "vaadin", "yahoo", "itmill",
				"hotmail" };

		Random r = new Random();

		String fname = fnames[r.nextInt(fnames.length)];
		String lname = lnames[r.nextInt(lnames.length)];
		String domain = domains[r.nextInt(domains.length)];

		return new Person("" + id, fname, lname, "" + r.nextInt(),
				String.format("%s.%s@%s.com", fname, lname, domain));
	}
}
