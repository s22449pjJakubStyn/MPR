package pl.edu.pjatk.pjatkwej.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.pjatkwej.Models.Sandwich;

import java.util.List;

@Repository
public interface SandwichRepository extends JpaRepository<Sandwich, Integer> {
   // @Modifying
   // @Query("Update Sandwich s set s.name= :name where s.id= :id")
   // void modifyMe(String name, Integer id);
    List<Sandwich> findAllByIdLessThanEqual(Integer id);
    //List<Sandwich> findAll();
}
