package com.ite.itea.ecommerce.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

public class FieldRulesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.ite.itea.ecommerce");

    @Test
    public void all_usecase_classes_should_have_final_fields() {
        classes().that()
                .haveNameMatching(".*UseCase")
                .should()
                .haveOnlyFinalFields()
                .because("we agreed on this convention") // You can also add a description to the rule
                .check(classes);
    }

    @Test
    public void all_fields_with_the_name_usecase_should_be_private_and_final() {
        fields().that()
                .haveNameMatching(".*UseCase")
                .should().bePrivate()
                .andShould().beFinal()
                .because("we agreed on this convention") // You can also add a description to the rule
                .check(classes);
    }
}