package club.quarkusclub.bookclub.effectivejava.chapter03.item10.reflexivity;

/**
 * Deliberately has no {@code equals} override: the inherited {@link Object#equals} already
 * satisfies reflexivity ({@code x.equals(x)}), which is nearly impossible to break by accident.
 */
public class Player {

    public final String nickname;

    public Player(String nickname) {
        this.nickname = nickname;
    }
}
