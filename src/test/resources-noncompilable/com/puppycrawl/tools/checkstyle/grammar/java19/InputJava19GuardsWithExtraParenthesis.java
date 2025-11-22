// non-compiled with javac: compiling on jdk before Java21 (java19)
package com.puppycrawl.tools.checkstyle.grammar.java19;

import java.util.Objects;

public class InputJava19GuardsWithExtraParenthesis {

    record Box<V>(V v) {
        static int x = 5;
    }

    int m1(Box<Box<String>> b) {
        return switch (b) {
            case Box<Box<String>>(Box<String>(String s))
                    when (("test".equals(s) && Box.x != 7))  -> 1;
            case Box<Box<String>>(Box<String>(String s))
                    when (("test".equals(s)) && ((int) Box.x != 7))  -> 1;
            case Box<Box<String>>(Box<String>(String s))
                    when (boolean) "test".equals(s) && (boolean) Objects.equals(s, "box") -> (1);
            case Box<Box<String>>(Box<String>(String s))
                    when "test".equals(s) && Objects.equals(s, "box")
                        || "something else".equals(s) -> 1;
            case Box<Box<String>>(Box<String>(String s))
                    when "test".equals(s) -> 1;
            case Box<Box<String>>(Box<?> b2)
                    when "test".equals(b2.v) -> 1;
            case Box<Box<String>>(Object o)
                    when o != null && "whatever".equals(o.toString()) -> 1;
            default -> -1;
        };
    }

    record when<T>(when<T> when){}

    <T> int moreTrickyWhen(when<when<T>> when){
        return switch(when) {
        case when<when<T>>(when<when<T>> w1)
                  when ((when)w1).when.when.when.when.when.equals(null)-> 2;
        case when<when<T>>(when<when<T>> w1)
                  when (((w1.when.when.when.when.when.equals(null))))
                        -> 2;
        case when<when<T>>(when<when<T>>(when<when<T>> w2))
                  when (((w2.when().when().when().when().when().equals(null))))
                        || ((when) w2).equals(((when) w2)) -> 2;
        case when<when<T>>(when<when<T>>(when<when<T>> w2))
                  when when != null
                        || ((when) w2).equals(((when) when)) -> 2;
        case when<when<T>>(Object w) when when != null -> 9;
          case null, default -> 1;
        };
    }

    Object m3(when<String> when) {
        if (when instanceof when<String>(when<String> w1)) {
            return w1.when.when().when;
        }
        else if (when instanceof when<String>(when<String>(when<String> s1))) {
            if ("s1".equals(s1)) {
                return s1;
            }
        }
        else if ((when instanceof when<String>(when<String>(when<String> s1)))
                    && s1.toString().equals(s1.toString())) {
            if ("s1".equals(s1)) {
                return s1;
            }
        }
        else if (!(when instanceof when<String>(when<String>(when<String> s1)))) {
            return new Object();
        }
        else {
            return s1.toString().equals(s1.toString());
        }
        return null;
    }
}
