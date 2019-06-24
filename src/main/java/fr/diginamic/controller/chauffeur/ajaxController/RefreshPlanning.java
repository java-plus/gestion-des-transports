package fr.diginamic.controller.chauffeur.ajaxController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.diginamic.dao.ResaVehiculeDao;
import fr.diginamic.model.Employe;
import fr.diginamic.model.ReservationVoiture;

@WebServlet(urlPatterns = "/controller/chauffeur/refreshPlanning/*")
public class RefreshPlanning extends HttpServlet {

	public RefreshPlanning() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String date = req.getParameter("date");
		String demande = req.getParameter("demande");
		LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if (demande.equals("precedent")) {
			localDate = localDate.minusDays(1);
		} else if (demande.equals("suivant")) {
			localDate = localDate.plusDays(1);
		}

		Integer idChauffeur = ((Employe) req.getSession(false).getAttribute("utilisateur")).getId();

		ResaVehiculeDao resaVehiculeDao = new ResaVehiculeDao();
		List<ReservationVoiture> listeResa = resaVehiculeDao.recupererLesTachesDuJourCourant(localDate, idChauffeur);
		traitementReservation(listeResa, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		resp.getWriter().write(gson.toJson(listeResa));
	}

	private List<ReservationVoiture> traitementReservation(List<ReservationVoiture> listeResa,
			LocalDate jourCourant) {
		supprimerDemandeCreneauxIndisponible(listeResa);
		LocalDateTime debutJour = LocalDateTime.of(jourCourant, LocalTime.parse("00:00:00"));
		LocalDateTime finJour = LocalDateTime.of(jourCourant, LocalTime.parse("23:59:59"));

		for (ReservationVoiture resaVoiture : listeResa) {
			LocalDateTime debutResa = resaVoiture.getDateTimeDeDebut();
			LocalDateTime finResa = resaVoiture.getDateTimeDeFin();

			if (debutResa.isBefore(debutJour) && finResa.isBefore(finJour)) {

				LocalDateTime d = resaVoiture.getDateTimeDeDebut();
				resaVoiture.setDateTimeDeDebut(LocalDateTime.of(d.getYear(), d.getMonth(), d.getDayOfMonth(), 0,
						0));

			} else if (debutResa.isAfter(debutJour) && finResa.isAfter(finJour)) {
				LocalDateTime f = resaVoiture.getDateTimeDeFin();
				resaVoiture.setDateTimeDeFin(LocalDateTime.of(f.getYear(), f.getMonth(), f.getDayOfMonth(), 23,
						59));
			} else if (debutResa.isBefore(debutJour) && finResa.isAfter(finJour)) {
				LocalDateTime d = resaVoiture.getDateTimeDeDebut();
				LocalDateTime f = resaVoiture.getDateTimeDeFin();

				resaVoiture.setDateTimeDeDebut(LocalDateTime.of(d.getYear(), d.getMonth(), d.getDayOfMonth(), 0,
						0));
				resaVoiture.setDateTimeDeFin(LocalDateTime.of(f.getYear(), f.getMonth(), f.getDayOfMonth(), 23,
						59));
			}
		}
		return listeResa;
	}

	private void supprimerDemandeCreneauxIndisponible(List<ReservationVoiture> listeResa) {
		Iterator<ReservationVoiture> it = listeResa.iterator();
		while (it.hasNext()) {
			ReservationVoiture resa = it.next();
			if (resa.getBesoinChauffeur().equals(1)) {
				for (ReservationVoiture reservationAComparer : listeResa) {
					boolean commenceDedans = (resa.getDateTimeDeDebut().isAfter(reservationAComparer
							.getDateTimeDeDebut()) && resa.getDateTimeDeDebut().isBefore(reservationAComparer
									.getDateTimeDeFin()));
					boolean finiDedans = (resa.getDateTimeDeFin().isAfter(reservationAComparer.getDateTimeDeDebut())
							&& resa.getDateTimeDeFin().isBefore(reservationAComparer.getDateTimeDeFin()));
					if (commenceDedans || finiDedans) {
						it.remove();
					}
				}
			}
		}
	}

}
