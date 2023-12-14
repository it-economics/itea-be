# ITEA 10 - Blue Grade: YAGNI Principle in Hexagonal Architecture

### Introduction

The ***itea furniture store*** is a new startup that primarily sells furniture
and home decoration in their stores. You have been hired as a consultant to
help them in their digital transformation.

### Understanding YAGNI

This time we're exploring the YAGNI (You Ain't Gonna Need It) principle within
the context of hexagonal architecture. YAGNI is a critical aspect of Agile and
Clean Code practices, emphasizing the importance of not adding functionality
until it's deemed necessary.

YAGNI is about avoiding over-engineering and focusing on what is necessary at
the moment. It encourages simplicity and minimalism in code design, ensuring
that we only spend time on things that bring immediate value (but without
compromizing on quality).

### Hexagonal Architecture and YAGNI

In hexagonal architecture, the separation of core logic from external components
through ports and adapters enables us to apply YAGNI in choosing our data
storage solutions. We can start with simple solutions like JSON files or
in-memory databases and evolve to more complex databases only if needed.

### Rules

- Focus on implementing the YAGNI principle in the context of our ITEA
  application.
- Remember to keep your implementations simple and only add what is necessary.
- You're encouraged to use the hexagonal architecture to your advantage when
  applying YAGNI.

## Task 1 - Discussing YAGNI in the Context of Hexagonal Architecture

Before diving into the coding challenge, let's discuss how hexagonal
architecture can help with the effective application of YAGNI.

### a) **Simplicity in Design**<br/>

**Question:** How does hexagonal architecture help maintain simplicity in the
design of our bank account service? Discuss the benefits of starting with
simpler data storage solutions.

<details>
<summary>Solution</summary>

- Hexagonal architecture aids in maintaining simplicity by segregating the core
  business logic from external interfaces like data storage, using ports and
  adapters.
- This separation ensures that the core logic is not coupled with
  storage-specific details, keeping it simple and focused.
- Starting with simpler storage solutions like in-memory databases reduces
  initial complexity and facilitates easier testing and flexibility for future
  changes.

</details>

### b) **Evolving the System**<br/>

**Question:** Explore how the system can evolve from using simple data storage
to more complex ones under the YAGNI principle. Discuss the ease of making such
changes in a hexagonal architecture setup.

<details>
<summary>Solution</summary>

- Under YAGNI, the system evolves to include complex components only as needed,
  avoiding unnecessary initial work.
- Hexagonal architecture allows for smooth transitions in data storage without
  impacting the core logic, by simply replacing or extending adapters.
- For instance, upgrading from an in-memory database to a persistent storage
  solution can be done by introducing a new adapter, with no changes required in
  the core application.

</details>



## Task 2 - Coding Challenge: Evolving Data Storage

The current bank account service uses an in-memory database for simplicity. The
challenge is to refactor the code to allow easy swapping of the data storage
solution, adhering to the YAGNI principle.

### Provided Code Base

- The existing InMemoryProductRepository code with in-memory database implementation.

### Your Task

- Add additional repository to allow easy replacement of the data storage mechanism.
- Ensure the core application logic remains unchanged while swapping storage solutions.
- Write tests to demonstrate that the refactoring doesn't affect the existing functionalities.

### Focus Points

- Keep the refactoring minimal and straightforward.
- Demonstrate how your changes align with the YAGNI principle.
- Discuss the potential future extensions that can be made, keeping YAGNI in mind.

## Optional Task

- Propose a scenario where transitioning to a more complex database would be necessary.
- Discuss how the hexagonal architecture would facilitate this transition.
