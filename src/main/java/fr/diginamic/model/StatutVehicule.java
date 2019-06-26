package fr.diginamic.model;


/**
 * Enumération reprÃ©sentant le statut d'un vehicule ("En Service","en rÃ©paration" ou
 * "hors service")
 * 
 * @author Diginamic02
 *
 */

public enum StatutVehicule {

	EN_SERVICE(1, "En Service"), EN_REPARATION(2, "en rÃ©paration"), HORS_SERVICE(3, "hors service");

	private String statutVehicule;
	private Integer codeStatutVehicule;

	/**
	 * Constructeur de l'objet StatutVehicule
	 * 
	 * @param statutVehicule statut du véhicule
	 * @param codeStatutVehicule code du statut du véhicule
	 */
	private StatutVehicule(Integer codeStatutVehicule, String statutVehicule) {
		this.statutVehicule = statutVehicule;
		this.codeStatutVehicule = codeStatutVehicule;
	}

}
