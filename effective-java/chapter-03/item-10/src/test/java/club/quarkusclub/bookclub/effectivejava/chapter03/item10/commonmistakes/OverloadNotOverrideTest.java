package club.quarkusclub.bookclub.effectivejava.chapter03.item10.commonmistakes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Common mistake: overloading instead of overriding")
class OverloadNotOverrideTest {

    @Test
    @DisplayName("called directly, with a known static type, the overload works")
    void calledDirectlyWithKnownStaticTypeItWorks() {
        OverloadNotOverride a = new OverloadNotOverride("A1");
        OverloadNotOverride b = new OverloadNotOverride("A1");

        assertThat(a.equals(b)).isTrue();
    }

    @Test
    @DisplayName("inside a List, contains() uses equals(Object) - the overload is never called")
    void insideACollectionTheOverloadIsNeverCalled() {
        OverloadNotOverride a = new OverloadNotOverride("A1");
        OverloadNotOverride equalButDifferentInstance = new OverloadNotOverride("A1");

        List<OverloadNotOverride> list = new ArrayList<>();
        list.add(a);

        assertThat(list.contains(equalButDifferentInstance))
                .as("List.contains dispatches to equals(Object), which is still Object's")
                .isFalse();
    }
}
