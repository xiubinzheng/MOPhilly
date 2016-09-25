package com.xiubinzheng.domain;

public class ValuationHistory {
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	public double getTaxableLand() {
		return taxableLand;
	}
	public void setTaxableLand(double taxableLand) {
		this.taxableLand = taxableLand;
	}
	public double getTaxableImprovement() {
		return taxableImprovement;
	}
	public void setTaxableImprovement(double taxableImprovement) {
		this.taxableImprovement = taxableImprovement;
	}
	public double getExemptLand() {
		return exemptLand;
	}
	public void setExemptLand(double exemptLand) {
		this.exemptLand = exemptLand;
	}
	public double getExemptImprovement() {
		return exemptImprovement;
	}
	public void setExemptImprovement(double exemptImprovement) {
		this.exemptImprovement = exemptImprovement;
	}
	private int year;
	private double marketValue;
	private double taxableLand;
	private double taxableImprovement;
	private double exemptLand;
	private double exemptImprovement;
	
	
	
}
