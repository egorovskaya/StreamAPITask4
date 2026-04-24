import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream()
                .filter(x -> x.getAge() >= 18)
                .count();
        System.out.println(count);

        List<String> stream = persons.stream()
                .filter(x -> x.getSex().equals("MAN"))
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() <= 27)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());

        for (String s : stream) {
            System.out.println(s);
        }
        


        Collection<Person> streamWorkers = persons.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x -> (x.getSex().equals("MAN") && x.getAge() <= 65) || (x.getSex().equals("WOMEN") && x.getAge() <= 60))
                .filter(x -> x.getEducation().equals("HIGHER"))
                .sorted(Comparator.comparing(x -> x.getFamily()))
                .collect(Collectors.toList());
        System.out.println(streamWorkers);


    }
}
