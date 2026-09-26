package club.quarkusclub.bookclub.effectivejava.chapter03.item10.recipe;

import club.quarkusclub.bookclub.effectivejava.chapter03.item10.support.Messages;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The payoff for following the recipe: a CDI-managed, application-scoped registry that uses
 * {@link PhoneNumber} as a map key. This only behaves correctly - lookups finding entries inserted
 * under an {@code equal} instance, not just the {@code same} one - because {@code equals} and
 * {@code hashCode} agree on the contract.
 */
@ApplicationScoped
public class PhoneBookRegistry {

    private final Map<PhoneNumber, String> ownerByNumber = new ConcurrentHashMap<>();

    public void register(PhoneNumber number, String owner) {
        ownerByNumber.put(number, owner);
        Log.infof(Messages.get("recipe.phoneBook.registered"), number, owner);
    }

    public Optional<String> lookup(PhoneNumber number) {
        Optional<String> owner = Optional.ofNullable(ownerByNumber.get(number));
        Log.infof(Messages.get("recipe.phoneBook.lookup"), number, owner.orElse("?"));
        return owner;
    }

    public int size() {
        return ownerByNumber.size();
    }
}
