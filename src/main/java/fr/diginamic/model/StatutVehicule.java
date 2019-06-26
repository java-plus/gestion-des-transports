package fr.diginamic.model;

/** Enum�ration des statuts d'un v�hicule */
public enum StatutVehicule {

	EN_SERVICE(1, "En Service"), EN_REPARATION(2, "en réparation"), HORS_SERVICE(3, "hors service");

	private String statutVehicule;
	private Integer codeStatutVehicule;

	/**
	 * Constructeur
	 * 
	 * @param statutVehicule statut du v�hicule
	 * @param codeStatutVehicule code du statut du v�hicule
	 */
	private StatutVehicule(Integer codeStatutVehicule, String statutVehicule) {
		this.statutVehicule = statutVehicule;
		this.codeStatutVehicule = codeStatutVehicule;
	}

}
