package club.quarkusclub.bookclub.effectivejava.chapter03.item10.commonmistakes;

/**
 * Declares {@code equals(OverloadNotOverride)} instead of {@code equals(Object)}: a strongly-typed
 * sibling method, not an override. The compiler accepts it silently - without {@code @Override} it
 * has no way to know this was meant to replace {@link Object#equals} - but every collection class
 * calls {@code equals(Object)}, so this method is simply never invoked through that path.
 */
public class OverloadNotOverride {

    private final String id;

    public OverloadNotOverride(String id) {
        this.id = id;
    }

    public boolean equals(OverloadNotOverride other) {
        return other != null && other.id.equals(id);
    }
}
