package com.project.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User {
		 
		@Id  
		private String emailID;
		private String name;
		private String password;
		private String mobile;
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
		private Character role;
		private String registeredDate;
}
