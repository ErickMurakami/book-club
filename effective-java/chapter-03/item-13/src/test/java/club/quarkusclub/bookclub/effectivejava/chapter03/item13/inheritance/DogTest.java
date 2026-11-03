package club.quarkusclub.bookclub.effectivejava.chapter03.item13.inheritance;

import org.junit.jupiter.api.Test;

public class DogTest {
    @Test
    void testDogClone() {
        Dog originalDog = new Dog("Buddy", "Golden Retriever");
        Dog clonedDog = originalDog.clone();

        assert originalDog != clonedDog; // Ensure they are different instances
        assert originalDog.getClass() == clonedDog.getClass(); // Ensure they are of the same class
    }
}
