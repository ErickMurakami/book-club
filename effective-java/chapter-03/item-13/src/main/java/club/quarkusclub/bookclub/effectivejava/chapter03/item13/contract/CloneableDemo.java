package club.quarkusclub.bookclub.effectivejava.chapter03.item13.contract;

public final class CloneableDemo {
    public interface Describable {
        String describe();
    }

    public static final class MarkerOnly implements Cloneable {
    }

    public static Object unsupportedCopy() throws CloneNotSupportedException {
        return new CloneableDemo().clone();
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Describable description = () -> "Book Club";
        System.out.println("Mixin operation: " + description.describe());
        System.out.println("Cloneable methods: " + Cloneable.class.getDeclaredMethods().length);
        var method = Object.class.getDeclaredMethod("clone");
        System.out.println("Object.clone accessible: " + method.canAccess(new MarkerOnly()));
        System.out.println("Module permits opening: " + method.trySetAccessible());
        try {
            unsupportedCopy();
        } catch (CloneNotSupportedException expected) {
            System.out.println("Without Cloneable: " + expected.getClass().getSimpleName());
        }
    }
}
