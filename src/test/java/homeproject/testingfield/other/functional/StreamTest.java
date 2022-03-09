package homeproject.testingfield.other.functional;

import homeproject.testingfield.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {

    private static final Logger log = LogManager.getLogger(UserService.class);

    /**
     * The resulting log shows that we called the filter() method twice and the map() method once.
     * This is because the pipeline executes vertically. In our example, the first element of the stream didn't satisfy the filter's predicate.
     * Then we invoked the filter() method for the second element, which passed the filter. Without calling the filter() for the third element,
     * we went down through the pipeline to the map() method.
     * <p>
     * The findFirst() operation satisfies by just one element. So in this particular example,
     * the lazy invocation allowed us to avoid two method calls, one for the filter() and one for the map().
     */
    @Test
    void lazyInvocationTest() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Optional<String> stream = list.stream()
                .filter(element -> {
                    log.info("filter() was called");
                    return element.contains("2");
                })
                .map(element -> {
                    log.info("map() was called");
                    return element.toUpperCase();
                })
                .findFirst();
    }

    @Test
    void flatMapTest() {
        final List<List<Integer>> slicedIntegers = Arrays.asList(
                Arrays.asList(2, 4, 6),
                Arrays.asList(8, 10, 12),
                Arrays.asList(14, 16)
        );

        final List<Integer> simpleIntegerList =
                slicedIntegers
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());

        System.out.println("slicedIntegers: " + slicedIntegers);
        //slicedIntegers: [[2, 4, 6], [8, 10, 12], [14, 16]]

        System.out.println("simpleIntegerList: " + simpleIntegerList);
        //simpleIntegerList: [2, 4, 6, 8, 10, 12, 14, 16]
    }

    @Test
    void collectorsTest() {
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        List<String> collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.toList());

        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::getPrice));

        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::getPrice));

        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));

        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));

        Map<Boolean, List<Product>> mapPartitioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));

        //custom
        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPersons =
                productList.stream().collect(toLinkedList);

        /*
          jeśli chcemy jako wartości dla klucza użyć bieżącego elementu kolekcji to jako drugiej funkcji należy użyć Function.identity().
        */
        Map<String, Product> productMap =
                productList
                        .stream()
                        .collect(Collectors.toMap(
                                Product::getName,
                                Function.identity(),
                                (key1, key2) -> {
                                    throw new IllegalStateException(String.format("duplicate key value found %s", key1));
                                }
                        ));

        System.out.println(productMap);

    }

    class Product {
        int price;
        String name;

        public Product(int price, String name) {
            this.price = price;
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }
    }


}
