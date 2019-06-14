package fr.diginamic.model;

public enum StatutVehicule {

	EN_SERVICE(1, "En Service"), EN_REPARATION(2, "en réparation"), HORS_SERVICE(3, "hors service");

	private String statutVehicule;
	private Integer codeStatutVehicule;

	/**
	 * Constructeur
	 * 
	 * @param statutVehicule
	 * @param codeStatutVehicule
	 */
	private StatutVehicule(Integer codeStatutVehicule, String statutVehicule) {
		this.statutVehicule = statutVehicule;
		this.codeStatutVehicule = codeStatutVehicule;
	}

}
