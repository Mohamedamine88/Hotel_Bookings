package Entities;

import java.util.Date;

public class Reservation {
	private Date datedebut;
	private Date datefin;
	private Client cli;
	private Chambre cham;
	private int id;
	private static int compteur = 0;
	
	public Reservation(Date datedebut, Date datefin, Client cli, Chambre cham) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.cli = cli;
		this.cham = cham;
		this.id = ++compteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Client getCli() {
		return cli;
	}

	public void setCli(Client cli) {
		this.cli = cli;
	}

	public Chambre getCham() {
		return cham;
	}

	public void setCham(Chambre cham) {
		this.cham = cham;
	}

	@Override
	public String toString() {
		return "Reservation [datedebut=" + datedebut + ", datefin=" + datefin + ", cli=" + cli + ", cham=" + cham + "]";
	}
	

}
