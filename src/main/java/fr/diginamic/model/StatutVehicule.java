package fr.diginamic.model;

/** Enumération des statuts d'un véhicule */
public enum StatutVehicule {

	EN_SERVICE(1, "En Service"), EN_REPARATION(2, "en rÃ©paration"), HORS_SERVICE(3, "hors service");

	private String statutVehicule;
	private Integer codeStatutVehicule;

	/**
	 * Constructeur
	 * 
	 * @param statutVehicule statut du véhicule
	 * @param codeStatutVehicule code du statut du véhicule
	 */
	private StatutVehicule(Integer codeStatutVehicule, String statutVehicule) {
		this.statutVehicule = statutVehicule;
		this.codeStatutVehicule = codeStatutVehicule;
	}

}
