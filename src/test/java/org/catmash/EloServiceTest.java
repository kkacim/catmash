package org.catmash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.catmash.datamodel.Cat;
import org.catmash.service.EloServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EloServiceTest {

  @InjectMocks
  private EloServiceImpl eloService;

  @Test
  public void testCalculateNewRatings() {
    Cat firstCat = new Cat("first", "url", 1500);
    Cat secondCat = new Cat("second", "url", 1500);

    Set<Cat> cats = eloService.calculateNewRatings(firstCat, secondCat);

    for (Cat cat : cats) {
      if ("first".equals(cat.getId())) {
        assertThat(cat.getRating()).isEqualTo(1512);
      } else {
        assertThat(cat.getRating()).isEqualTo(1488);
      }
    }
  }
}
