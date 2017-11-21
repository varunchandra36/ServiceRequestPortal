package com.varun.business;

import java.io.Serializable;

public class Service implements Serializable{
	  private long id;
	    private String requestTitle;
	    private String requestedByEmail;
	    private String requestedByName;
	    private String brand;
	    private String type;
		private long dateRequested;
	    private String requestDescription;
	    private String requestStatus;
	    private String update;
	    
	    public String getUpdate() {
	    
			return update;
		}
		public void setUpdate(String update) {
			this.update = update;
		}
		@Override
	    public String toString() {
	        return "Service{" + "id=" + id + ", requestTitle=" + requestTitle + ", requestedByEmail=" + requestedByEmail + ", requestedByName=" + requestedByName + ", brand=" + brand + ", dateRequested=" + dateRequested + ", requestDescription=" + requestDescription + ", requestStatus=" + requestStatus + '}';
	    }
		public long getId() {
			return id;
		}
		public long getDateRequested() {
			return dateRequested;
		}
		public void setDateRequested(long dateRequested) {
			this.dateRequested = dateRequested;
		}
		public String getRequestDescription() {
			return requestDescription;
		}
		public void setRequestDescription(String requestDescription) {
			this.requestDescription = requestDescription;
		}
		public String getRequestStatus() {
			return requestStatus;
		}
		public void setRequestStatus(String requestStatus) {
			this.requestStatus = requestStatus;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getRequestTitle() {
			return requestTitle;
		}
		public void setRequestTitle(String requestTitle) {
			this.requestTitle = requestTitle;
		}
		public String getRequestedByEmail() {
			return requestedByEmail;
		}
		public void setRequestedByEmail(String requestedByEmail) {
			this.requestedByEmail = requestedByEmail;
		}
		public String getRequestedByName() {
			return requestedByName;
		}
		public void setRequestedByName(String requestedByName) {
			this.requestedByName = requestedByName;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		 

}
