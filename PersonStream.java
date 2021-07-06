import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonStream {
    public static ArrayList<Person> people = new ArrayList<>(List.of(
        new Person("Vinh", "Vietnam", 28),
        new Person("Lan", "Vietnam", 24), 
        new Person("John", "USA", 27), 
        new Person("Lee", "China", 67),
        new Person("Kim", "Korea", 22), 
        new Person("Long", "Vietnam", 18), 
        new Person("Jungho", "Korea", 19),
        new Person("Tian", "China", 20), 
        new Person("Clara", "USA", 40), 
        new Person("Mikura", "Japan", 27),
        new Person("Sony", "Japan", 29), 
        new Person("Xiang", "China", 78), 
        new Person("Peter", "France", 18),
        new Person("Haloy", "Malaysia", 20), 
        new Person("Magie", "Malaysia", 32)));

    public static void AgeFilter() {
        List<Person> FilterByAge = people
        .stream()
        .filter(p -> p.getAge() >= 20 && p.getAge() <= 30)
        .collect(Collectors.toList());
        System.out.println("Danh sach nguoi co do tuoi tu 20-30 tuoi: ");
        System.out.println(FilterByAge);
        System.out.println("----------");
    }

    public static void averageAge() {
        Double averageAge = people
        .stream()
        .collect(Collectors.averagingInt(Person::getAge));
        System.out.print("Tuoi trung binh la: ");
        System.out.println(averageAge);
        System.out.println("----------");
    }

    public static void averageAgeOfNationality() {
        Map<String, Double> average = people
        .stream()
        .collect(Collectors.groupingBy(Person::getNationality, Collectors.averagingInt(Person::getAge)));
        System.out.println("Do tuoi trung binh theo tung quoc tich: ");
        System.out.println(average);

    }

    public static void main(String[] args) {
        AgeFilter();
        averageAge();
        averageAgeOfNationality();

    }
}
