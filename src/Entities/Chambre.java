package Entities;

public class Chambre {
	private int id;
	private String telephone;
	private static int compteur = 0;
	private Categorie cat;
	
	public Chambre(String telephone) {
		super();
		this.id = ++compteur;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Chambre [id=" + id + ", telephone=" + telephone + ", cat=" + cat + "]";
	}
	
	

}
