package org.vaadin.hezamu.jsftest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@SessionScoped
public class PersonBean {
	private final List<Person> personList;

	private Person selectedPerson;
	private String fname, lname, email, phone;

	public PersonBean() {
		personList = new ArrayList<Person>();

		for (int i = 0; i < 10; i++) {
			personList.add(PersonFactory.createRandomPerson(i));
		}
	}

	public void newPerson() {
		int id = new Random().nextInt(); // Do not try this at home

		Person newPerson = PersonFactory.createRandomPerson(id);
		personList.add(newPerson);
		selectedPerson = newPerson;

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"New person added"));
	}

	public void cancelForm() {
		selectedPerson = null;
	}

	public void savePerson() {
		if (selectedPerson != null) {
			selectedPerson.setfname(fname);
			selectedPerson.setlname(lname);
			selectedPerson.setPhone(phone);
			selectedPerson.setEmail(email);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Person saved"));
		}
	}

	public void deletePerson() {
		if (selectedPerson != null) {
			personList.remove(selectedPerson);
			selectedPerson = null;

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "",
							"Person deleted"));
		}
	}

	public void onRowSelect(SelectEvent event) {
		selectedPerson = (Person) event.getObject();
	}

	public void onRowUnselect(UnselectEvent event) {
		selectedPerson = null;
	}

	public boolean getPersonSelected() {
		return selectedPerson != null;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person person) {
	}

	public String getFname() {
		return selectedPerson != null ? selectedPerson.getfname() : "";
	}

	public String getLname() {
		return selectedPerson != null ? selectedPerson.getlname() : "";
	}

	public String getEmail() {
		return selectedPerson != null ? selectedPerson.getEmail() : "";
	}

	public String getPhone() {
		return selectedPerson != null ? selectedPerson.getPhone() : "";
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}