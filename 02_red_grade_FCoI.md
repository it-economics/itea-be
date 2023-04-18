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
and chairs. At the moment there is only one type of picture and one type of chairs. Because the demand of those two
products is really high and the business is thriving the company wants to add more products.

After a brainstorming session the management decides to focus on pictures and chairs and to add more types of it to their
stores. As a developer they ask you and one of your colleagues to adapt the software to meet the new requirements.

-----
Here are the tasks that you have to implement for this Kata:

### First Task to implement:

'0070 - Add picture products' 
   1. From now on stores sell the following pictures:
      1. "PictureNorway" for 9.99 EUR
      2. "PictureSweden" for 12.99 EUR
      3. "PictureFinland" for 14.99 EUR
   2. Just create a class for each picture product and extend PicturesDto. Adapt PicturesDto if necessary. It needs to be done quick and easy so the software can go live asap.

Now you have implemented your first Story. Nice! 
You feel proud of yourself, and call it a day.

As you came back next day you see a message from your colleague `Tom` who was supposed to complete the changes for the chair products.
"Hello there. I am sorry, I can't come to work today. I got the flu and need to lie in bed all day. Can you please complete my task with the chair products?"
Of course, you don't hesitate and reply that he doesn't need to worry, you take care of it.

Here is the second Story: '0027 - Add chair products'

----

### Second Task to implement:

'0027 - Add chair products'
   1. From now on the stores sell the following chairs
      1. "ChairElsa", 4 legs, 1kg, plastic, 19.99 EUR
      2. "ChairKnut", 3 legs, 2kg, wood, 32.99 EUR
      3. "ChairLars", 5 legs, 4kg, metal, 49.99 EUR
   2. Just create a class for each chair product and extend ChairDto. Adapt ChairDto if necessary. It needs to be done quick and easy so the software can go live asap.

---

You are not as proud as before. And the software finally goes live so your company can even thrive more.

Of course, you already noticed that even if your implementation was quick and easy it also caused some technical debt.
So now where the software is already running you have all the time of the world to do some refactoring.

### Third Task to implement:

1. `Clean up the code` (only) for the picture products
   1. Try to reduce the number of picture classes
   2. Make it as easy as possible to add new picture products

---

Now that you can easily add more picture products in the company you want to so the same for chair products:

### Fourth Task to implement:

1. Now `Clean up the code` also for the chair products
   1. Try to reduce the number of chair classes
   2. Make it as easy as possible to add new chair products

---

After some thinking you wonder if you can improve your code even more.

### Third Task to implement:

1. `Optimice your code`
   1. Can you reduce the number of classes even more? If yes, does it make sense?
   2. Does it make sense to add interface to your existing code? If yes, where and does it make sense?