package club.quarkusclub.bookclub.effectivejava.chapter03.item10.support;

import java.util.ResourceBundle;

/**
 * Log message templates for the demo classes, kept out of the Java source so a live run's
 * narration can be tuned without recompiling.
 * <p>
 * Returns the raw, un-substituted pattern: callers pass it straight to {@code Log.debugf}/
 * {@code infof}/{@code warnf}, whose {@code %s}-style placeholders those patterns are written in,
 * so the formatting args go directly to the JBoss logging call, not through this method.
 */
public final class Messages {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages");

    private Messages() {
    }

    public static String get(String key) {
        return BUNDLE.getString(key);
    }
}
