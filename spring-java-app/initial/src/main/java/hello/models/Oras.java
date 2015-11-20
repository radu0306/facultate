package hello;

public class Oras {
	 
		private  long id;
	    private String nume,judet;
	    private int locuitori;
		public Oras(long id, String nume, String judet, int loc) {
	        this.id = id;
	        this.nume = nume;
	        this.judet=judet;
	        this.locuitori=loc;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(int id){
	    	this.id=id;
	    }
	    public void setNume(String nume){
	    	this.nume=nume;
	    }
	    public void setJud(String jud){
	    	this.judet=jud;
	    }
	    public void setLoc(int loc){
	    	this.locuitori=loc;
	    }
	    public String getNume() {
	        return nume;
	    }
	    public String getJudet() {
	        return judet;
	    }
	    public int getLoc() {
	        return locuitori;
	    }

}	
