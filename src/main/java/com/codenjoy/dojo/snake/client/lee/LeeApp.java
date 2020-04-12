package com.codenjoy.dojo.snake.client.lee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeeApp {

  private static Stream<LPoint> horAt(int y, int x_from, int x_to) {
    return IntStream.rangeClosed(x_from, x_to).mapToObj(x -> LPoint.of(x, y));
  }

  private static Stream<LPoint> verAt(int x, int y_from, int y_to) {
    return IntStream.rangeClosed(y_from, y_to).mapToObj(y -> LPoint.of(x, y));
  }

  public static List<LPoint> obstacles() {
    return Stream.of(
        verAt(7, 0, 7),
        horAt(7, 0, 1),
        horAt(7, 3, 6),
        verAt(15, 1, 14)
    ).flatMap(x -> x).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    designSample();
  }

  public static String designSample() {
    LPoint curr = null;
    Lee lee = new Lee(20, 15);
    LPoint from = LPoint.of(0,0);
    LPoint to = LPoint.of(19,14);
    Optional<List<LPoint>> path = lee.trace(from, to, obstacles());
    System.out.println(path);
//
//    if (path.isPresent()) {
//      System.out.println(path);
//      LPoint next_step = path.get().get(0);
//      if      (next_step.x < curr.x) return "LEFT";
//      else if (next_step.x > curr.x) return "RIGHT";
//      else if (next_step.y > curr.y) return "UP";
//      else if (next_step.y < curr.y) return "DOWN";
//      else throw new IllegalArgumentException("should be implemented");
//    } else {
//    }
    throw new IllegalArgumentException("intentionally");
  }
}
