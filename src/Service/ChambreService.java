package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import Entities.Chambre;
import IDAO.IDAO;

public class ChambreService implements IDAO<Chambre>{

	@Override
	public boolean create(Chambre o) {
		String req = "insert into chambre values (null,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getTelephone());
			ps.setInt(2, o.getCat().getId());
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
	public boolean update(Chambre o) {
		String req = "update chambre set tel = ? where id = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getTelephone());
			ps.setInt(2, o.getCat().getId());
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
	public boolean delete(Chambre o) {
		String req = "delete from chambre where chambre.id = ?";
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
	public Chambre findById(int id) {
		String req = "select * from chambre where id = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Requete findById SQL réussie.");
				return new Chambre(rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("Erreur de findById SQL.");
		}
		return null;
	}

	@Override
	public List<Chambre> findAll() {
		String req = "select * from chambre";
		List<Chambre> ls = new ArrayList<>();
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Chambre(rs.getString(2)));
			}
			return ls;
		} catch (SQLException e) {
			System.out.println("Erreur de findAll SQL.");
		}
		return null;
	}

}
