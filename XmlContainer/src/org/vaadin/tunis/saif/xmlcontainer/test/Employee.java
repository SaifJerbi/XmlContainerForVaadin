package org.vaadin.tunis.saif.xmlcontainer.test;

public class Employee{
		 private String firstName;
		 private String lastName;
		 private String location;

		  public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		@Override
		  public String toString() {
		    return firstName+" "+lastName+" "+location;
		  }
		}
