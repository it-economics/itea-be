# itea
### 02 Red Grade `Favor Composition over Inheritabce (FCoI)` Kata

Rules:

* Don't change `existing code` (e.g. no refactoring) until it is specifically asked for in the task
* 100% `code coverage` is required after each task
* Do not read ahead. Do this kata step by step.
* You will find your tasks when there is a title called `... to implement`. This is part of the Kata you have to do.


Introduction:

The `itea furniture store` is a new startup that sells all kinds of goods in their stores.

In the last step a `checkout` process was implemented. The endpoint can calculate the price of pictures
and chairs. At the moment there is only one type of picture and one type of chairs. The company also already added another
product: a table (one type). Due to a high demand of those products the business is thriving and the company 
wants to add even more products.

After a brainstorming session the management decides to focus on pictures, tables and chairs and to add more types of it to their
stores. As a developer they ask you to adapt the software to meet the new requirements.

-----
Here are the tasks that you have to implement for this Kata:

### First Task to implement:

'0027 - Add chair products'
   1. From now on the stores sell the following chairs
      1. "ChairElsa", 4 legs (5 EUR each), plate (5 EUR), chairback (5 EUR), plastic material
      2. "ChairKnut", 3 legs (4 EUR each), plate (10 EUR), chairback (15 EUR), wood material
      3. "ChairLars", 5 legs (2 EUR each), plate (20 EUR), chairback (30 EUR), metal material
   2. From now on the stores sell the following tables
      1. "TableLotta", 4 legs (10 EUR), plate (30 EUR), plastic material
      2. "TableLola", 4 legs (20 EUR), plate (50 EUR), wood material
   3. Just create a class for each chair/table product with its implementation and extend ChairDto/TableDto. Adapt ChairDto/TableDto if necessary. It needs to be done quick and easy so the software can go live asap.

---

The software finally goes live so your company can even thrive more.

Of course, you already noticed that even if your implementation was quick and easy it also caused some technical debt.
So now where the software is already running you have all the time of the world to do some refactoring.

### Second Task to implement:

1. `Clean up the code` (only) for the chair and table products
   1. Try to reduce the number of chair/table classes
   2. Make it as easy as possible to add new chair products
   3. Seperate chairs from table so that ChairsDto does not extend TablesDto anymore

---

If you have still time left you can try to do even more refactoring or do the bonus task below.

### Bonus Task to implement:

'0070 - Add picture products'
1. From now on stores sell the following pictures:
    1. "PictureNorway" for 9.99 EUR
    2. "PictureSweden" for 12.99 EUR
    3. "PictureFinland" for 14.99 EUR
Add them to the itea software in a good way.