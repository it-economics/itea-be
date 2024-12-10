package com.ite.itea.ecommerce.architecture;

import com.ite.itea.ecommerce.usecase.OrderProductsUseCase;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

public class FieldRulesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.ite.itea.ecommerce");

    @Test
    public void loggers_should_be_private_static_final() {
        fields().that()
                .haveRawType(OrderProductsUseCase.class)
                .should().bePrivate()
                .because("we agreed on this convention")
                .check(classes);
    }

}