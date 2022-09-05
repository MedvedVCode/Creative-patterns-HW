package people;

public class People {
    public static void main(String[] args) {
        Person mama = new PersonBuilder()
                .setName("Таня")
                .setSurname("Бутова")
//                .setAge(31)
                .setAddress("Сидней")
                .build();
        mama.happyBirthday();
        Person son = mama.newChildBuilder()
                .setName("Антошка")
                .build();
        son.happyBirthday();
        System.out.printf("У мамы %s есть сын %s\n", mama, son);
    }
}
