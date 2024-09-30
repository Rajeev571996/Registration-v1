public class Employee{



    private long id;
    private String name;
    private int sal;

    public long getId() {
        return id;
    }

    public int getSal() {
        return sal;
    }

    public String getName() {
        return name;
    }

    public Employee(long id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;


    }
}

