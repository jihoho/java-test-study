package ch04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-06-14 Time: 오후 7:21
 */
public class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create() {
    }

    @Test
    public void matches() throws Exception {
        // given
        profile = new Profile("Bull Hockey, Inc");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        // when
        boolean matches = profile.matches(criteria);
        // then
        assertFalse(matches);


        profile.add(new Answer(question, Bool.FALSE));
        criteria=new Criteria();
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        assertTrue(profile.matches(criteria));
    }


}