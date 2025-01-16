# ITEA 20 - Value Objects

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture and home decoration in their stores.
You have been hired as a software developer to help them team implement new features.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

### Exercise 1 – Warm-up

Discuss with your peers.

a) What do you like or not like about this code?

`float grossPrice = 1.19f * netPrice;`

<details>
<summary>b) Click to reveal after a).</summary>

What is the difference between these lines of code? What are their pros and cons?
Which variant do you prefer and why?

- `float grossPrice = 1.19f * netPrice;`

- `BigDecimal grossPrice = MoneyUtils.addVat(netPrice, BigDecimal.valueOf(19L));`

- `Money grossPrice = netPrice.taxedAs(VatRate.STANDARD);`
</details>

c) How many problems with this code can you identify?

`var length = 120f;`

<details>
<summary>d) Click to reveal after c).</summary>

Let's be more explicit about the unit of measurement. Does this solve the problem?

```
// What's the total width of these two pieces of furniture?
float wardrobeWidthInFeet = 4.921f;
float bookshelfWidthInInches = 11.81f;
```
</details>

### Exercise 2 – Let's look at an existing value object

We are already using value objects in some places in the code base. Have a look
at the `EuroPrice` class. Discuss: What do you notice?

<details>
<summary>Reveal</summary>

- it represents a single value, but also has some "rules" associated with it
- it is immutable
- operations create new prices ("changing" a value creates a new one, a.k.a. "value semantics")
- it hides the internal representation
- its instantiation is tightly controlled (via factory methods)
- it is serializable (in this case as JSON)
- invalid states (negative prices) are prevented => when an object exists, it is in a valid state
- it has no dependencies besides the standard library and (declarative) serialization library
- all of its operations are easily *discoverable* (if you have the value, you know what you can
  do with it, no static utils in other files)
- there are no *conversions* between euros and cents (from the caller's perspective)
- it is easy to test (and in fact is comprehensively tested)
- ... ?
</details>

### Exercise 3 – Refactoring to value objects

We will soon release a convenient new feature where customers can design and plan their
rooms configuration, virtually place furniture to see how everything fits and do
calculations like "how much paint do I need for the walls, based on the size of the room
and the required paint per area".

Let's have a look at `CalculateRequiredWallPaintAmountUseCase` and the related code.
Where is the complexity? How easy to understand is the use case? How easy to understand
will it be once we allow the user to enter their room measurements in meters or feet.
Note that we do not want all of the different frontends to do the calculations, so we
do them in the backend.

Where can we identify candidates for value objects? Let's begin with one and extract it.
We can drive the design using TDD at a lower level while getting some safety from our
existing high-level integration test.

<details>
<summary>Reveal suggestions (make sure to try yourself first)</summary>
Candidates (we may not need all of these):

- Length
- Area
- Volume
- VolumePerArea

Usage example:

```
var wallArea = Area.fromMeters(10, 3.6);
var litersPerSquareMeter = VolumePerAre.ofGallonsPerSquareFoot(42).asLitersPerSquareMeter();

var volume1 = Volume.ofGallons(13.37f);
var volume2 = Volume.ofLiters(42);
var totalVolume = volume1.plus(volume2);
```

</details>
