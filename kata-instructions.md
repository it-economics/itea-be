# ITEA 23 - CI/CD: Continuous Integration and Continuous Delivery

## Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture and home decoration in their stores.
You have been hired as a consultant to help with their digital transformation.

<img src="assets/images/ITEA.jpg" width="200" alt="Photo of the ITEA headquarters" />

## Kata – Part 1 (whole group)

### Exercise 1: Concepts

**CI** stands for **continuos integration**. It means we continuously (i.e., frequently, regularly) integrate (i.e.,
merge) each others changes together into a common code base (main branch or trunk), at least once per day, but usually
multiple times per developer per day.

**CD** stands for **continuous delivery**: The ability to release at any point on demand. A feature is ready? We can
*decide* to simply release it. A bug is fixed? We can simply release the new version, easily and safely.

**CD** can also stand for **continuous deployment**, a special case of continuous delivery where every *releasable*
build is automatically deployed. By default, CD means the more general continuous delivery.

1a) The terms "CI/CD" and "continuous integration" are often misunderstood and misused. Discuss: Which common
misconceptions have you heard before?
  <details>
  <summary>Examples</summary>
  Common misconceptions:<br>
  - "The CI/CD is the build/test/deployment pipeline".<br>
  - Alice: "Does your team practice CI/CD?" Bob: "Yes, we do have a CI/CD!"<br>
  - "Continuous integration means that when all the branches are merged at the end of the sprint, the pipeline is triggered and fully automates build, test, and deployment."
  </details>

1b) Here's what Bob's everyday work experience looks like. Discuss: Why is Bob's team not doing CI/CD?

- Every developer in Bob's team works alone on a separate branch until a whole feature is ready. This typically takes a
  few days, sometimes a few weeks.
- Code reviews are done asynchronously using pull requests. It typically takes 2 - 3 days until a PR is approved and
  merged.
- Bob's team refers to the build/test pipeline as "the CI", although Bob is not sure why.
- While there are some tests which run automatically after a PR is merged, they don't give enough confidence, so the
  testing team takes about a week to manually test at the end of the sprint before the release.
- A new version is released at the end of the 3-week sprint, because that is a rule of Scrum according to Bob's
  knowledge. If the testing team finds too many major defects, the release is skipped and the customer needs to wait
  for the next release.

1c) In Bob's team, everyone works alone on their own ticket on a separate branch. Tickets are assigned to
individual.<br>
Result: 6 of 11 tickets done, 4 tickets "almost done." His manager tells them to "estimate
better".

Meanwhile, Alice's team uses practices like pair/ensemble programming and WIP limits. When they don't pair program, they
work on different parts of the same feature.<br>
Result: 9 of 11 tickets done, 2 tickets not started.

1c) What can Bob's team try in order to get closer to CI/CD?

<details><summary>Hint</summary></details>

1d) Continuous deployment is not always possible, but continuous delivery usually is. In which of these scenarios is
continuous deployment an option and why?

- A web application hosted on AWS.
- A static website hosted on premises.
- An online game hosted on Steam/PlayStation Network/Xbox Live.
- A printer's firmware (update via USB cable).
- Embedded firmware in a car's ABS system or engine controller.

## Kata – Part 2 (breakout sessions)

### Exercise 2: Trunk-based development (TBD)

Many of us learn early in our career that "you never commit directly to main/master". That is unfortunate, because what
applies to one context is not necessarily a universal rule for all contexts. The canonical, simplest way of doing
continuous integration (CI) is actually to work directly on the main branch, and to only push when the tests pass. This
is often unlikely to happen in most "enterprise" teams (we will look at other variants later), but good to know as a
default that we then change depending on our context.

2a) 
