package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MANACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Manaccount.findAll", query="SELECT m FROM Manaccount m")
public class Manaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long accountid;

	private String accounttype;

	private String active;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	@Temporal(TemporalType.DATE)
	private Date moddate;

	//bi-directional many-to-one association to Manuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Manuser manuser;

	//bi-directional many-to-one association to Mantransaction
	@OneToMany(mappedBy="manaccount")
	private List<Mantransaction> mantransactions;

	public Manaccount() {
	}

	public long getAccountid() {
		return this.accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public String getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModdate() {
		return this.moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}

	public Manuser getManuser() {
		return this.manuser;
	}

	public void setManuser(Manuser manuser) {
		this.manuser = manuser;
	}

	public List<Mantransaction> getMantransactions() {
		return this.mantransactions;
	}

	public void setMantransactions(List<Mantransaction> mantransactions) {
		this.mantransactions = mantransactions;
	}

	public Mantransaction addMantransaction(Mantransaction mantransaction) {
		getMantransactions().add(mantransaction);
		mantransaction.setManaccount(this);

		return mantransaction;
	}

	public Mantransaction removeMantransaction(Mantransaction mantransaction) {
		getMantransactions().remove(mantransaction);
		mantransaction.setManaccount(null);

		return mantransaction;
	}

}