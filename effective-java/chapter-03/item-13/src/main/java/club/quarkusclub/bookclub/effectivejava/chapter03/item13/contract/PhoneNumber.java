package club.quarkusclub.bookclub.effectivejava.chapter03.item13.contract;

import java.util.Objects;

public final class PhoneNumber implements Cloneable {
    private static int constructorCalls;
    private final int areaCode;
    private final int prefix;
    private final int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = validate(areaCode, 999);
        this.prefix = validate(prefix, 999);
        this.lineNumber = validate(lineNumber, 9999);
        constructorCalls++;
    }

    private static int validate(int value, int maximum) {
        if (value < 0 || value > maximum) {
            throw new IllegalArgumentException("Value outside accepted range: " + value);
        }
        return value;
    }

    public static int constructorCalls() {
        return constructorCalls;
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException impossible) {
            throw new AssertionError(impossible);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PhoneNumber number
                && areaCode == number.areaCode
                && prefix == number.prefix
                && lineNumber == number.lineNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNumber);
    }

    public static void main(String[] args) {
        var original = new PhoneNumber(313, 414, 533);
        int before = constructorCalls();
        PhoneNumber copy = original.clone();
        System.out.println("Different objects: " + (copy != original));
        System.out.println("Same concrete class: " + (copy.getClass() == original.getClass()));
        System.out.println("Value equality: " + copy.equals(original));
        System.out.println("Constructor calls during clone: " + (constructorCalls() - before));
    }
}
