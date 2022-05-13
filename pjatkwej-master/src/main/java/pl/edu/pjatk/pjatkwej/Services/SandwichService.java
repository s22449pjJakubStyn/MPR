package pl.edu.pjatk.pjatkwej.Services;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.pjatkwej.Models.Ingredient;
import pl.edu.pjatk.pjatkwej.Models.Sandwich;
import pl.edu.pjatk.pjatkwej.Models.SandwichSize;
import pl.edu.pjatk.pjatkwej.Repositories.SandwichRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SandwichService {

    private final SandwichRepository sandwichRepository;

    public SandwichService(SandwichRepository sandwichRepository){
        this.sandwichRepository = sandwichRepository;

    }

    public Sandwich getExampleSandwich(){
        Ingredient bread = new Ingredient(null, "white bread", 100, 5.0d);
        return new Sandwich(null, "poor", 100, 5.0d, List.of(bread), SandwichSize.KING_SIZE);
    }

    public Sandwich prepareSandwich(){
        Ingredient bread = new Ingredient(null, "black bread", 1500, 50.0d);
        return new Sandwich(null, "poor", 1550, 54.0d, List.of(bread), SandwichSize.SMALL);
    }

    public Sandwich prepareSandwich(String sandwichName){
        Ingredient bread = new Ingredient(null, "black bread", 1500, 50.0d);
        Sandwich sandwich = new Sandwich(15, "test", 1550, 54.0d, List.of(bread), SandwichSize.SMALL);

        return sandwichRepository.save(sandwich);
    }

    public List<Sandwich> getTopFive(){

        return sandwichRepository.findAllByIdLessThanEqual(5);
    }
    public Sandwich findById(Integer id) {
        Optional<Sandwich> byId= sandwichRepository.findById(id);
        return byId.orElse(null);
    }
    public List<Sandwich> findAll() {
        List<Sandwich> allElements= sandwichRepository.findAll();
        return allElements;
    }
    public void deleteById(Sandwich sandwich) {
        sandwichRepository.deleteById(sandwich.getId());
    }
    public Boolean existsById(Sandwich sandwich) {
        Boolean byId = sandwichRepository.existsById(sandwich.getId());
        return byId;
    }

    public void addIngredient(Sandwich sandwich, Ingredient ingredient) {
        if(sandwich.getIngredients()!= null) {
            sandwich.getIngredients().add(ingredient);
        }
    }

    public void changeName(Sandwich sandwich) {
        if(sandwich.getName() !=null) {
            sandwich.setName(sandwich.getName()+"ABC");
        }
    }

    public void changePrice(Sandwich sandwich) {
        if(sandwich.getBasePrice() !=0) {
            sandwich.setBasePrice(sandwich.getBasePrice()+10);
        }
    }

  public void changeCalories(Sandwich sandwich) {
        if(sandwich.getBaseCalories() ==0) {
            sandwich.setBaseCalories(sandwich.getBaseCalories()+100);
        }
    }

    public void changeSize(Sandwich sandwich, SandwichSize sandwichSize) {
        if(sandwich.getSize() !=SandwichSize.BIG) {
            sandwich.setSize(SandwichSize.BIG);
        }
    }

    public double calculatePrice(Sandwich sandwich) {
        double finalPrice = sandwich.getBasePrice();
        for(Ingredient ingredient: sandwich.getIngredients()) {
            finalPrice+=ingredient.getPrice();
        }
        return finalPrice;
    }

}
