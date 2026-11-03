package club.quarkusclub.bookclub.effectivejava.chapter03.item13.inheritance;

public class Animal implements Cloneable{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public Animal clone() {
        return new Animal(this.name);
    }
}
