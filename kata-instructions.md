# ITEA 13 - Orange Grade: Single Level of Abstraction Principle (SLAP)

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture
and home decoration in their stores. You have been hired as a consultant to
help them in their digital transformation.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

In past projects you had to deal with really messy legacy code. Some of your
colleagues regularly complained about the *lack of* abstraction, while others always
whined about there being *too much* abstraction. After learning more about
abstractions and design principles, you realized that the problem was actually
*indirection without abstraction*, and different abstraction levels being mixed,
rather than the total "amount of abstraction", whatever that means.

You decided that this project will be different—with the help of SLAP!

### SLAP - Single Level of Abstraction Principle

The Single Level of Abstraction Principle (SLAP, or SLA principle) is a design
principle for making code easier to understand and reduce the reader's cognitive
load. To understand the principle let's first look at an **analogy**:

You bought today's newspaper. Since you're a big football fan, you open the
sports section. You skim the headings, looking for football-related articles.
"Something about Manuel Neuer", "Toni Kroos joins national team (again)",
"Ronaldo almost scores goal against titan Oliver Kahn". That last one sounds
interesting and relevant, so you skim the article's section titles and then read
the detailed text of the interesting parts.

The newspaper is structured at different levels of detail
(or levels of abstraction):
1. The sports section.
2. The article headings.
3. The article section titles.
4. The detailed text.

You quickly find what you're looking for, because you can "zoom in" from one
level to the next. The sections are typically kept on the same abstraction level,
so you might have newspaper sections like
- Politics
- Sports
- Entertainment
- Finance

You generally won't find a newspaper with the sections
- Politics
- Sports
- Leonardo DiCaprio again without Oscar at 2024 Academy Awards
- Finance

Drawing the connection back to code and programming languages, does this
remind you of something? What is (roughly) the equivalent of sections, articles,
headings, etc. in code?

## Task 1: Abstractions – Warm-up and Intuition

<img src="assets/images/coding-dojo-literally.jpg" width="300" alt="Coding dojo taken too literally" />

a) Order the following types by their level of abstraction.

- `List<Product>`
- `Product[]`
- `ShoppingCart`
- `AbstractProductListWrapper`
- `ArrayList<Product>`

b) Order the following statements by their level of abstraction.

1. ```
   float grossPrice = 1.19f * netPrice;
   ```

2. ```
   Money grossPrice = netPrice.taxedAs(VatRate.STANDARD);
   ```

3. ```
   float grossPrice = FloatUtils.addNineteenPercent(netPrice);
   ```

4. ```
   float grossPrice = netToGrossByStandardRate(netPrice);
   ```

5. ```
   float grossPrice = MoneyUtils.addVat(netPrice, 19.0f);
   ```

c) Out of the following code snippets, which ones show real abstractions
and which ones are just indirection disguised as abstraction?

1. ```
   public interface CloudStorageProvider { ... }
   public class CloudStorageProviderImpl implements CloudStorageProvider { ... }
   ```
2. ```
   public interface DropboxAdapter { ... }
   public class DropboxAdapterImpl implements DropboxAdapter { ... }
   ```
3. ```
   public interface CloudStorageProvider { ... }
   public class DropboxAdapter implements CloudStorageProvider { ... }
   ```
   
## Task 2: Applying SLAP

Let's have a look into the `Invoice` class. There's a very long method there
with abstraction levels all over the place.

a) How easy or hard is it to understand what's happening here?

b) Similar to task 1, let's try to identify which lines/statements/types
are at different levels of abstraction.

c) How can a monster of a method like this be prevented, other than "refactoring
when it's finished"?

<details>
<summary>Reveal answer</summary>
Thinking about the problem at a higher level (the "problem level") and trying to
communicate that through the code, making it work through implementation details.
Techniques like TDD can help, but more generally it's about the way of thinking
more than specific approaches.
</details>

d) Since this is a public method, we probably expect the highest abstraction
level here. Using pseudocode, try to sketch roughly which steps you would expect
at the highest abstraction level.

e) Refactor to a single level of abstraction in that public method. The goal is
to end up with something similar to the pseudocode from d). The result should be
readable almost like a story. Don't forget to regularly run the tests.<br>
Note: If you choose to extract methods, each of these should again be on a
single abstraction level (although a lower one) and read like a (more detailed)
story, but let's focus on that highest level first. We can then further
"push down" detail from that lower level.
