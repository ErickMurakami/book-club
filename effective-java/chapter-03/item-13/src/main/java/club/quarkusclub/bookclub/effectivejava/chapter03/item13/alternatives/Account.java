package club.quarkusclub.bookclub.effectivejava.chapter03.item13.alternatives;

import java.util.ArrayList;
import java.util.List;

public final class Account {
    private final List<String> labels;

    public Account(List<String> labels) {
        this.labels = new ArrayList<>(labels);
    }

    public Account(Account source) {
        this(source.labels);
    }

    public static Account copyOf(Account source) {
        return new Account(source);
    }

    public void addLabel(String label) {
        labels.add(label);
    }

    public List<String> labels() {
        return List.copyOf(labels);
    }

    public static void main(String[] args) {
        var original = new Account(List.of("primary"));
        var constructorCopy = new Account(original);
        var factoryCopy = Account.copyOf(original);
        constructorCopy.addLabel("constructor");
        factoryCopy.addLabel("factory");
        System.out.println("Original: " + original.labels());
        System.out.println("Copy constructor: " + constructorCopy.labels());
        System.out.println("Copy factory: " + factoryCopy.labels());
    }
}
