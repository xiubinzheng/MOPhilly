package com.xiubinzheng.domain;

import java.util.Date;

/**
 * NOTE: vacant land types, 
 * VACANT LAND RESIDE < ACRE
 * NON PD PKG LOT COMMERCIAL
 * RES CONDO 5+ STY MAS+OTH
* */

public class property {
		private String description;
		private int landArea;
		private String propertyAddress;
		private ValuationHistory valuationHistory;
		private double salesPrice;
		private Date salesDate;
		private int opaAccount;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getLandArea() {
			return landArea;
		}
		public void setLandArea(int landArea) {
			this.landArea = landArea;
		}
		public String getPropertyAddress() {
			return propertyAddress;
		}
		public void setPropertyAddress(String propertyAddress) {
			this.propertyAddress = propertyAddress;
		}
		public ValuationHistory getValuationHistory() {
			return valuationHistory;
		}
		public void setValuationHistory(ValuationHistory valuationHistory) {
			this.valuationHistory = valuationHistory;
		}
		public double getSalesPrice() {
			return salesPrice;
		}
		public void setSalesPrice(double salesPrice) {
			this.salesPrice = salesPrice;
		}
		public Date getSalesDate() {
			return salesDate;
		}
		public void setSalesDate(Date salesDate) {
			this.salesDate = salesDate;
		}
		public int getOpaAccount() {
			return opaAccount;
		}
		public void setOpaAccount(int opaAccount) {
			this.opaAccount = opaAccount;
		}
		
	
}
