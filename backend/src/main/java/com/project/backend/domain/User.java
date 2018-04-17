package com.project.backend.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user")
public class User {
		 
		@Id  
		private String emailID;
		private String name;
		private String lastName;
		private String password;
		private String Gender;
		private String mobile;
		private Character role;
		private String registeredDate;
		private String dOB;
		
		
		
		public String getdOB() {
			return dOB;
		}
		public void setdOB(String dOB) {
			this.dOB = dOB;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}	
		public String getEmailID() {
			return emailID;
		}
		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public Character getRole() {
			return role;
		}
		public void setRole(Character role) {
			this.role = role;
		}
		public String getRegisteredDate() {
			return registeredDate;
		}
		public void setRegisteredDate(String registeredDate) {
			this.registeredDate = registeredDate;
		}
		
}
