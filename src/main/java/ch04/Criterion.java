package ch04;

import ch01.Scoreable;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-06-11 Time: 오후 8:40
 */
public class Criterion implements Scoreable {
    private Weight weight;
    private Answer answer;
    private int score;

    public Criterion(Answer answer, Weight weight) {
        this.answer = answer;
        this.weight = weight;
    }

    public Answer getAnswer() { return answer; }
    public Weight getWeight() { return weight; }

    public void setScore(int score) { this.score = score; }
    public int getScore() { return score; }

}
