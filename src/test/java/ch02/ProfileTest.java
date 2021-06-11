package ch02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-06-11 Time: 오후 11:37
 */
public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create() {
        profile = new Profile("Bull Hockey, Inc");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() throws Exception {
        // given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        // when
        boolean matches = profile.matches(criteria);
        // then
        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCaraCriteria() throws Exception {
        // given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        // when
        boolean matches = profile.matches(criteria);
        // then

        assertTrue(matches);
    }


}