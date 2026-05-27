public class Worker extends Contact{

    private String workEmail;

    public Worker(String name, int age, int number, String workEmail) {
        super(name, age, number);
        this.workEmail = workEmail;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                "workEmail=" + workEmail +
                '}';
    }
}
