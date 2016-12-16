package org.yeeku.model;

public class Right implements java.io.Serializable{
	
	private String rightcode;
	private String parentcode;
	private String righttype;
	private String righttext;
	private String righturl;
	private String righttip;
	private Integer index;
	
	private Integer ischecked;
	
	public String getRightcode() {
		return rightcode;
	}
	public void setRightcode(String rightcode) {
		this.rightcode = rightcode;
	}
	public String getParentcode() {
		return parentcode;
	}
	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}
	public String getRighttype() {
		return righttype;
	}
	public void setRighttype(String righttype) {
		this.righttype = righttype;
	}
	public String getRighttext() {
		return righttext;
	}
	public void setRighttext(String righttext) {
		this.righttext = righttext;
	}
	public String getRighturl() {
		return righturl;
	}
	public void setRighturl(String righturl) {
		this.righturl = righturl;
	}
	public String getRighttip() {
		return righttip;
	}
	public void setRighttip(String righttip) {
		this.righttip = righttip;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getIschecked() {
		return ischecked;
	}
	public void setIschecked(Integer ischecked) {
		this.ischecked = ischecked;
	}
}
