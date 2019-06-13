package fr.diginamic.model;

public enum StatutVehicule {

	EN_SERVICE(1, "En Service"), EN_REPARATION(2, "en réparation"), HORS_SERVICE(3, "hors service");

	private String statutVehicule;
	private int codeStatutVehicule;

	/**
	 * Constructeur
	 * 
	 * @param statutVehicule
	 * @param codeStatutVehicule
	 */
	private StatutVehicule(int codeStatutVehicule, String statutVehicule) {
		this.statutVehicule = statutVehicule;
		this.codeStatutVehicule = codeStatutVehicule;
	}

}
