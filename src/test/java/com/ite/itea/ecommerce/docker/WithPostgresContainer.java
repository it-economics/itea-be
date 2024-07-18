package com.ite.itea.ecommerce.docker;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(PostgresContainerAnnotationTest.class)
@DataJpaTest
public @interface WithPostgresContainer {
    @AliasFor(annotation = DataJpaTest.class, attribute = "properties")
    String[] properties() default {};
}
