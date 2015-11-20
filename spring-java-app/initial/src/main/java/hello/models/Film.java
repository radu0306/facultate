package hello;

public class Film{

	private  long id;
	private  String nume;
	private  String categorie;
	private  int pret;
	
	public Film(long id, String nume, String categorie, int pret) {
		this.id = id;
	    this.nume = nume;
		this.categorie= categorie;
		this.pret = pret;
	}
	
	public long getId() {
	    return id;
	}
	
	public String getNume() {
	    return nume;
	}
	
	public String getCategorie() {
	    return categorie;
	}
	
	public int getPret() {
	    return pret;
	}
	public void setNume(String n){
		nume=n;
	}
	public void setCat(String c){
		categorie=c;
	}
	public void setPret(int p){
		pret=p;
	}
}	