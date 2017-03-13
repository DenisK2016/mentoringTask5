package com.dk.mentoring.javapoet.gen.impl;

import com.dk.mentoring.javapoet.gen.Car;
import java.lang.Override;
import java.lang.String;

public class Audi implements Car {
  private String engine;

  @Override
  public void start() {
    setEngine("start");
  }

  @Override
  public void stop() {
    setEngine("stop");
  }

  public String getEngine() {
    return this.engine;
  }

  public void setEngine(final String engine) {
    this.engine = engine;
  }
}
