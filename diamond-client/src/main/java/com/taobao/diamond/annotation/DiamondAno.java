package com.taobao.diamond.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DiamondAno {

    String groupId() default "";

    String dataId() default "";

    String[] values() default {};

}
