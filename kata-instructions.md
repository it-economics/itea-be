# ITEA 07 - Green Grade: Open-Closed Principle (OCP)

### Introduction

The ***itea furniture store*** is a new startup that primarily sells furniture and
home decoration in their stores. You have been hired as a consultant to help
them in their digital transformation.

### Rules

* Try to apply TDD (test-driven development) as diligently as possible. But *pragmatism > dogma* -- cover business rules, not code lines.
* Have fun and ask lots of questions!

## Task 1 - Analysis and Discussion

While we don't want to predict which future changes *might* happen and prepare for every possibility in advance – most
of them will never happen after all – we can still sometimes be pretty sure about *certain kinds of changes*.
We call these *expected variation*, and we want to make these changes as simple  and efficient as possible, with little
risk of breaking existing code and without having to make changes in many parts of the code base.

Let's open the enum type `ProductName`. Looking at where and how this enum type is used:

- Which kind of *expected variation* will cause changes to propagate through the code base?
- Where are different classes (possibly including tests) coupled together via this enum type?
- Which kind of change that should not affect the tests would break certain unit tests?<br>
  (Note: Regularly breaking unit tests via changes that should not affect them is a typical symptom of an OCP violation.)

## Task 2 - Refactoring

After thinking about the changes that will definitely be happening regularly during the application's lifetime,
can we find a way to limit these expected changes to certain parts of the code base? We call this a *strategic closure*,
which acts like a "barrier" for how far changes can propagate. Who likes to make changes throughout many files,
possibly breaking stuff unknowingly, each time we make a small change?
