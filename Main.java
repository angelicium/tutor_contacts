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
        switch (choice) {
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
        for (Person contact : contacts) {
            if (contact instanceof Contact && !(contact instanceof Worker)) {
                System.out.println(contact);
            }
        }
    }

    private static void printWorkers() {
        for (Person contact : contacts) {
            if (contact instanceof Worker) {
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
        switch (contactType) {
            case 2:
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Введите email");
                workEmail = scanner3.nextLine();
            case 1:
                System.out.println("Введите номер телефона");
                number = scanner2.nextInt();
                break;
        }
        Person newContact = contactType == 1 ? new Contact(name, age, number) : new Worker(name, age, number, workEmail);

        contacts.add(newContact);
        read();
    }

    private static void update() {

        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст, нечего обновлять");
            return;

        }
        System.out.println("Выберите айди контакта, который хотите обновить");
        System.out.println(contacts);
        Scanner scanner = new Scanner(System.in);
        Long contantId = scanner.nextLong();
        scanner.nextLine();
        if (contantId < 1 || contantId > Person.getLastId()) {
            System.out.println("Неверный айди контакта");
            return;
        }
        Person person = findContactById(contantId);

        if (person instanceof Worker) {
            Worker worker = (Worker) person;
            System.out.println("Введите новое имя работника");
            String newName = scanner.nextLine();
            System.out.println("Введите новый возраст работника");
            int newAge = scanner.nextInt();
            System.out.println("Введите новый номер телефона работника");
            int newNumber = scanner.nextInt();
            Scanner s = new Scanner(System.in);
            System.out.println("Введите новый мейл работника");
            String newEmail = s.nextLine();
            worker.setName(newName);
            worker.setAge(newAge);
            worker.setNumber(newNumber);
            worker.setWorkEmail(newEmail);
        } else {
            Contact contact = (Contact) person;
            System.out.println("Введите новое имя контакта");
            String newName = scanner.nextLine();
            System.out.println("Введите новый возраст контакта");
            int newAge = scanner.nextInt();
            System.out.println("Введите новый номер телефона контакта");
            int newNumber = scanner.nextInt();
            contact.setName(newName);
            contact.setAge(newAge);
            contact.setNumber(newNumber);
        }
        System.out.println(contacts);

    }

    private static void delete() {
        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст, нечего удалять");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Выберите айди контакта, который хотите удалить");
            System.out.println(contacts);

            Long id = scanner.nextLong();
            if (id < 1 || id > Person.getLastId()) {
                System.out.println("Неверный айди контакта");
                continue;
            }
            deleteContactById(id);
            System.out.println(contacts);
            return;
        } while (true);

    }

    private static Person findContactById(Long id) {
        for (Person contact : contacts) {
            if (contact.getId().equals(id))
                return contact;
        }
        return null;
    }

    private static void deleteContactById(Long id) {
        for (int i = 0; i < contacts.size(); i++) {
            Person person = contacts.get(i);
            if (person != null && person.getId().equals(id)) {
                contacts.remove(i);
                return;
            }
        }
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
