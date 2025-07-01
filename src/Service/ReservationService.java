package Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import Entities.Categorie;
import Entities.Chambre;
import Entities.Client;
import Entities.Reservation;
import IDAO.IDAO;

public class ReservationService implements IDAO<Reservation>{

	@Override
	public boolean create(Reservation o) {
		String req = "insert into reservation values (?,?,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setDate(1, (Date) o.getDatedebut());
			ps.setDate(2, (Date) o.getDatefin());
			ps.setInt(3, o.getCli().getId());
			ps.setInt(4, o.getCham().getId());
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
	public boolean update(Reservation o) {
		String req = "update reservation set datedebut = ?, datefin = ? where id_client = ? and id_chambre = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setDate(1, (Date) o.getDatedebut());
			ps.setDate(2, (Date) o.getDatefin());
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
	public boolean delete(Reservation o) {
		String req = "delete reservation where id_client = ? and id_chambre = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			  ps.setInt(1, o.getCli().getId());
	          ps.setInt(2, o.getCham().getId());
			if (ps.executeUpdate()==1) {
				System.out.println("Requete delete SQL réussie.");
				return true;
			}
		} catch (SQLException e){
			System.out.println("Erreur de requete delete SQL.");
		}
		return false;
	}

	@Override
	public Reservation findById(int id) {
		try {
            String query = "select * from reservation where id=?";
            PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClientService clientService = new ClientService();
                Client client = clientService.findById(rs.getInt("id_client"));
                ChambreService chambreService = new ChambreService();
                Chambre chambre = chambreService.findById(rs.getInt("id_chambre"));
                return new Reservation(rs.getDate("datedebut"), rs.getDate("datefin"), client, chambre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
	}

	@Override
	public List<Reservation> findAll() {
        List<Reservation> reservations = new ArrayList<>();
        try {
            String query = "select * from reservation";
            PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClientService clientService = new ClientService();
                Client client = clientService.findById(rs.getInt("id_client"));
                ChambreService chambreService = new ChambreService();
                Chambre chambre = chambreService.findById(rs.getInt("id_chambre"));
                if (client != null && chambre != null) {
                    Reservation reservation = new Reservation(rs.getDate("datedebut"), rs.getDate("datefin"), client, chambre);
                    reservations.add(reservation);

                } else {
                    System.out.println("Client ou chambre non trouvé pour la réservation avec l'Id: " + rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    }

}
