package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MANUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Manuser.findAll", query="SELECT m FROM Manuser m")
public class Manuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String employee;

	private String password;

	private String username;

	//bi-directional many-to-one association to Manaccount
	@OneToMany(mappedBy="manuser")
	private List<Manaccount> manaccounts;

	public Manuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEmployee() {
		return this.employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Manaccount> getManaccounts() {
		return this.manaccounts;
	}

	public void setManaccounts(List<Manaccount> manaccounts) {
		this.manaccounts = manaccounts;
	}

	public Manaccount addManaccount(Manaccount manaccount) {
		getManaccounts().add(manaccount);
		manaccount.setManuser(this);

		return manaccount;
	}

	public Manaccount removeManaccount(Manaccount manaccount) {
		getManaccounts().remove(manaccount);
		manaccount.setManuser(null);

		return manaccount;
	}

}