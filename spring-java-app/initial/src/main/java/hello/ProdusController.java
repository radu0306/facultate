package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ProdusController {
  private List<Produs> prod = new ArrayList<Produs>();

  ProdusController() {
    Produs p1 = new Produs(1, "Mar", "Fructe", true);
    Produs p2 = new Produs(2, "Ceapa", "Legume", false);
    Produs p3 = new Produs(3, "Televizor", "Electronice", true);

    prod.add(p1);
    prod.add(p2);
    prod.add(p3);
  }

  @RequestMapping(value="/produs", method = RequestMethod.GET)
  public List<Produs> index() {
    return this.prod;
  }

@RequestMapping(value="/produs/{nume}/{categorie}/{stoc}", method = RequestMethod.POST)
 public ResponseEntity create(@RequestBody Produs p) {
	prod.add(p);
	
    return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Produs p : this.prod) {
      if(p.getId() == id) {
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/produs/{id}/{nume}/{categorie}/{stoc}", method = RequestMethod.PUT)
  public List<Produs> update(@PathVariable("id") int id,@PathVariable("nume") String nume,@PathVariable("categorie") String cat,@PathVariable("stoc") Boolean stoc ){
    for(Produs p : this.prod){
      if(p.getId() == id){
		  p.setName(nume);
		  p.setCat(cat);
		  p.setStoc(stoc);
      }
    }
    return this.prod;
  }
  
  @RequestMapping(value="/produs/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Produs p : this.prod) {
      if(p.getId() == id) {
        this.prod.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}