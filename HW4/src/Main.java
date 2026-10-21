import user.*;
import auto.*;
import zoo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Mykola", 25));
        users.add(new User("Anna", 19));
        users.add(new User("Bohdan", 32));
        users.add(new User("Ira", 28));
        users.add(new User("Volodymyr", 21));


        //Users sorting
        System.out.println("===================================================");
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u1.getAge(), u2.getAge());
            }
        });
        System.out.println("Age ascend: " + users);

        users.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u2.getAge(), u1.getAge());
            }
        });
        System.out.println("Age descend: " + users);

        users.sort((u1, u2) -> Integer.compare(u1.getName().length(), u2.getName().length()));
        System.out.println("Name length ascend: " + users);

        users.sort((u1, u2) -> Integer.compare(u2.getName().length(), u1.getName().length()));
        System.out.println("Name length descend: " + users);
        System.out.println("===================================================");


        List<Skill> s1 = new ArrayList<>();
        s1.add(new Skill("java", 10));

        List<Skill> s2 = new ArrayList<>();
        s2.add(new Skill("java", 2));
        s2.add(new Skill("js", 3));

        List<Skill> s3 = new ArrayList<>();
        s3.add(new Skill("c++", 5));
        s3.add(new Skill("go", 1));
        s3.add(new Skill("python", 4));

        Car defaultCar = new Car("toyota", 2021, 250);

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Vasya", "Kovalenko", "user1@gmail.com", 31, Gender.MALE, s3, defaultCar));
        userList.add(new User(2, "Olha", "Moroz", "user2@gmail.com", 25, Gender.FEMALE, s1, defaultCar));
        userList.add(new User(3, "Andrii", "Shcherbakov", "user3@gmail.com", 29, Gender.MALE, s2, defaultCar));
        userList.add(new User(4, "Tamara", "Koval", "user4@gmail.com", 22, Gender.FEMALE, s3, defaultCar));
        userList.add(new User(5, "Petro", "Karasenko", "user5@gmail.com", 40, Gender.MALE, s1, defaultCar));
        userList.add(new User(6, "Anna", "Boiko", "user6@gmail.com", 27, Gender.FEMALE, s2, defaultCar));
        userList.add(new User(7, "Taras", "Klymenko", "user7@gmail.com", 35, Gender.MALE, s2, defaultCar));
        userList.add(new User(8, "Oleksandra", "Tkach", "user8@gmail.com", 30, Gender.FEMALE, s1, defaultCar));
        userList.add(new User(9, "Max", "Voitovych", "user9@gmail.com", 33, Gender.MALE, s3, defaultCar));
        userList.add(new User(10, "Yulia", "Bondarenko", "user10@gmail.com", 24, Gender.FEMALE, s2, defaultCar));

        //HashSet
        Set<User> hashSet = new HashSet<>(userList);
        Iterator<User> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.getGender() == Gender.MALE) {
                iterator.remove();
            }
        }
        System.out.println("HashSet without men:");
        for (User u : hashSet) {
            System.out.println(u);
        }
        System.out.println("===================================================");

        //TreeSet
        Set<User> treeSet = new TreeSet<>((u1, u2) -> {
            int res = Integer.compare(u1.getSkills().size(), u2.getSkills().size());
            if (res == 0) {
                return Integer.compare(u1.getId(), u2.getId());
            }
            return res;
        });
        treeSet.addAll(userList);
        System.out.println("TreeSet sort by skills:");
        for (User u : treeSet) {
            System.out.println(u);
        }
        System.out.println("===================================================");



        ZooClub zoo = new ZooClub();
        Person p1 = new Person(1, "Liubomyr");
        Person p2 = new Person(2, "Yana");

        Pet cat = new Pet(101, "Murchyk", "Cat");
        Pet dog = new Pet(102, "Sharyk", "Dog");
        Pet parrot = new Pet(103, "Kesha", "Parrot");

        zoo.addPerson(p1);
        zoo.addPerson(p2);

        zoo.addPetToPerson(p1, cat);
        zoo.addPetToPerson(p1, dog);
        zoo.addPetToPerson(p2, dog);
        zoo.addPetToPerson(p2, parrot);

        System.out.println("ZooClub before:");
        zoo.printClub();
        System.out.println("\n");

        zoo.removePetFromPerson(p1, cat);
        System.out.println("Removing cat from Liubomyr:");
        zoo.printClub();
        System.out.println("\n");

        zoo.removePetFromAll(dog);
        System.out.println("Removing dogs:");
        zoo.printClub();
        System.out.println("\n");

        zoo.removePerson(p2);
        System.out.println("Removing Yana:");
        zoo.printClub();
        System.out.println("===================================================");


        //Words
        List<String> words1 = new ArrayList<>(Arrays.asList(
                "apple", "tesla", "often", "grown", "connector",
                "drow", "bark", "run", "limbo", "pineapple",
                "chainmail", "berries", "crafting", "distinguished", "accomplish", "veil"
        ));
        Collections.sort(words1);
        System.out.println("Words sorted by alphabet: " + words1);

        List<String> words2 = new ArrayList<>(Arrays.asList(
                "home", "sun", "cat", "forest", "november",
                "tea", "get", "raw", "window", "table",
                "phone", "night", "log", "town", "river", "sea"
        ));

        List<String> filteredWords = words2.stream()
                .filter(w -> w.length() >= 4)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Words with more than 4 letters: " + filteredWords);
        System.out.println("===================================================");


        //Numbers
        int[] numbers = {12, 5, 9, 30, 45, 7, 20, 18, 10, 3, 21, 100, 15, 8, 90, 4, 60, 2, 33, 50};

        int[] sortedNumbers = Arrays.stream(numbers).sorted().toArray();
        System.out.println("Sorted: " + Arrays.toString(sortedNumbers));

        int[] divBy3 = Arrays.stream(numbers).filter(n -> n % 3 == 0).toArray();
        System.out.println("Divided by 3: " + Arrays.toString(divBy3));

        int[] divBy10 = Arrays.stream(numbers).filter(n -> n % 10 == 0).toArray();
        System.out.println("Divided by 10: " + Arrays.toString(divBy10));

        System.out.print("ForEach: ");
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
        System.out.println();

        int[] multiplied = Arrays.stream(numbers).map(n -> n * 3).toArray();
        System.out.println("Map * 3: " + Arrays.toString(multiplied));
        System.out.println("===================================================");


        //Cars
        List<Automobile> cars = new ArrayList<>();
        cars.add(new Automobile("Audi", 200, new Driver("Ivan", 28, 3), 15000, 2018));
        cars.add(new Automobile("BMW", 300, new Driver("Roman", 24, 2), 22000, 2020));
        cars.add(new Automobile("Mercedes", 250, new Driver("Serhii", 35, 4), 19000, 2019));
        cars.add(new Automobile("Toyota", 150, new Driver("Natasha", 26, 1), 12000, 2017));
        cars.add(new Automobile("Honda", 140, new Driver("Vasya", 40, 15), 9000, 2015));
        cars.add(new Automobile("Tesla", 180, new Driver("Klym", 29, 6), 14000, 2018));
        cars.add(new Automobile("Volvo", 220, new Driver("Dmytro", 27, 4), 17000, 2019));
        cars.add(new Automobile("Skoda", 130, new Driver("Evhenii", 22, 3), 8500, 2016));
        System.out.println("Cars:");
        cars.forEach(System.out::println);
        System.out.println("===================================================");

        int half = cars.size() / 2;
        cars.stream()
                .limit(half)
                .forEach(c -> c.setPower((int) (c.getPower() * 1.10)));
        System.out.println("Cars after tuning:");
        cars.forEach(System.out::println);
        System.out.println("===================================================");


        System.out.println("Experience test:");
        cars.stream()
                .map(Automobile::getDriver)
                .filter(d -> d.getExperience() < 5 && d.getAge() > 25)
                .forEach(d -> d.setExperience(d.getExperience() + 1));
        cars.stream().map(Automobile::getDriver).forEach(System.out::println);
        System.out.println("===================================================");


        int totalSum = cars.stream()
                .mapToInt(Automobile::getPrice)
                .sum();
        System.out.println("Overall cars prices: " + totalSum);
    }
}