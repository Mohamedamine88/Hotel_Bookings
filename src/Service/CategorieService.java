package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import Entities.Categorie;
import IDAO.IDAO;

public class CategorieService implements IDAO<Categorie>{

	@Override
	public boolean create(Categorie o) {
		String req = "insert into categorie values (null,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getCode());
			ps.setString(2, o.getLibelle());
			if (ps.executeUpdate()==1) {
				System.out.println("Requete insert SQL réussie.");
				return true;
			}
		} catch (SQLException e){
			System.out.println("Erreur de requete insert SQL.");
		}
		return false;
	}

	@Override
	public boolean update(Categorie o) {
		String req = "update categorie set code = ?, libelle = ? where id = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getCode());
			ps.setString(2, o.getLibelle());
			ps.setInt(3, o.getId());
			if (ps.executeUpdate()==1) {
				System.out.println("Requete update SQL réussie.");
				return true;
			}
		} catch (SQLException e){
			System.out.println("Erreur de requete update SQL.");
		}
		return false;
	}

	@Override
	public boolean delete(Categorie o) {
		String req = "delete from categorie where categorie.id = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setInt(1, o.getId());
			if (ps.executeUpdate()==1) {
				System.out.println("Requete delete SQL réussie.");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur de requete delete SQL.");
		}
		return false;
	}

	@Override
	public Categorie findById(int id) {
		String req = "select * from categorie where id = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Requete findById SQL réussie.");
				return new Categorie(rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("Erreur de findById SQL.");
		}
		return null;
	}

	@Override
	public List<Categorie> findAll() {
		String req = "select * from categorie";
		List<Categorie> ls = new ArrayList<>();
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Categorie(rs.getString(2), rs.getString(3)));
			}
			return ls;
		} catch (SQLException e) {
			System.out.println("Erreur de findAll SQL.");
		}
		return null;
	}

}
