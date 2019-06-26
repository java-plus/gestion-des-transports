package fr.diginamic.model;


/**
 * Enum�ration représentant le statut d'un vehicule ("En Service","en réparation" ou
 * "hors service")
 * 
 * @author Diginamic02
 *
 */

public enum StatutVehicule {

	EN_SERVICE(1, "En Service"), EN_REPARATION(2, "en réparation"), HORS_SERVICE(3, "hors service");

	private String statutVehicule;
	private Integer codeStatutVehicule;

	/**
	 * Constructeur de l'objet StatutVehicule
	 * 
	 * @param statutVehicule statut du v�hicule
	 * @param codeStatutVehicule code du statut du v�hicule
	 */
	private StatutVehicule(Integer codeStatutVehicule, String statutVehicule) {
		this.statutVehicule = statutVehicule;
		this.codeStatutVehicule = codeStatutVehicule;
	}

}
