package com.ite.itea.ecommerce.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureRulesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.ite.itea.ecommerce");

    @Test
    public void controller_should_only_access_classes_that_are_in_the_usecase_directory() {
        ArchRule rule = classes()
                .that().resideInAPackage("com.ite.itea.ecommerce.adapters.in.controller")
                .should().accessClassesThat().resideInAPackage("com.ite.itea.ecommerce.usecase");

        rule.check(classes);
    }

    @Test
    public void usecases_should_only_access_classes_that_are_in_the_persistence_directory() {
        ArchRule rule = noClasses()
                .that().resideInAPackage("com.ite.itea.ecommerce.usecase")
                .should().accessClassesThat().resideInAPackage("com.ite.itea.ecommerce.adapters.in")
                .orShould().accessClassesThat().resideInAPackage("com.ite.itea.ecommerce.adapters.out");

        rule.check(classes);
    }
}
