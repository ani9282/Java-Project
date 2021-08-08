package com.training.beans;

public class DisplayClientAllData 
{
	private int id;
	private String username;
	private String adharcard;
	private String pancard;
	private String voterid;
	private String panno;
	private String name;
	private String accountno;
	private String accounttype;
	private String ifsc;
	private String bankname;
	private String branchname;
	private String mobile;
	private String file;
	
	public DisplayClientAllData() {
		super();
	}

	public DisplayClientAllData(int id, String username, String adharcard, String pancard, String voterid, String panno,
			String name, String accountno, String accounttype, String ifsc, String bankname, String branchname,
			String mobile, String file) {
		super();
		this.id = id;
		this.username = username;
		this.adharcard = adharcard;
		this.pancard = pancard;
		this.voterid = voterid;
		this.panno = panno;
		this.name = name;
		this.accountno = accountno;
		this.accounttype = accounttype;
		this.ifsc = ifsc;
		this.bankname = bankname;
		this.branchname = branchname;
		this.mobile = mobile;
		this.file = file;
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

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "DisplayClientAllData [id=" + id + ", username=" + username + ", adharcard=" + adharcard + ", pancard="
				+ pancard + ", voterid=" + voterid + ", panno=" + panno + ", name=" + name + ", accountno=" + accountno
				+ ", accounttype=" + accounttype + ", ifsc=" + ifsc + ", bankname=" + bankname + ", branchname="
				+ branchname + ", mobile=" + mobile + ", file=" + file + "]";
	}
	
	
}
