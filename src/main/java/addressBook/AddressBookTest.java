package addressBook;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
	AddressBook addressBook = new AddressBook();
	ArrayList<Contact> contact = new ArrayList<Contact>();

	@Test
	public void whenPersonDetails_Added_ShouldReturn_True() {
		Contact person = new Contact("pranav", "dani", "ddd", "pune", "Maharastra", "@gmail.com",
				8089987898L, 64011);
		contact.add(person);
		System.out.println(contact.toString());
		boolean result = addressBook.addContact(contact);
		Assert.assertTrue(result);
	}
}
	
	

	