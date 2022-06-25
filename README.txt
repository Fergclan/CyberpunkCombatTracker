# CyberpunkCombatTracker
This is a small, unofficial, tool for use by GMs/Refs/DMs/etc. to make the combat in the TTRPG Cyberpunk Red by R. Talsorian Games a little bit easier to manage.


How to run: 
I don't have a Linux or Mac machine and don't currently have a VM set up to test in those environments. As such, your mileage may vary with this tool. 

To run this application, you will first need to have Java SE Development Kit 18, which you can pick up for free from oracle's website. https://www.oracle.com/java/technologies/downloads/ Once you have the JDK set up, you will want to run the "CyberpunkCombatTracker.jar"


How to use: 
The 4 text boxes at the top are for automatically giving values to the generated Panels. The text area labeled "Notes" will auto fill new panels with the notes added to the box. The text box labeled "Number to generate" is the amount of panels to freshly generate. Every time the enter button next to it is hit, it will clear all panels and generate the new amount. The text box and accompanying button will add a new number of panels to the end of the list. These will also pull from the same text boxes to decide starting values.

Each panel has a text box at the top for damage, this box is meant for entering the raw amount of damage the character receives. You can select the hit location (body/head) as well as if the damage is Melee or AP. The MX buttons next to Health and Ammo are for saving the target's original health and what their weapons will reload to when the reload button is selected. When a panel takes damage and becomes critically wounded, the panel's background will turn red.


Known Issues: Hitting tab to change the selected box is out of order. 
I need to find a rules clarification about how explosives ablate armor (right now if you select "Head" and "Body", it will deal body damage and ablate both).
The available space for the panels needs to be decreased by about 15 pixels so panels on the edge aren't right up against the scroll bar.
Head armor is not capped at 0, meaning it can go into the negatives. To fix it, you'll have to manually tic it back up to zero.
I can't seem to figure out how to turn this application into an exe using a wrapper like launch4J. Any help would be appreciated. Tips form StackOverflow haven't helped a ton.

About me: 
My group and I play much later than I usually stay awake, so the numbers of combat can get a bit jumbled in my head as the sessions go on. This tool was mostly a fun and usegul project for myself, but I hope some other people can find this useful.
I am just at the beginning of my Java career, and would love constructive criticism/tips to improve my programming. I am also brand new to GitHub, so I apologize for any annoyances and would love constructive criticism/tips. This is my first non-console application after three years of Uni console only work.

If you really like the tool, and would like to buy me a coffee, you can here at: https://ko-fi.com/ferg84532
