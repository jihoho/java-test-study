package ch04;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-06-11 Time: 오후 8:44
 */
public enum Weight {
    MustMatch(Integer.MAX_VALUE),
    VeryImportant(5000),
    Important(1000),
    WouldPrefer(100),
    DontCare(0);

    private int value;

    Weight(int value) { this.value = value; }
    public int getValue() { return value; }
}
