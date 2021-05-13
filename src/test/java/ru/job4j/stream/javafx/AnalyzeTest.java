package ru.job4j.stream.javafx;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * <p>AnalyzeTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class AnalyzeTest {

    /**
     * <p>whenSinglePupil.</p>
     */
    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                ).stream()
        );
        assertThat(average, is(100D));
    }

    /**
     * <p>whenPupilAverage.</p>
     */
    @Test
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60)))
                ).stream()
        );
        assertThat(average, is(80D));
    }

    /**
     * <p>whenListOfPupilAverage.</p>
     */
    @Test
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(average, is(List.of(
                new Tuple("Ivanov", 100D),
                new Tuple("Petrov", 60D)
        )));
    }

    /**
     * <p>whenListOfSubjectAverage.</p>
     */
    @Test
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(average, is(List.of(
                new Tuple("Lang", 80D),
                new Tuple("Math", 80D)
        )));
    }

    /**
     * <p>whenBestPupil.</p>
     */
    @Test
    public void whenBestPupil() {
        Tuple best = Analyze.bestStudent(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(best, is(new Tuple("Ivanov", 200D)));
    }

    /**
     * <p>whenBestSubject.</p>
     */
    @Test
    public void whenBestSubject() {
        Tuple best = Analyze.bestSubject(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100), new Subject("Lang", 40))),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(best, is(new Tuple("Math", 160D)));
    }
}
