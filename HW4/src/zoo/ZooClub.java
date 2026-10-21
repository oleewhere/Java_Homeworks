package zoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZooClub {
    private Map<Person, List<Pet>> club = new HashMap<>();

    public void addPerson(Person person) {
        if (!club.containsKey(person)) {
            club.put(person, new ArrayList<>());
        }
    }

    public void addPetToPerson(Person person, Pet pet) {
        if (club.containsKey(person)) {
            club.get(person).add(pet);
        }
    }

    public void removePetFromPerson(Person person, Pet pet) {
        if (club.containsKey(person)) {
            club.get(person).remove(pet);
        }
    }

    public void removePerson(Person person) {
        club.remove(person);
    }

    public void removePetFromAll(Pet pet) {
        for (Map.Entry<Person, List<Pet>> entry : club.entrySet()) {
            entry.getValue().remove(pet);
        }
    }

    public void printClub() {
        for (Map.Entry<Person, List<Pet>> entry : club.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}