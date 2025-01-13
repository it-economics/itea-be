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
