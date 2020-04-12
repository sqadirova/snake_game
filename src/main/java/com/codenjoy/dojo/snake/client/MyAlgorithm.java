package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snake.client.lee.LPoint;
import com.codenjoy.dojo.snake.client.lee.Lee;
import com.codenjoy.dojo.snake.client.lee.LeeApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyAlgorithm {
    private Board b;

    public MyAlgorithm(Board b) {
        this.b = b;
    }

    public Direction solve() {
        Lee lee = new Lee(b.size(), b.size());
        boolean gameOver=b.isGameOver();
        Point head = b.getHead();
        Point apple = b.getApples().get(0);
        Point stone=b.getStones().get(0);
//        ArrayList<LPoint> obstacles = new ArrayList<>();
//        LeeApp l = new LeeApp();
//        obstacles.addAll(l.obstacles());
        ArrayList<Point> obstacles=new ArrayList<>();
        obstacles.addAll(b.getWalls());
        obstacles.addAll(b.getStones());
        obstacles.addAll(b.getSnake());
//        Optional<List<LPoint>> trace = lee.trace(LPoint.of(head.getX(),head.getY())
//                ,LPoint.of(apple.getX(),apple.getY())
//                ,obstacles);
        if (gameOver) return Direction.UP;
        Optional<List<LPoint>> trace=lee.trace(head,apple,obstacles);
        if (trace.isPresent()){
            List<LPoint> trace_to_apple=trace.get();
            System.out.printf("Apple trace: %s\n",trace_to_apple);
            LPoint next_step=trace_to_apple.get(1);
            return coordinate_direction(head,next_step);
        }

        return Direction.UP;
    }

    private Direction coordinate_direction(Point from, LPoint to) {
        if (to.getX() < from.getX()) return Direction.LEFT;
        if (to.getX() > from.getX()) return Direction.RIGHT;
        if (to.getY() > from.getY()) return Direction.UP;
        if (to.getY() < from.getY()) return Direction.DOWN;
        throw new RuntimeException("You shouldn't be there...");
    }




}
