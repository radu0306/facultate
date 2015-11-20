package hello;

public class Persoana {

    private  long id;
    private String nume;
	public Persoana(long id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }
    
    public void setName(String name ){
  	  this.nume = name; 
    }
}	