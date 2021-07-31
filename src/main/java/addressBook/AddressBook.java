package addressBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 * Purpose : adding data from contact.java
 */

public class AddressBook {
	static AddressBook addressbook = new AddressBook();

	public boolean addContact(ArrayList<Contact> contact) {
		try {
			if (addressbook.readFile(contact)) {
				System.out.println("person is added in file");
			}
			return true;
		} catch (IOException e) {
			System.out.println("person not added in file");
		}
		return false;
	}

	/*
	 * Purpose : Using IO File read data from file
	 */
	public boolean readFile(ArrayList<Contact> contact) throws IOException {
		String HOME = System.getProperty("user.home");
		String fileName = "AddressBookdata.txt";
		Path homePath = Paths.get(HOME);
		if (Files.exists(homePath)) {
			Path filePath = Paths.get(HOME + "/" + fileName);
			try {
				if (Files.exists(filePath)) {
					if (WriteFile(new File(fileName), contact)) {
						return true;
					}
				} else {
					Files.createFile(filePath);
					if (WriteFile(new File(fileName), contact)) {
						return true;
					}
				}
				return true;
			} catch (IOException e) {
				return false;
			}
		}
		return false;
	}

	/*
	 * Purpose : Using IO File write data to file
	 */
	private boolean WriteFile(File fileName, ArrayList<Contact> contact) {
		try {
			FileWriter myWriter = new FileWriter(fileName);
			for (Contact contactperson : contact) {
				myWriter.write(contactperson + "\n");
			}
			myWriter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
