package com.ite.itea.ecommerce.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ControllerRulesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.ite.itea.ecommerce");

    @Test
    public void controller_should_have_spring_boot_controller_annotation() {
        ArchRule rule = classes()
                .that().resideInAPackage("com.ite.itea.ecommerce.adapters.in.controller")
                .should().beAnnotatedWith(Controller.class);

        rule.check(classes);
    }

    @Test
    public void controller_must_reside_in_a_controller_package() {
        ArchRule rule = classes().that().haveNameMatching(".*Controller")
                .should().resideInAPackage("com.ite.itea.ecommerce.adapters.in.controller")
                .as("Controller should reside in the package '..controller..'");

        rule.check(classes);
    }
}
