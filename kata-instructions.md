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
