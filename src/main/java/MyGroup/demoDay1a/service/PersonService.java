package MyGroup.demoDay1a.service;

import org.springframework.stereotype.Service;

import java.util.*;

import MyGroup.demoDay1a.model.Person;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<Person>();

    public PersonService(){
        persons.add(new Person("Richard", "Lee"));
        persons.add(new Person("Robert", "Lim"));
    }

    public List<Person> getPersons(){
        return this.persons;
    }

    public void addPerson(Person newPerson){
        persons.add(new Person(newPerson.getFirstName(), newPerson.getLastName()));
    }

    public void removePerson(Person personToDelete){
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personToDelete.getId())).findAny().orElse(null);
        persons.remove(foundPerson);
    }

    public void updatePerson(Person personToUpdate){
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personToUpdate.getId())).findAny().orElse(null);
        
        Person updatePerson = new Person();
        updatePerson.setId(personToUpdate.getId());
        updatePerson.setFirstName(personToUpdate.getFirstName());
        updatePerson.setLastName(personToUpdate.getLastName());
        persons.remove(foundPerson);
        persons.add(updatePerson);
    }
}
