package olegood.lab.orgs.entity.marker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MarkerTest {

  @Mock private Age age;

  @Test
  void shouldReturnTrueWhenAgeIsActive() {
    // given
    givenAgeIsActive(true);
    var marker = new Marker().setAge(age);

    // then
    assertThat(marker.isActive()).isTrue();
  }

  @Test
  void shouldReturnFalseWhenAgeIsNotActive() {
    // given
    givenAgeIsActive(false);
    var marker = new Marker().setAge(age);

    // then
    assertThat(marker.isActive()).isFalse();
  }

  @Test
  void shouldReturnFalseWhenAgeIsNull() {
    // given
    var marker = new Marker().setAge(null);

    // then
    assertThat(marker.isActive()).isFalse();
  }

  private void givenAgeIsActive(boolean isActive) {
    when(age.isActive()).thenReturn(isActive);
  }
}
