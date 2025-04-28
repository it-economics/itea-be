package com.ite.itea.ecommerce.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class FieldRulesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.ite.itea.ecommerce");

    @Test
    public void all_use_case_classes_should_have_only_final_fields() {
        classes().that()
                .haveNameMatching(".*UseCase")
                .should()
                .haveOnlyFinalFields()
                .because("use cases are stateless (except immutable fields for injected dependencies)")
                .check(classes);
    }
}
