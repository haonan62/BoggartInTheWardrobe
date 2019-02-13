# BoggartInTheWardrobe
Multithreaded Boggart Simulation
We all have fears, it is important to confront our fears before our enemies can exploit them. In the book Harry Potter, Hogwarts magic school uses a harmless magical creature called Boggart placed inside a Wardrobe(container) to train students, these creatures are capable of transforming into fears of their victims.

"A Boggart is a shape-shifting creature that will assume the form of whatever frightens the person who encounters it. "------- A Boggart’s basic nature
Retrieved from https://harrypotter.fandom.com/wiki/Boggart


Contrary to the book’s description, a person has more than one fear, therefore Hogwarts School designed a training program to help junior wizards confront their fears iteratively. The motivation for the students is improving the scores of their houses on the score board. 

The school places several wardrobes in the examination hall, each contains a Boggart. Several Instructors are also present at this setup to deal with emergencies. When the target student enters the wardrobe, the boggart will iteratively transform into the wizard’s feared objects, and the student should cast spells on it to transform it back while remaining calm. 

Every time the boggart transforms back to its original form, the wardrobe awards the wizard’s respective school based on the time taken(the shorter the time, the higher the score).The junior wizard is considered completing the trail when all his fears have been removed, then the wardrobe automatically records the success to the common registry. When the student is scared (1% chance everytime the boggart transforms), the instructor will help the student, then fail the student and subtract 100 points from the wizard’s school. Then the next student goes into the wardrobe.

At the end of the program, the sum of fail and success records should add up to the student number in the main thread. Meanwhile, there is a score board displaying which house has the highest points.


The project should be multithreaded: as each Boggart can only transform into one object a time, and there are far too many students to be trained. Also, it takes time for transformation and casting spells, as reflected by the thread.sleep method in source code.
A single threaded program means that the training speed as well as the examination speed would be much slower, resulting in prolonged examination time.
Take the boggarts as exam papers, we all attempt out papers in parallel right?
