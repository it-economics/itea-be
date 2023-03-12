# itea
### 01 Red Grade `Dont Repeat Yourself (DRY)` Kata

Rules:

* Dont change `existing code` (e.g. no refactoring) until it is specifically asked for in the task
* 100% `code coverage` is required after each task
* Do not read ahead. Do this kata step by step.
* You will find your tasks when there is a title called `... to implement`. This is part of the Kata you have to do.


Introduction:

The `itea furniture store` is a new startup that sells all kinds of goods in their stores.

Until now, they did all the price calculation `manually` by hand! What a `waste` of time.
Now the new itea application will be implemented (finally!).

They would like to start with the `checkout` process.
Some developers already started implementing an `endpoint` for that. The endpoint can now calculate the price of a picture
(or two or three pictures). Even some tests are implemented. Will be easy to implement the next `storys` right?

Now you get hired. The Developer Team has implemented the first Storys for the last two week.
And there are still plenty of Storys to implement. Now it is your time to show your developing skills!

So the `Product Owner` calls you.

"Hey I am `Steve` your new PO. Nice to meet you. But we dont have time for smalltalk. Storys have to be implemented!
The customer is waiting. We are behind the schedule! Here are your first Storys. Dont disappoint me.
Do it `quick`. No thinking required on the `green field` project right? Just `copy and paste` like you guys always do."

Then he hangs up. What a `cool` guy you think.
You see a new message from `Steve` for you.

"Next Story is '0013 - Calculate a price for a Chair'"

That sounds easy! Just go! Time is money!

-----
Here are the tasks that you have to implement for this Kata:

### First Task to implement:

1. '0013 - Calculate a price for a chair' 
   1. As a cashier I want to select a chair on the UI (Already implemented from the UI team. Nothing todo for you.)
   2. The `Price` should be calculated like the price from the picture. One `chair` costs `49.99 Euros`.
   3. The `Receipt` text should have the chair and the amount of chairs
   4. (Remember just copy and paste the old stuff. No thinking)

Now you have implemented your first Story. Nice! 
You feel proud of yourself, and you go to the kitchen to get a coffee.

As you came back you see a message from `Steve`.
"Hello there. I tested your Story already. I made a `mistake` in the previous Story.
`Sorry` for that. But the price for the chair is actually `149.99`! That would be a big `loss` if this would be released!!
Here is the second Story: '0026 - Change price for a chair'"

----

So here we go again. How bad can be a price change in the Code?
Just replace it. No big deal.

### Second Task to implement:

2. '0026 - Calculate a price for a chair'
   1. Change the price for a chair to `149.99`

---

You are not as proud as before. You realise something.

You have to change the price in `two` places.
That is not all. You see many places where the code is `duplicated`!!
Who implements such code you ask yourself?

You better refactor this code. Your teams productivity will go from `10 storys` per hour to `0 storys`if you dont refactor the code `now`!

Then `Steve` writes you.

"Hey. Thanks for updating the price. I have the next Story '0045' for you."

You `immediately` write him that you have to `clean up the code` before the next story. Otherwise, the code will not be `maintainable`.

"Okay. But why didnt you do that in the `first place`? Now we have lost time. But okay. Do it `quick` then back to work!"

He does not sound happy about it. So lets quickly have a look at the code and refactor some stuff.

### Third Task to implement:

3. `Clean up the code` and remove duplications
   1. You should ask yourself the following questions:
      1. Where are `duplications`?
      2. Can you remove the duplication without changing the `tests`?
      3. Why are duplications so `dangerous` here?

---
