package kiss;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void maxTest() {
        List<Integer> list = List.of(5, 6, 1, 9, 12, 3, 8);
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.max(list, Integer::compareTo), is(12));
    }

    @Test
    public void minTest() {
        List<Integer> list = List.of(5, 6, 1, 9, 12, 3, 8);
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.min(list, Integer::compareTo), is(1));
    }

}