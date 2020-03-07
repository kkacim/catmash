package org.catmash.databasepopulator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2ResourceReader;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomJackson2ResourceReader extends Jackson2ResourceReader {

  private ObjectMapper mapper;

  public CustomJackson2ResourceReader(ObjectMapper mpr) {
    super(mpr);
    mapper = mpr;
  }

  @Override
  public Object readFrom(Resource resource, @Nullable ClassLoader classLoader) throws Exception {
    Assert.notNull(resource, "Resource must not be null!");
    InputStream stream = resource.getInputStream();
    JsonNode node = this.mapper.readerFor(JsonNode.class).readTree(stream);

    // Customise the reader to support "cats.json"
    Iterator<JsonNode> elements = node.get("images").elements();
    ArrayList<Object> result = new ArrayList<>();

    while (elements.hasNext()) {
      JsonNode element = elements.next();
      result.add(this.readSingle(element, classLoader));
    }

    return result;
  }

  private Object readSingle(JsonNode node, @Nullable ClassLoader classLoader) throws IOException {
    // Customise the read method to set a static classname
    String typeName = "org.catmash.datamodel.Cat";
    Class<?> type = ClassUtils.resolveClassName(typeName, classLoader);
    return this.mapper.readerFor(type).readValue(node);
  }
}