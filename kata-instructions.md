# ITEA 06 - Yellow Grade: Liskov Substitution Principle (LSP)

### Introduction

The ***itea furniture store*** is a new startup that primarily sells furniture and
home decoration in their stores. You have been hired as a consultant to help
them in their digital transformation.

### Rules

* Try to apply TDD (test-driven development) as diligently as possible. But *pragmatism > dogma* -- cover business rules, not code lines.
* Have fun and ask lots of questions!

## Task 1 - Shopping Cart and Discounts

Our colleagues have recently started designing the domain model for the shopping  cart (see
`ShoppingCartTest` and work your way from there). In particular, we can add products to the
shopping cart, and since recently also vouchers, which are implemented as a kind of product.
Vouchers could be given to customers for example via advertisements, referrals, and other
marketing campaigns. Vouchers cannot be bought by customers, only redeemed to get a discount.

### a) Let's have a closer look at this design. Vouchers are implemented as products, because that is what we can add to the shopping cart. Any problems with this?

Tip: Consider drawing a diagram if it helps with understanding and discussing the situation.

<details>
<summary>Hint 1</summary>
Vouchers are not actually products that the customers can order, even though they might add them
to the shopping cart, so the code does not really match the domain. But that is only the
second-biggest problem. What do we do with the products once they are added to the shopping cart,
and what do we do with the vouchers?
</details>

<details>
<summary>Hint 2</summary>
The problem is that vouchers are not used like products. They only extend `Product` so that
they can be added to the shopping cart, but the shopping cart has to check at runtime whether
it is a voucher, because vouchers have neither a product ID nor a price. Instead, they have
a discount amount or percentage, which the products do not have.
</details>

### b) How can we fix this problem? Once we found a better design, let's start refactoring.

**Note:** Remember to change the tests first, if necessary, and run them often. Where possible, try to
keep existing functionality intact while gradually refactoring to the improved design, instead of
"replacing", i.e., rewriting the whole design at once.

<details>
<summary>Hint</summary>
Here is one suggested solution:<br/>
Instead of treating vouchers as products just so we can add them to the shopping cart, we
can simply allow adding vouchers in addition to products (e.g., `addProduct(productId)` and
`addVoucher(voucher)`). That way we can still have the shopping cart determine the total price
for us with a simple API that encapsulates most of the details, but we can avoid this type
hierarchy where the caller needs to know about the specific subtypes.
</details>

### c) How easy was it to change the tests compared to changing the implementation? Why?
