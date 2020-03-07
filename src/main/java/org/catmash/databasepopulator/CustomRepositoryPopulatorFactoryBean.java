package org.catmash.databasepopulator;

import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.data.repository.init.ResourceReader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomRepositoryPopulatorFactoryBean extends Jackson2RepositoryPopulatorFactoryBean {

  private static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper();

  static {
    DEFAULT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Override
  protected ResourceReader getResourceReader() {
    return new CustomJackson2ResourceReader(DEFAULT_MAPPER);
  }
}