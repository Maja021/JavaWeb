package com.webstore.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {

	private int id;
        
        @NotEmpty(message = "First name can not be left empty")
	private String firstName;
        
        @NotEmpty(message = "Last name can not be left empty")
	private String lastName;
          
        @NotEmpty(message = "E-mail can not be left empty")
        @Email(message = "Bad email input")
	private String email;
        
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
        public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
         public LocalDate getDate() {
            return this.date;
        }
        
         public void setDate(LocalDate date) {
            this.date = date;
        }
        
	@Override
	public String toString(){
		return firstName + " " + lastName + " with email: " + email;
	}
        
        public com.webstore.hibernate.Customer ConvertToDao()
        {
            com.webstore.hibernate.Customer c = new com.webstore.hibernate.Customer();
            
            c.setCustomerId(id);
            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setEmail(email);
            c.setDate(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            
            return c;
        }
}
