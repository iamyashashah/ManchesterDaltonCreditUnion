package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MANTRANSACTION database table.
 * 
 */
@Entity
@NamedQuery(name="Mantransaction.findAll", query="SELECT m FROM Mantransaction m")
public class Mantransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long transid;

	private double amount;

	@Temporal(TemporalType.DATE)
	private Date transdate;

	private String transtype;

	//bi-directional many-to-one association to Manaccount
	@ManyToOne
	@JoinColumn(name="ACCOUNTID")
	private Manaccount manaccount;

	public Mantransaction() {
	}

	public long getTransid() {
		return this.transid;
	}

	public void setTransid(long transid) {
		this.transid = transid;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransdate() {
		return this.transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public String getTranstype() {
		return this.transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public Manaccount getManaccount() {
		return this.manaccount;
	}

	public void setManaccount(Manaccount manaccount) {
		this.manaccount = manaccount;
	}

}