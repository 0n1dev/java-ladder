package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder from(int numberOfPlayers, Height height) {
        return new Ladder(IntStream
                .range(0, height.getHeight())
                .mapToObj((integer) -> Line.from(numberOfPlayers))
                .collect(Collectors.toList()));
    }

    Position goThroughLinesFrom(Position position) {
        for (Line line : lines) {
            position = line.travel(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}