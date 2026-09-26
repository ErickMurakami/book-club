package club.quarkusclub.bookclub.effectivejava.chapter03.item10.nonnullity;

import club.quarkusclub.bookclub.effectivejava.chapter03.item10.support.Messages;
import io.quarkus.logging.Log;
import java.util.Objects;

/**
 * {@code instanceof} already returns {@code false} when its left operand is {@code null},
 * whatever the right operand names (JLS 15.20.2). The type check below is therefore also the
 * null check: no explicit {@code if (o == null)} is needed before it.
 */
public class Ticket {

    private final String code;

    public Ticket(String code) {
        this.code = Objects.requireNonNull(code);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ticket other)) {
            Log.debugf(Messages.get("nonnullity.ticket.rejectedByInstanceof"), code, o);
            return false;
        }
        return other.code.equals(code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
