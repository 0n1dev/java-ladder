package ladder.domain;

import ladder.exception.DepthLineOutOfBoundsException;
import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class DepthTest {

  @Test
  @DisplayName("사다리 하나의 깊이(높이)에 대한 라인을 생성한다.")
  void generate() {
    // given
    int countOfLine = 3;

    // when
    Depth linesOfFirstDrawingLine = Depth.generate(LineRule.drawing(), countOfLine);
    Depth linesOfFirstEmptyLine = Depth.generate(LineRule.empty(), countOfLine);

    // then
    assertAll(
            () -> assertThat(linesOfFirstDrawingLine.getValues())
                    .containsExactly(
                            Line.generate(LineRule.drawing()),
                            Line.generate(LineRule.empty()),
                            Line.generate(LineRule.drawing())
                    ).hasSize(countOfLine),
            () -> assertThat(linesOfFirstEmptyLine.getValues())
                    .containsExactly(
                            Line.generate(LineRule.empty()),
                            Line.generate(LineRule.empty()),
                            Line.generate(LineRule.empty())
                    ).hasSize(countOfLine)
    );
  }

  @Test
  @DisplayName("사다리타기 깊이(높이)는 최소 1개 이상의 라인이 필요하다.")
  void generate_error() {
    assertThatExceptionOfType(DepthLineOutOfBoundsException.class)
            .isThrownBy(() -> Depth.generate(LineRule.drawing(), 0))
            .withMessageMatching("최소 그릴 수 있는 라인 갯수\\(\\d+\\)가 아닙니다.")
    ;
  }
}