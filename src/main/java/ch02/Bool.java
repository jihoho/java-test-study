package ch02;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-06-11 Time: 오후 11:36
 */
public enum Bool {
    False(0),
    True(1);
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    private int value;

    private Bool(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
