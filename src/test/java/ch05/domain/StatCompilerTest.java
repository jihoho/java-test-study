package ch05.domain;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-06-15 Time: 오후 6:29
 */
public class StatCompilerTest {

    @Test
    public void responseByQuestionAnswersCountsByQuestionText() throws Exception {
        // given
        StatCompiler stats = new StatCompiler();
        List<BooleanAnswer> answers = new ArrayList<>();
        answers.add(new BooleanAnswer(1, true));
        answers.add(new BooleanAnswer(1, true));
        answers.add(new BooleanAnswer(1, true));
        answers.add(new BooleanAnswer(1, false));
        answers.add(new BooleanAnswer(2, true));
        answers.add(new BooleanAnswer(2, true));
        Map<Integer, String> questions = new HashMap<>();
        questions.put(1, "Tuition reimbursement?");
        questions.put(2, "Relocation package?");
        // when
        Map<String, Map<Boolean, AtomicInteger>> response = stats
                .responsesByQuestion(answers, questions);
        // then
        assertThat(response.get("Tuition reimbursement?").get(Boolean.TRUE).get(), equalTo(3));
        assertThat(response.get("Tuition reimbursement?").get(Boolean.FALSE).get(), equalTo(1));
        assertThat(response.get("Relocation package?").get(Boolean.TRUE).get(), equalTo(2));
        assertThat(response.get("Relocation package?").get(Boolean.FALSE).get(), equalTo(0));
    }


}