package com.yopheu.classes.models;

public class AnimalDto {
	private String name;
	private String anKind;
	private int anAge;
	
	
	public AnimalDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnimalDto(String name, String anKind, int anAge) {
		super();
		this.name = name;
		this.anKind = anKind;
		this.anAge = anAge;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnKind() {
		return anKind;
	}
	public void setAnKind(String anKind) {
		this.anKind = anKind;
	}
	public int getAnAge() {
		return anAge;
	}
	public void setAnAge(int anAge) {
		this.anAge = anAge;
	}
	@Override
	public String toString() {
		return "AnimalDto [name=" + name + ", anKind=" + anKind + ", anAge=" + anAge + "]";
	}
	
	
	
}
