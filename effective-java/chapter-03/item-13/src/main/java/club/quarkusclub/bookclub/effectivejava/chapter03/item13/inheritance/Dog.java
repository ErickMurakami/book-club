package club.quarkusclub.bookclub.effectivejava.chapter03.item13.inheritance;

public class Dog extends Animal implements Cloneable {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public Dog clone() {
        try{
        return (Dog) super.clone();
        } catch (Exception e) {
            throw new AssertionError(e);
        }

    }
}
