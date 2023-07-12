# ITEA 05 - Yellow Grade: Dependency Inversion Principle (DIP)

### Introduction

The ***itea furniture store*** is a new startup that primarily sells furniture and
home decoration in their stores. You have been hired as a consultant to help
them in their digital transformation.

### Rules

* Try to apply TDD (test-driven development) as diligently as possible. But *pragmatism > dogma* -- cover business rules, not code lines.
* Have fun and ask lots of questions!

## Task 1 - Analysis and Discussion

A common pattern for decoupling the domain model from details of the persistence
layer (database, file system, etc.) is the repository pattern. A repository lets
us access domain entities without having to think about how they are persisted
and to focus on the domain/business rules instead.

Looking at the repositories that are present in the codebase so far, you see that
the previous developers were not very consistent with their use of interfaces for
the repositories, and that they may have used interfaces dogmatically based on *similar*
code they've seen before, rather than intentionally with a specific goal in mind.

### Discuss with your peers:

#### a) In which cases do the use cases know too much about the persistence mechanism in use?

<details>
<summary>Hint</summary>
A common symptom is when the repository interface (a domain concept) is defined
in the persistence layer, together with its implementation, which makes it difficult
for developers to conceptually separate those very different concepts.
</details>


#### b) Where do lower-level classes technically implement an interface, but it is Indirection Without Abstraction, resulting in the caller depending on the implementation *despite* the interface, instead of *only on* the interface.

<details>
<summary>Hint</summary>
A typical indicator is the presence of the `Impl` suffix with the rest of the class
name being just the interface name. If that is the case, then often the interface
name is too specific, or the implementation name could be named more explicitly
(i.e., what is it that makes this implementation more concrete than the interface?
What distinguishes it from other possible implementations?).

Another indicator is if the interface and the implementation  reside in the same
package or layer. Which of the two classes in the dependency contract *requires*
the dependency, and which one has to *provide* it in order to fulfill the contract?

E.g., imagine plugins for your favorite IDE were to define the contract that they
need in order to provide their functionality, and the IDE had to fulfill it. The
IDE would depend on *every* plugin.
</details>

#### c) In which cases do callers of the repository interface depend only on the domain layer, as intended by the dependency rule, with the implementation being more concrete and in a lower-level layer?

<details>
<summary>Hint</summary>
We want use cases to only depend on a repository interface for
accessing domain entities:<br>
use case --> repository interface <-- repository implementation

The domain/business rules are the highest level, and the "center"
of the application. Lower levels (use cases, persistence) depend on
the domain, but the domain has no dependencies on the infrastructure
or on application-specific code.
</details>

#### d) There are cases in the codebase where an implementation has the *exact same* name as the interface it implements. How is that possible? Can you find them? Who defines the interface (i.e., *requires* the dependency), and who fulfills the contract?

<details>
<summary>Hint</summary>
It's the `ReceiptPresenter` and `UserInfoPresenter`. If that is a fitting name, there is no need to
decrease readability by adding an `Impl` suffix. The `Impl` suffix is not
needed to indicate an implementation (that would be the generally discouraged
Hungarian notation, and of course classes are implementations - imagine having
`ListImpl` instead of `ArrayList`), but often only because the name must be
unique and the desired name is already taken by the interface.

So then, how can the class have the same name as its interface in this case?
Remember: Lower-level layers should depend on higher level interfaces, and
the dependencies should point inwards towards the application core.
</details>

## Task 2 - Refactoring Towards Inverted Dependencies

Using safe refactorings (e.g., IDE refactorings) wherever possible,
refactor the cases identified in Task 1a) and 1b) to apply to the goal identified
described in Task 1c). Make sure to think interface-first, and identify
which side of the dependency contract *requires* the dependency and which
side *fulfills* it.
