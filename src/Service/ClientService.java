package Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import Entities.Client;

import IDAO.IDAO;

public class ClientService implements IDAO<Client> {

	@Override
	public boolean create(Client o) {
		String req = "insert into client (nom, prenom, tel, email) values (?,?,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTelephone());
			ps.setString(4, o.getEmail());
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
	public boolean update(Client o) {
		String req = "update client set nom = ?, penom = ?, tel = ?, email = ? where id = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTelephone());
			ps.setString(4, o.getEmail());
			ps.setInt(5, o.getId());
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
	public boolean delete(Client o) {
		String req = "delete from client where client.id = ?";
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
	public Client findById(int id) {
		String req = "select * from client where id = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Requete findById SQL réussie.");
				return new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Erreur de findById SQL.");
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		String req = "select * from client";
		List<Client> ls = new ArrayList<>();
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			return ls;
		} catch (SQLException e) {
			System.out.println("Erreur de findAll SQL.");
		}
		return null;
	}
	

}
