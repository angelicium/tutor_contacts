public class Person {
    private static Long lastId = 1L;
    private Long id;

    private String name;

private int age;

public Person(String name, int age) {
    this.name = name;
    this.age = age;

    this.id = lastId++;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <= 100)
            this.age = age;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
