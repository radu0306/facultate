package hello;

public class Produs {

    private  long id;
    private  String nume;
	private  String categorie;
	private  Boolean stoc;
	
	public Produs(long id, String nume, String categorie, Boolean stoc) {
		this.id = id;
        this.nume = nume;
		this.categorie= categorie;
		this.stoc = stoc;
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
	
	public Boolean getStoc() {
        return stoc;
    }
	public void setName(String n){
		nume=n;
	}
	public void setCat(String c){
		categorie=c;
	}
	public void setStoc(Boolean s){
		stoc=s;
	}
}	