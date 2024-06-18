# ITEA 16 - Mutation Testing

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture
and home decoration in their stores. You have been hired as a consultant to
help them in their digital transformation.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

### What is Mutation Testing?

How do we know if our test suite is good?
If we have high<sup>1)</sup> test coverage and make a mistake while changing the implementation,
we expect our tests to alert us about the mistake. Mutation testing systematically introduces
changes ("mutations") in the code by inverting conditions, changing return values, etc.,
and then runs the test suite on the mutated code ("mutant"). A good test suite "kills" the
majority or all of the mutants. We can then use the information about surviving mutants to
decide where we might want to add additional tests or improve existing tests.

<sub>1) By "high coverage" we don't mean a certain percentage, but having tests for everything
we consider worth testing. The actual percentage depends on many factors and usually shouldn't
be a target.</sub> 

## Exercises

⚠️ *Make sure everyone has IntelliJ Community Edition (or equivalent) installed. Now is the time to
start the download/installation so that it can be installed during the discussion exercise.*

### Exercise 1: Discussion

- Why does line coverage alone not guarantee that there are no bugs? (line coverage = lines
  that are executed by at least one test)
- How high (in percent) should the code coverage be?
- Mutation tests are typically much slower than unit tests. Should we run them in the
  CI pipeline on every check-in?

### Exercise 2: Install, run, and discuss the mutation test result

*Recommended: Each participant tries it on their own machine. The group helps in case of problems.*

We will explore mutation testing using PIT in Java, but the focus is not on
the tool specifics, but the conceptual understanding. Still, we will look
at some of the features that PIT provides and treat it as a proxy for mutation
testing tools in general.

1. Install PIT, a mutation testing tool for Java (similar tools exist for other languages).
   Add the following to your pom.xml, within `<build><plugins>`:
   ```
    <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.16.1</version>
        <dependencies>
            <dependency>
                <groupId>org.pitest</groupId>
                <artifactId>pitest-junit5-plugin</artifactId>
                <version>1.2.1</version>
            </dependency>
        </dependencies>
    </plugin>
   ```
2. Run the Maven goal `mvn test-compile org.pitest:pitest-maven:mutationCoverage`.
3. Find the mutation test report in `target/pit-reports/index.html`.
   Discuss.
   - Are there any surprising or interesting insights?
   - Which mutations might be worth fixing? (We will do that in a later exercise.)
   - Is it worth trying to get all 3 coverage metrics to 100 %?
4. Run the Maven goal `mvn -DwithHistory test-compile org.pitest:pitest-maven:mutationCoverage`
   and see how the `withHistory` parameter affects the duration of the mutation
   test run (this is purely for speeding up repeated runs on the same codebase).
   Note: It might be necessary to run it twice to see the actual difference in duration,
   since the history will be generated on the first run.
5. Run the Maven command once via each of the following options:
   - directly from this markdown file (if your IDE integrates a run button into the rendered markdown)
   - via the CLI
   - via the Maven UI within your IDE (if available)
   
   It's good to be familiar with all 3 options.

### Exercise 3: Improve the test suite

*Recommended: The group works as an ensemble.*

Have a closer look at the report for the `GardenBench` class.
Discuss with your peers.
- Which mutations are worth fixing?
- Which ones should we probably fix first?

Add (or improve existing) tests to kill those mutants.

### Exercise 4: Experimentation

*Recommended: The group works as an ensemble.*

Implement a simple program (FizzBuzz, Prime Numbers) without tests. Then add some unit tests.
Run the mutation testing tool and see if you missed any test cases.

Experiment!
- Delete some tests and check the mutation test result.
- Try to create a scenario with as many surviving mutations as possible while still at 100 % line coverage.
- etc.

### Exercise 5: Advanced features

*Recommended: Each participant tries it on their own machine. The group helps in case of problems.*

- PIT uses 1 thread by default. Find out how to increase that, and then
  configure it to use half of your CPU cores. See how it affects the duration
  of a mutation test run.
- PIT allows running the mutation tests only on classes that have been changed
  and are not yet committed to source control. This is much faster than
  running it on the whole code base, and can be used before committing. Find
  out how to do that and try it out.
