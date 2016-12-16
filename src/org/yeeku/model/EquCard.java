package org.yeeku.model;

public class EquCard {
	
	private int serialID;
	private String cardNO;
	private String emplID;
	private String emplName;
	
	public String getEmplID() {
		return emplID;
	}
	public int getSerialID() {
		return serialID;
	}
	public void setSerialID(int serialID) {
		this.serialID = serialID;
	}
	public void setEmplID(String emplID) {
		this.emplID = emplID;
	}
	public String getCardNO() {
		return cardNO;
	}
	public void setCardNO(String cardNO) {
		this.cardNO = cardNO;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}

}
