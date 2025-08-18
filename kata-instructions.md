# ITEA 24 - Incremental Development

## Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture and home decoration in their stores.
You have been hired as a consultant to help with their digital transformation.

<img src="assets/images/ITEA.jpg" width="200" alt="Photo of the ITEA headquarters" />

## Tasks 1

Discuss as a team: What's wrong about the following user stories and how can we fix it?

1. As a user, I want a green "Rate this product" button which opens a modal dialog where
   I can rate the product on a scale from 1 to 5.
2. As a product owner, I want to have a "Wishlist" feature so that users can add products
   to the wishlist.
3. As a user, I want to know the status of my order.

## Task 2

### Preparation

1. Form up to 3 teams, ideally 4 - 7 people each.
2. Choose one person per team as the product owner. When a product decision
   needs to be made, the PO has the final word, but every team member
   contributes ideas.
3. Distribute the following user stories among the teams. Each team is end-to-end responsible
   for delivering their user story.
<details>
<summary>Reveal user stories</summary>
- ITEA-24a: As a potential buyer, I want to know what previous buyers think about a product
  to help me decide what to buy.<br>
- ITEA-24b: As a recurring customer, I want to add products to a wishlist so that I don't lose
  track of products I'm interested in but which I'm not ready to buy yet.<br>
- ITEA-24c: As a customer working full time, I want to track the status of my order so that
  I can arrange for someone to be at home and don't have to get the package from the post office
  the next day.
</details>

### Implementation Rules

Warning: This is hard! Don't be too strict about doing the individual practices perfectly.
What counts is that everyone tries and none of the practices are skipped.

- **Everyone commits:** Work as a team. Take turns. Code review happens in real-time, not afterward.
  Someone who's not familiar with Java will simply get more help from the team.
- **Short-lived branches:** Aim for at least one commit every 5 minutes and at least one
  integration every 20 minutes. Decide together what's the next step that's small enough to be
  integrated.
- **Rebase:** No downstream merges. Branches are rebased onto upstream (main) and merged upstream
  via pull request.
- **Double-loop TDD:** Each use case starts with a failing test for the happy path
  through the REST API (the outer loop) to make sure the feature "works", followed
  by many small TDD iterations (the inner loop) *below* the REST API layer
  (e.g. component facades, domain services, value objects) to guide the design and
  flesh out the functionality including edge cases.
