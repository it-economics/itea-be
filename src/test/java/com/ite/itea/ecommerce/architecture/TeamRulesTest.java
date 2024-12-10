package com.ite.itea.ecommerce.architecture;

import com.ite.itea.ecommerce.usecase.OrderProductsUseCase;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.CompositeArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

public class TeamRulesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.ite.itea.ecommerce");

    @Test
    public void classes_should_not_access_standard_streams_defined_by_hand() {
        noClasses().should(ACCESS_STANDARD_STREAMS).check(classes);
    }

    @Test
    public void classes_should_not_access_standard_streams_from_library() {
        NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS.check(classes);
    }

    @Test
    public void classes_should_not_throw_generic_exceptions() {
        NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS.check(classes);
    }

    @Test
    public void classes_should_not_use_java_util_logging() {
        NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING.check(classes);
    }

    @Test
    public void loggers_should_be_private_static_final() {
        fields().that().haveRawType(OrderProductsUseCase.class)
                .should().bePrivate()
                .because("we agreed on this convention")
                .check(classes);
    }

    @Test
    public void loggers_should_be_private_static_final2() {
        fields().should().bePrivate()
                .because("we agreed on this convention")
                .check(classes);
    }

    @Test
    public void classes_should_not_use_jodatime() {
        NO_CLASSES_SHOULD_USE_JODATIME.check(classes);
    }

    @Test
    public void classes_should_not_use_field_injection() {
        NO_CLASSES_SHOULD_USE_FIELD_INJECTION.check(classes);
    }

    @Test
    public void no_classes_should_access_standard_streams_or_throw_generic_exceptions() {
        CompositeArchRule.of(NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS)
                .and(NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS).check(classes);
    }

    // TODO SK: Gutes Beispiel für einen ArchUnit test
    @Test
    public void deprecated_api_should_not_be_used() {
        DEPRECATED_API_SHOULD_NOT_BE_USED.check(classes);
    }

}