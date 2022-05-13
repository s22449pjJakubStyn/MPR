package pl.edu.pjatk.pjatkwej;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjatk.pjatkwej.Models.Ingredient;
import pl.edu.pjatk.pjatkwej.Models.Sandwich;
import pl.edu.pjatk.pjatkwej.Models.SandwichSize;
import pl.edu.pjatk.pjatkwej.Repositories.SandwichRepository;
import pl.edu.pjatk.pjatkwej.Services.SandwichService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SandwichServiceTest {

    @Mock
    private SandwichRepository sandwichRepository;
    @InjectMocks
    private SandwichService sandwichService;
    @Test
    void shouldTestName() {
        //GIVEN
        Sandwich sandwich= new Sandwich(null, "testName", 100, 20.0, null, SandwichSize.KING_SIZE);
        //WHEN
        sandwichService.changeName(sandwich);
        //THEN
        Assertions.assertThat(sandwich.getName()).isEqualTo("testNameABC");
    }
    @Test
    void shouldTestName_Null() {
        Sandwich sandwich= new Sandwich(null, null, 200, 30.0, null, SandwichSize.BIG);
        sandwichService.changeName(sandwich);
        Assertions.assertThat(sandwich.getName()).isEqualTo(null);
    }
    @Test
    void shouldChangeSandwichPriceByTen() {
        //GIVEN
        Sandwich sandwich = new Sandwich(null, "poor", 100, 0.9, null, SandwichSize.SMALL);
        //WHEN
        sandwichService.changePrice(sandwich);
        //THEN
        Assertions.assertThat(sandwich.getBasePrice()).isEqualTo(10.9);
    }
    @Test
    void shouldNotChangeSandwichPriceByTen() {
        Sandwich sandwich = new Sandwich(null, "poor", 100, 1.0, null, SandwichSize.BIG);
        sandwichService.changePrice(sandwich);
        Assertions.assertThat(sandwich.getBasePrice()).isEqualTo(1.0);
    }
    @Test
    void shouldChangeSandwichSize() {
        Sandwich sandwich = new Sandwich(null, "poor", 100, 3.0, null, SandwichSize.SMALL);
        sandwichService.changeSize(sandwich, SandwichSize.SMALL);
        Assertions.assertThat(sandwich.getSize()).isEqualTo(SandwichSize.BIG);
    }
    @Test
    void shouldNotChangeSandwichSize() {
        Sandwich sandwich = new Sandwich(null, "poor", 100, 3.0, null, SandwichSize.BIG);
        sandwichService.changeSize(sandwich, SandwichSize.BIG);
        Assertions.assertThat(sandwich.getSize()).isEqualTo(SandwichSize.BIG);
    }
    @Test
    void shouldCalculatePrice() {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient bread = new Ingredient(null, "white", 50, 5.0);
        Sandwich sandwich = new Sandwich(null, "POOR", 100, 1.0, List.of(bread), SandwichSize.SMALL);
        sandwichService.calculatePrice(sandwich);
        Assertions.assertThat(sandwich.getBasePrice()).isEqualTo(6.0);
    }
   /* @Test
    void shouldAddIngredientToSandwich() {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient bread = new Ingredient(null, "white", 100, 5.0);
        Sandwich sandwich = new Sandwich(null, "poor", 100, 1.0, List.of(bread), SandwichSize.MEDIUM);
        sandwichService.addIngredient(sandwich, bread);
        Assertions.assertThat(sandwich.getIngredients()).isEqualTo(bread);
    }

    */
    @Test
    void shouldNotAddIngredientToSandwich() {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient bread = new Ingredient(null, "white", 100, 5.0);
        Sandwich sandwich = new Sandwich(null, "poor", 100, 1.0, null, SandwichSize.MEDIUM);
        sandwichService.addIngredient(sandwich, bread);
        Assertions.assertThat(sandwich.getIngredients()).isEqualTo(null);
    }
    @Test
    void shouldChangeCalories(){
        Sandwich sandwich = new Sandwich(null, "poor", 100, 3.0, null, SandwichSize.BIG);
        sandwichService.changeCalories(sandwich);
        Assertions.assertThat(sandwich.getBaseCalories()).isEqualTo(0);
    }
    @Test
    void shouldnOTChangeCalories(){
        Sandwich sandwich = new Sandwich(null, "poor", 0, 3.0, null, SandwichSize.BIG);
        sandwichService.changeCalories(sandwich);
        Assertions.assertThat(sandwich.getBaseCalories()).isEqualTo(0);
    }
    @Test
    void shouldFindById(){
        int id=1;
        when(sandwichRepository.findById(any())).thenReturn(Optional.of(new Sandwich()));
        Sandwich byId=sandwichService.findById(id);
        Assertions.assertThat(byId).isNotNull();
    }
    @Test
    void shouldNotFindById(){
        int id=1;
        when(sandwichRepository.findById(any())).thenReturn(Optional.empty());
        Sandwich byId=sandwichService.findById(id);
        Assertions.assertThat(byId).isNull();
    }
    @Test
    void shouldFindAll(){
        when(sandwichRepository.findAll()).thenReturn(List.of(new Sandwich(), new Sandwich()));
        List<Sandwich> allElements= sandwichService.findAll();
        Assertions.assertThat(allElements).hasSize(2);
    }
    @Test
    void shouldNotFindAll(){
        when(sandwichRepository.findAll()).thenReturn(List.of());
        List<Sandwich> allElements= sandwichService.findAll();
        Assertions.assertThat(allElements).hasSize(0);
    }
    @Test
    void shouldExistById() {
        when(sandwichRepository.existsById(any())).thenReturn(true);
        Sandwich kanapka= new Sandwich(1,"poor", 100, 2.0, null,SandwichSize.SMALL);
        Boolean byId=sandwichService.existsById(kanapka);
        Assertions.assertThat(byId).isNotNull();
    }
    @Test
    void shouldNotExistById() {
        when(sandwichRepository.existsById(any())).thenReturn(false);
        Sandwich kanapka= new Sandwich(null,"poor", 100, 2.0, null,SandwichSize.SMALL);
        Boolean byId=sandwichService.existsById(kanapka);
        Assertions.assertThat(byId).isNull();
    }


}
