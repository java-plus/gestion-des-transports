package fr.diginamic.model;

public class Adresse {

	private int numéroDeRue;
	private String rue;
	private String ville;
	private int codePostal;

	/**
	 * Constructeur
	 * 
	 * @param numéroDeRue
	 * @param rue
	 * @param ville
	 * @param codePostal
	 */
	public Adresse(int numéroDeRue, String rue, String ville, int codePostal) {
		super();
		this.numéroDeRue = numéroDeRue;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	/**
	 * @return the numéroDeRue
	 */
	public int getNuméroDeRue() {
		return numéroDeRue;
	}

	/**
	 * Setter
	 * 
	 * @param numéroDeRue
	 *            the numéroDeRue to set
	 */
	public void setNuméroDeRue(int numéroDeRue) {
		this.numéroDeRue = numéroDeRue;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter
	 * 
	 * @param rue
	 *            the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter
	 * 
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter
	 * 
	 * @param codePostal
	 *            the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
}
