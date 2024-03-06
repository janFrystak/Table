public class Customer {
    private static int nextId = 1;
    private final int id;
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name) {
        this.id = nextId++;
        this.name = name;
    }
}
