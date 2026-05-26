import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Contact> contacts = new ArrayList<>() {
        {
            add(
                    new Contact(
                            "Daniil",
                            22
                    )
            );
            add(
                    new Contact(
                            "Angelica",
                            22
                    )
            );
        }
    }; // List это интерфейс, ArrayList реализует List

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                break;
            case 0:
                return;
                default:
                    System.out.println("?");
        }
            sc.close();

        }

        private static void read() {
        for (Contact contact: contacts)
            System.out.println(contact);

        }

        private static void  add() {
            System.out.println("Введите имя");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Введите возраст");
            Scanner scanner2 = new Scanner(System.in);
            int age = scanner2.nextInt();
            Contact newContact = new Contact(name, age);
            contacts.add(newContact);
            System.out.println(contacts);

        }

        private static void update() {

        Scanner scanner = new Scanner(System.in);
            if(contacts.isEmpty()) {
                System.out.println("Список контактов пуст, нечего обновлять");
            }
            else {
                System.out.println("Выберите номер контакта, который хотите обновить");
                for(int i = 0; i < contacts.size(); i++) {
                    System.out.println((i + 1) + ". " + contacts.get(i));
                }
            int choice = scanner.nextInt();
                scanner.nextLine();
                if(choice < 1 || choice > contacts.size()) {
                    System.out.println("Неверный номер контакта");
                }

                System.out.println("Введите имя нового контакта");
                    String newName = scanner.nextLine();
                    System.out.println("Введите возраст нового контакта");
                    int newAge = scanner.nextInt();

                    Contact newContact = new Contact(newName, newAge);

                    int index = choice - 1;
                    contacts.set(index, newContact);

                    System.out.println(contacts);

            }
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
