package com.training.beans;

public class ClientDocument {
	private int id;
	private String username;
	private String adharcard;
	private String pancard;
	private String voterid;
	
	public ClientDocument() {
		super();
	}

	public ClientDocument(int id, String username, String adharcard, String pancard, String voterid) {
		super();
		this.id = id;
		this.username = username;
		this.adharcard = adharcard;
		this.pancard = pancard;
		this.voterid = voterid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdharcard() {
		return adharcard;
	}

	public void setAdharcard(String adharcard) {
		this.adharcard = adharcard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getVoterid() {
		return voterid;
	}

	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}

	@Override
	public String toString() {
		return "ClientDocument [id=" + id + ", username=" + username + ", adharcard=" + adharcard + ", pancard="
				+ pancard + ", voterid=" + voterid + "]";
	}
	
	
	
	
	
}
