
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
	
	public static void main(String[] args) {
		
		System.out.println( "Bienvenue chez Barette!");
		
		String[] tableauCompetencesKevin = new String[]{"Java","C#","javascript"};
		String[] tableauCompetencesCharles = new String[] {"Java","C#","javascript"};
		CV cvKevin = new CV( "Abou Serhal", "Kevin", "Techniques en informatique", 1, tableauCompetencesKevin, "Aucune attente" );
		CV cvCharles = new CV( "Allard", "Charles-Olivier", "Technique en informatique", 1, tableauCompetencesCharles, "Réussir le cours");
	}
}
