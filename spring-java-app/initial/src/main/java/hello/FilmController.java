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
public class FilmController {
  private List<Film> film = new ArrayList<Film>();

  FilmController() {
    Film f1 = new Film(1, "DieHard", "actiune", 25);
    Film f2 = new Film(2, "SkyFall", "actiune", 40);
    Film f3 = new Film(3, "Pianistul", "drama", 20);

    film.add(f1);
    film.add(f2);
    film.add(f3);
  }

  @RequestMapping(value="/film", method = RequestMethod.GET)
  public List<Film> index() {
    return this.film;
  }

@RequestMapping(value="/film/{nume}/{categorie}/{pret}", method = RequestMethod.POST)
 public ResponseEntity create(@RequestBody Film f) {
	film.add(f);
	
   return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/film/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Film f : this.film) {
      if(f.getId() == id) {
        return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/film/{id}/{nume}/{categorie}/{pret}", method = RequestMethod.PUT)
  public List<Film> update(@PathVariable("id") int id,@PathVariable("nume") String nume,@PathVariable("categorie") String cat,@PathVariable("pret") int pret ){
    for(Film f : this.film){
      if(f.getId() == id){
		  f.setNume(nume);
		  f.setCat(cat);
		  f.setPret(pret);
      }
    }
    return this.film;
  }
  
  @RequestMapping(value="/film/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Film f : this.film) {
      if(f.getId() == id) {
        this.film.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
