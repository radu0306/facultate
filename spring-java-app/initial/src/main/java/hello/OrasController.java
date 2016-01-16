package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class OrasController {
  private List<Oras> oras = new ArrayList<Oras>();

  OrasController() {
    Oras o1 = new Oras(1, "pitesti", "arges", 100000);
    Oras o2 = new Oras(2, "bucuresti", "bucuresti", 1500000);
    Oras o3 = new Oras(3, "mioveni", "arges", 25000);

    oras.add(o1);
    oras.add(o2);
    oras.add(o3);
  }

  @RequestMapping(value="/oras", method = RequestMethod.GET)
  public List<Oras> index() {
    return this.oras;
  }

@RequestMapping(value="/oras/{nume}/{judet}/{loc}", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Persoana p) {
	oras.add(o);
	
    return this.oras;
  }

  @RequestMapping(value="/oras/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Oras o : this.oras) {
      if(o.getId() == id) {
        return new ResponseEntity<Oras>(o, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/oras/{id}/{nume}/{judet}/{loc}", method = RequestMethod.PUT)
  public List<Oras> update(@PathVariable("id") int id,@PathVariable("nume") String nume,@PathVariable("judet") String jud,@PathVariable("loc") int loc ){
    for(Oras o : this.oras){
      if(o.getId() == id){
		  o.setNume(nume);
		  o.setJud(jud);
		  o.setLoc(loc);
      }
    }
    return this.oras;
  }
  
  @RequestMapping(value="/oras/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Oras o : this.oras) {
      if(o.getId() == id) {
        this.oras.remove(o);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}