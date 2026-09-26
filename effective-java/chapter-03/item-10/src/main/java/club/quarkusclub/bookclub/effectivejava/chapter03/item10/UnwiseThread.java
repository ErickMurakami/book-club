package club.quarkusclub.bookclub.effectivejava.chapter03.item10;

/**
 * Overriding {@code equals} on {@link Thread} is the book's opening warning: threads are
 * inherently unique, active entities, not value objects. Making every thread equal to every other
 * thread is exactly the kind of "why would anyone do this" example that earns its place first.
 */
public class UnwiseThread extends Thread {

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
