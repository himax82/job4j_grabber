package gc;

public class User {

    private String name;
    private int age;
    private boolean haveChild;

    public User() {
    }

    public User(String name, int age, boolean haveChild) {
        this.name = name;
        this.age = age;
        this.haveChild = haveChild;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s %b%n", age, name, haveChild);
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
        this.age = age;
    }

    public boolean isHaveChild() {
        return haveChild;
    }

    public void setHaveChild(boolean haveChild) {
        this.haveChild = haveChild;
    }
}
