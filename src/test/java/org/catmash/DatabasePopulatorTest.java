package org.catmash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.catmash.config.CatMashConfig;
import org.catmash.datamodel.Cat;
import org.catmash.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CatMashConfig.class)
public class DatabasePopulatorTest {

  @Autowired
  private CatRepository catRepository;

  @Test
  public void databaseShouldBePopulatedOnStartup() {
    List<Cat> cats = catRepository.findAll();
    assertThat(cats.size()).isEqualTo(1);
    assertThat(cats.get(0).getId()).isEqualTo("testId");
  }
}
