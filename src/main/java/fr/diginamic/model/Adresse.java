package fr.diginamic.model;

public class Adresse {

	private Integer numeroDeRue;
	private String rue;
	private String ville;
	private Integer codePostal;

	/**
	 * Constructeur
	 * 
	 * @param numeroDeRue
	 * @param rue
	 * @param ville
	 * @param codePostal
	 */
	public Adresse(Integer numeroDeRue, String rue, String ville, Integer codePostal) {
		super();
		this.numeroDeRue = numeroDeRue;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	/**
	 * @return the numéroDeRue
	 */
	public Integer getNumeroDeRue() {
		return numeroDeRue;
	}

	/**
	 * Setter
	 * 
	 * @param numeroDeRue the numéroDeRue to set
	 */
	public void setNumeroDeRue(Integer numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
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
	 * @param rue the rue to set
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
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter
	 * 
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
}
