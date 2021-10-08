package com.em.springdatasqlite.resolvers;

//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.em.springdatasqlite.entity.Animal;
import com.em.springdatasqlite.entity.Person;
import com.em.springdatasqlite.entity.Pet;
import com.em.springdatasqlite.service.PersonService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/22 22:11:04
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Component
public class Query implements GraphQLQueryResolver {
    public List<Pet> pets() {
        List<Pet> pets = new ArrayList<>();

        Pet aPet = new Pet();
        aPet.setId(1L);
        aPet.setName("Covey's cat");
        aPet.setAge(3);
        aPet.setType(Animal.CAT);

        pets.add(aPet);

        return pets;
    }

    public List<Animal> animals() {
        Animal animal = Animal.MAMMOTH;
        Animal animal1 = Animal.BADGER;
        Animal animal2 = Animal.CAT;
        Animal animal3 = Animal.OOOOOO;
        Animal animal4 = Animal.DOG;
        List<Animal> animalList = new ArrayList<>(4);
        animalList.add(animal);
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        return animalList;
    }

    @Resource
    private PersonService personService;

    public List<Person> persons(){
        return personService.query();
    }
}
