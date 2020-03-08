package org.catmash.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Outcome {

  WIN(1), LOSS(0);

  private float score;
}
