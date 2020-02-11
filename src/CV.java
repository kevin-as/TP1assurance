
public class CV {

	String nom;
	String prenom;
	String formation;
	int experienceTravail;
	String[] competences;
	String attentes;
	
	public CV(String pNom, String pPrenom, String pFormation, int pExperienceTravail, 
			String[] pCompetences, String pAttentes) {
		
		nom = pNom;
		prenom = pPrenom;
		formation = pFormation;
		experienceTravail = pExperienceTravail;
		competences = pCompetences;
		attentes = pAttentes;
		
	}
	
	public void setNom( String pNom ) {
		nom = pNom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPrenom( String pPrenom ) {
		prenom = pPrenom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setFormation( String pFormation ) {
		formation = pFormation;
	}
	
	public String getFormation() {
		return formation;
	}
	
	public void setExperienceTravail( int pExperienceTravail ) {
		experienceTravail = pExperienceTravail;
	}
	
	public int getExperienceTravail() {
		return experienceTravail;
	}
	
	public void setCompetences( String[] pCompetences ) {
		competences = pCompetences;
	}
	
	public String[] getCompetences() {
		return competences;
	}
	
	public void setAttentes( String pAttentes ) {
		attentes = pAttentes;
	}
	
	public String getAttentes() {
		return attentes;
	}
	public static void accueil() {
		
		System.out.println( "Bienvenue chez Barette!");
		
		String[] tableauCompetencesKevin = new String[]{"Java","C#","javascript"};
		String[] tableauCompetencesCharles = new String[] {"Java","C#","javascript"};
		CV cvKevin = new CV( "Abou Serhal", "Kevin", "Techniques en informatique", 1, tableauCompetencesKevin, "Aucune attente" );
		CV cvCharles = new CV( "Allard", "Charles-Olivier", "Technique en informatique", 1, tableauCompetencesCharles, "Réussir le cours");
		
		afficher( cvKevin );
		afficher( cvCharles );
	}
	
	public static void afficher( CV cv ) {
		
		System.out.println("\nAffichage d'un CV\n");
		System.out.println("Nom : " + cv.getNom());
		System.out.println("Prenom : " + cv.getPrenom());
		System.out.println("Formation : " + cv.getFormation());
		System.out.println("Expériences de travail : " + cv.getExperienceTravail() + " année(s)");
		System.out.print("Competences : ");
		
		for (int i = 0; i < cv.getCompetences().length; i++) {
			System.out.print(cv.getCompetences()[i]);
			if (i < cv.getCompetences().length - 1) {
				System.out.print(", ");
			}
		}
		
		System.out.println("\nAttentes : " + cv.getAttentes());
		
	}
}
