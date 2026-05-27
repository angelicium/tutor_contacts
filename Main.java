import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//    int i = 11;
//    while(i <= 10) {
//        System.out.println(i);
//
//        i++;
//    }
//    int i = 1;
//    do {
//        System.out.println("Do while");
//        System.out.println(i);
//
//        i++;
//    } while(i<=10);


    private static List<Person> contacts = new ArrayList<>() {
        {
            add(
                    new Person(
                            "Daniil",
                            22
                    )
            );
            add(
                    new Person(
                            "Angelica",
                            22
                    )
            );
        }
    }; // List это интерфейс, ArrayList реализует List

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {
            printMenu();

            int decision = sc.nextInt();


            switch (decision) {
                case 1:
                    System.out.println("Read");
                    read();
                    break;
                case 2:
                    System.out.println("Add");
                    add();
                    break;
                case 3:
                    System.out.println("Update");
                    update();
                    break;
                case 4:
                    System.out.println("Delete");
                    delete();
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("?");
            }
        } while (true);

    }

    private static void read() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void add() {
        System.out.println("Введите имя");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Введите возраст");
        Scanner scanner2 = new Scanner(System.in);
        try {
            int age = scanner2.nextInt();
            Person newContact = new Person(name, age);
            contacts.add(newContact);
            read();
        } catch (Exception e) {
            System.out.println("Введите число");
        }
    }

    private static void update() {


        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст, нечего обновлять");
            return;

        }
        System.out.println("Выберите номер контакта, который хотите обновить");
        read();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > contacts.size()) {
            System.out.println("Неверный номер контакта");
            return;
        }
        System.out.println("Введите имя нового контакта");
        String newName = scanner.nextLine();
        System.out.println("Введите возраст нового контакта");
        int newAge = scanner.nextInt();

        Person newContact = new Person(newName, newAge);

        int index = choice - 1;
        contacts.set(index, newContact);

        read();

    }
    private static void delete() {
        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст, нечего удалять");
            return;
    }
        System.out.println("Выберите номер контакта, который хотите удалить");
        read();
        Scanner scanner1 = new Scanner(System.in);
        int choice1 = scanner1.nextInt();
        if (choice1 < 1 || choice1 > contacts.size()) {
            System.out.println("Неверный номер контакта");
            return;
        }
        int index = choice1 - 1;
        contacts.remove(index);
        read();
    }

    private static void printMenu() { // void -- значит ничего не возвращает, а параметры это когда мы
        // извне что-то берем. есть public, private и protected - позволяет принаследовании получить
        //доступ к данным родителя внутри пакета
        System.out.println("___Menu___");
        System.out.println("1. Read");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("0. Exit");

    }
}
