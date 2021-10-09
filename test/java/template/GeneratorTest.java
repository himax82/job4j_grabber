package template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Ignore
    @Test
    public void whenTrueGenerate() {
        String first = "I am a ${name}, Who are ${subject}? ";
        String result = "I am a Max, Who are happy? ";
        Map<String, String> map = Map.of("name", "Max", "subject", "happy");
        Generator generator = new GeneratorString();
        assertThat(generator.produce(first, map), is(result));
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void whenNotFoundKeyOnMap() {
        String first = "I am a ${surname}, Who are ${subject}? ";
        String result = "I am a Max, Who are happy? ";
        Map<String, String> map = Map.of("name", "Max", "subject", "happy");
        Generator generator = new GeneratorString();
        assertThat(generator.produce(first, map), is(result));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenFoundUnnecessaryKeyOnMap() {
        String first = "I am a ${surname}, Who are ${subject}? ";
        String result = "I am a Max, Who are happy? ";
        Map<String, String> map = Map.of("name", "Max", "subject", "happy", "surname", "Pleskov");
        Generator generator = new GeneratorString();
        assertThat(generator.produce(first, map), is(result));
    }

}