# itea - userDto management
### 04 Orange Grade: Single Responsibility Principle (SRP)

Rules:

* Don't change `existing code` (e.g. no refactoring) until it is specifically asked for in the task
* 100% `code coverage` is required after each task
* Do not read ahead. Do this kata step by step.
* You will find your tasks when there is a title called `... to implement`. This is part of the Kata you have to do.


Introduction:

The `itea furniture store` is a new startup that sells all kinds of goods in their stores. 

After implementing the garden bench you take a vacation for 2 Weeks. 
Well deserved!! You did a bunch of stuff in the last weeks.

<img src="./src/main/resources/img/vacation.png">

After your vacation you get back to work.
You see that your team has implemented some ticket. Nice!
But what is that?!? Suddenly your application has a User-Management.
You take a closer look into the new implemented class. What a bad code you think. Luckily it is not used yet.
Luckily you took your collection of books into your vacation! Uncle Bob and the other clever books.
And now you know all about the SRP or Single Responsibility Principle.
Let's take a closer look at the new implemented code and refactor that mess! 

-----
Here are the tasks that you have to implement for this Kata:

<b> Note: You might note several 'issues' with the code while working on the tasks. Try to stick to the actual task without cleaning up too much. You can always do that later.</b>

### First Task to implement:

'Have a look at the new Class UserManagement and the Tests for it' 
   1. Which places look odd to you? (Discuss it in your group)
   2. If you have found and discussed at least three bad places start changing them.
   3. Only do this one by one. Run the test after every little step.
   4. If you find some spots that are not tested please test them.

---

### Second Task to implement:

After you have made a look of improvements your PO comes to you and says.
"Man you have to hurry up with those stuff. We have a lot of tickets in the Backlog! Go Go Go"

Add Birthdays to the Users:
   1. Implement a Method in the UserManagement that gives the Persons that have the same Birthday.
   2. Where do you need to change something? Is it easier to modify the code?