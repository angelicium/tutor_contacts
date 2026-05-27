public class Contact extends Person {
    private int number;

    public Contact(String name, int age, int number) {
        super(name, age);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                super.toString() +
                "number=" + number +
                '}';
    }
}
