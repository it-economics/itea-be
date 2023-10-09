# ITEA 08 - Green Grade: Tell, Don't Ask and Law of Demeter

### Introduction

The ***itea furniture store*** is a new startup that primarily sells furniture and
home decoration in their stores. You have been hired as a consultant to help
them in their digital transformation.

### Rules

* Try to apply TDD (test-driven development) as diligently as possible. But *pragmatism > dogma* -- cover business rules,
  not code lines.
* Have fun and ask lots of questions!

## Task 1 - Analysis and Discussion

Let's have a look into the `invoicing` package.

### a) **Tell, Don't Ask**<br/>
Where do objects access other objects' internals to do something with it that the object owning the information could
easily do itself? Why can this be problematic? (This is sometimes described as walking a dog by commanding its legs to
move instead of commanding the dog.)

### b) **Law of Demeter**<br/>
Where can we reduce coupling to implementation details by avoiding access to "internals of internals"? Which potential
problems do you see?

The Law of Demeter is sometimes simplified as "only one dot", e.g., `a.b();` instead of `a.b().c()`.
Why is this an oversimplification? In which cases is it perfectly fine to chain method calls together? Does saving each
return value into a local variable solve the problem that the Law of Demeter is concerned with?

<details>
<summary>Hint</summary>
It is about "accessing internals". Can you find examples where a chain of method calls stays on the same abstraction level?
</details>

<details>
<summary>Solution</summary>
Examples where a chain of method calls does not violate the Law of Demeter include fluent interfaces like streams (in Java),
LINQ (in C#), builder pattern, and others. These interfaces often provide a domain-specific language without giving access
to implementation details.
</details>

## Task 2 - Improving the Design

Let's refactor towards a better design. We try to hide the details while emphasizing the higher-level concepts, i.e.,
we try to find good abstractions in the language of the domain.

*Remember that these changes should not be done for personal taste, but to keep the code flexible and easy to understand.
These goals stand above specific principles, which are always context dependent.*
