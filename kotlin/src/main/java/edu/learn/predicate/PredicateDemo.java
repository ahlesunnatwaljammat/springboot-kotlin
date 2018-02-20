package edu.learn.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = s -> s.equals("Hello");
        Predicate<Integer> integerPredicate = i -> i > 0;

        System.out.println(String.join(":","a","b"));

        System.out.println(stringPredicate.test("Hello"));
        System.out.println(integerPredicate.test(-1));

        System.out.println(PredicateDemo.stringPredicate().test("Test"));
        System.out.println(PredicateDemo.integerPredicate().test(11));

        //AND logical operation
        Predicate<String> predicateAnd= stringPredicate.and(s->s.length()>4);
        System.out.println(predicateAnd.test("Hello"));

        //OR logical operation
        Predicate<String> predicateOr= stringPredicate.or(s->s.length()==10);
        System.out.println(predicateOr.test("Hello"));

        //NEGATE logical operation
        Predicate<String> predicateNegate= stringPredicate.negate();
        System.out.println(predicateNegate.test("Hello"));
    }

    public static Predicate<String> stringPredicate(){
        return s -> s.equals("Test");
    }

    public static Predicate<Integer> integerPredicate(){
        return i -> i > 10;
    }

}
