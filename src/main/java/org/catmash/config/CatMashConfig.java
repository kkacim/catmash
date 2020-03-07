package org.catmash.config;

import org.catmash.databasepopulator.CustomRepositoryPopulatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("org.catmash")
public class CatMashConfig {

  // A bean to call Jackson2RepositoryPopulator to populate the database
  @Bean
  public CustomRepositoryPopulatorFactoryBean getRespositoryPopulator() {
    CustomRepositoryPopulatorFactoryBean factory = new CustomRepositoryPopulatorFactoryBean();
    factory.setResources(new Resource[] { new ClassPathResource("cats.json") });
    return factory;
  }
}
