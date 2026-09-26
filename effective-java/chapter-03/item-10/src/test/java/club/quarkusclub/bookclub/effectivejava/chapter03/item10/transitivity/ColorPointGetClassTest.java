package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Attempt C: getClass() instead of instanceof")
class ColorPointGetClassTest {

    @Test
    @DisplayName("still asymmetric against the plain superclass, which IS the Liskov violation")
    void stillAsymmetricAgainstThePlainSuperclass() {
        Point p = new Point(1, 2);
        ColorPointGetClass cp = new ColorPointGetClass(1, 2, Color.RED);

        assertThat(cp.equals(p)).as("cp requires getClass() equality, p is a plain Point - false").isFalse();
        assertThat(p.equals(cp))
                .as("p never switched to getClass(): its own instanceof still accepts cp - true")
                .isTrue();
    }
}
