package by.coach.beans;

import java.util.ArrayList;

public class Teacher {

	public Teacher() {

	}

	private long id;
	private int idSkill;
	private String name;
	private String typeOfSkill;
	private byte[] pic;
	private ArrayList<byte[]> sertificates;
	private int experianceAge;
	private int cost;
	private String username;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOfSkill() {
		return typeOfSkill;
	}

	public void setTypeOfSkill(String typeOfSkill) {
		this.typeOfSkill = typeOfSkill;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public ArrayList<byte[]> getSertificates() {
		return sertificates;
	}

	public void setSertificates(ArrayList<byte[]> sertificates) {
		this.sertificates = sertificates;
	}

	public int getExperianceAge() {
		return experianceAge;
	}

	public void setExperianceAge(int experianceAge) {
		this.experianceAge = experianceAge;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return name + " is " + typeOfSkill + " teacher. And has "
				+ experianceAge + " years of experiens!";
	}

}
