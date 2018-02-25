package com.chelp.oop.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ TYPE, METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	String value() default DataSource.READER;

	public static final String READER = "dataSourceReader";

	public static final String WRITER = "dataSourceWriter";
}
