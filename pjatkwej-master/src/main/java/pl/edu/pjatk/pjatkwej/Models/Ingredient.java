package pl.edu.pjatk.pjatkwej.Models;

import org.assertj.core.api.Condition;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ingredient")
public class Ingredient extends Condition<List<? extends Ingredient>> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int calories;
    private double price;

    public Ingredient(){

    }

    public Ingredient(Integer id, String name, int calories, double price) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.price = price;
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
