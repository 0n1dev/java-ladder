package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public static Point first(DirectionPredicate directionPredicate) {
        return new Point(Direction.generate(directionPredicate));
    }

    public Direction currentDirection() {
        return direction;
    }

    public Point next(DirectionPredicate predicate) {
        return new Point(direction.next(predicate));
    }

    public Point last() {
        return new Point(direction.last());
    }

    public int move() {
        return direction.getDirection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}