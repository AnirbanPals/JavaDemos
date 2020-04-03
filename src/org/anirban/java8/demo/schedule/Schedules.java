package org.anirban.java8.demo.schedule;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Schedules {
    Schedule[] value();
}