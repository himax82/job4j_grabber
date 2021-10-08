package template;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void whenTrueGenerate() {
        String first = "I am a ${name}, Who are ${subject}? ";
        String result = "I am a Max, Who are happy? ";
        Map<String, String> map = Map.of("name", "Max", "subject", "happy");
        Generator generator = new GeneratorString();
        assertThat(generator.produce(first, map), is(result));
    }

    @Test(expected = RuntimeException.class)
    public void whenNotFoundKeyOnMap() {
        String first = "I am a ${surname}, Who are ${subject}? ";
        String result = "I am a Max, Who are happy? ";
        Map<String, String> map = Map.of("name", "Max", "subject", "happy");
        Generator generator = new GeneratorString();
        assertThat(generator.produce(first, map), is(result));
    }

    @Test(expected = RuntimeException.class)
    public void whenFoundUnnecessaryKeyOnMap() {
        String first = "I am a ${surname}, Who are ${subject}? ";
        String result = "I am a Max, Who are happy? ";
        Map<String, String> map = Map.of("name", "Max", "subject", "happy", "surname", "Pleskov");
        Generator generator = new GeneratorString();
        assertThat(generator.produce(first, map), is(result));
    }

}