package pl.edu.pjatk.pjatkwej.Models;

import pl.edu.pjatk.pjatkwej.Services.SandwichService;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sandwich")
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int baseCalories;
    private double basePrice;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    private SandwichSize size;

    public Sandwich(){

    }

    public Sandwich(Integer id, String name, int baseCalories, double basePrice, List<Ingredient> ingredients, SandwichSize size) {
        this.id = id;
        this.name = name;
        this.baseCalories = baseCalories;
        this.basePrice = basePrice;
        this.ingredients = ingredients;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseCalories() {
        return baseCalories;
    }

    public void setBaseCalories(int baseCalories) {
        this.baseCalories = baseCalories;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }
}
