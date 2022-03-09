package homeproject.testingfield.other.collections;

import org.apache.commons.collections4.ListUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {

    @Test
    public void listUtilsPartitionTest() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = ListUtils.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7, 8);
        assertEquals(subSets.size(), 3);
        assertEquals(lastPartition, expectedLastPartition);
    }

    @Test
    public void groupingByPartitionTest() {
        final List<Integer> numbers = Arrays.asList(1, 2, 34, 4, 5, 6, 27);
        final int chunkSize = 3;
        final AtomicInteger counter = new AtomicInteger();

        final Collection<List<Integer>> result = numbers.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
                .values();

        System.out.println(result);
    }

}
