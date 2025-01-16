package com.ite.itea.ecommerce.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.GeneralCodingRules.*;

public class TeamRulesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.ite.itea.ecommerce");

    @Test
    public void deprecated_api_should_not_be_used() {
        DEPRECATED_API_SHOULD_NOT_BE_USED.check(classes);
    }

    @Test
    public void classes_should_not_use_java_util_logging() {
        NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING.check(classes);
    }

    @Test
    public void classes_should_not_use_jodatime() {
        NO_CLASSES_SHOULD_USE_JODATIME.check(classes);
    }
}
