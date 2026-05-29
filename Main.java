import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Person> contacts = new ArrayList<>() {
        {
            add(
                    new Contact(
                            "Daniil",
                            22,
                            891655
                    )
            );
            add(
                    new Worker(
                            "Angelica",
                            22,
                            8915444,
                            "angelica@mail.ru"
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
        System.out.println("1. Все\n2. Контакт\n3. Работники");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                System.out.println(contacts);
                break;
            case 2:
                printContacts();
                break;

            case 3:
                printWorkers();
                break;
        }
    }

    private static void printContacts() {
        for(Person contact : contacts) {
            if(contact instanceof Contact && !(contact instanceof Worker)) {
                System.out.println(contact);
            }
        }
    }

    private static void printWorkers() {
        for(Person contact : contacts) {
            if(contact instanceof Worker) {
                System.out.println(contact);
            }
        }
    }

    private static void add() {
        System.out.println("Кого хотите добавить: 1. Контакт 2. Работник");
        Scanner scanner = new Scanner(System.in);
        int contactType = scanner.nextInt();
        System.out.println("Введите имя");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("Введите возраст");
        Scanner scanner2 = new Scanner(System.in);
        int age = 0;
        int number = 0;
        String workEmail = null;
        try {
            age = scanner2.nextInt();
        } catch (Exception e) {
            System.out.println("Введите число");
        }
        switch(contactType) {
            case 2:
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Введите email");
                workEmail = scanner3.nextLine();
            case 1:
                System.out.println("Введите номер телефона");
                number = scanner2.nextInt();
                break;
        }
        Person newContact = contactType == 1 ? new Contact(name, age, number): new Worker(name, age, number, workEmail);

        contacts.add(newContact);
        read();
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
            System.out.println("Неверн ый номер контакта");
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
        Scanner scanner = new Scanner(System.in);
      do {
          System.out.println("Выберите номер контакта, который хотите удалить");
          read();

          int choice = scanner.nextInt();
          if (choice < 1 || choice > contacts.size()) {
              System.out.println("Неверный номер контакта");
              continue;
          }
          int index = choice - 1;
          contacts.remove(index);
          read();
          return;
      } while(true);

    }

    private static void printMenu() { // void -- значит ничего не возвращает, а параметры это когда мы
        // извне что-то берем. есть public, private и protected - позволяет принаследовании получить
        //доступ к данным родителя внутри пакета
        // static позволяет прикрепить какие-то методы и свойства класса к самому классу

        System.out.println("___Menu___");
        System.out.println("1. Read");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("0. Exit");

    }
}
