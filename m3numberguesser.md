<table><tr><td> <em>Assignment: </em> IT114 - Number Guesser</td></tr>
<tr><td> <em>Student: </em> Ryan Lim (rl433)</td></tr>
<tr><td> <em>Generated: </em> 2/13/2023 8:34:46 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-number-guesser/grade/rl433" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create the below branch name</li><li>Implement the NumberGuess4 example from the lesson/slides</li><li>Add/commit the files as-is from the lesson material (this is the base template)</li><li>Pick two (2) of the following options to implement</li><ol><li>Display higher or lower as a hint after a wrong guess</li><li>Implement anti-data tampering of the save file data (reject user direct edits)</li><li>Add a difficulty selector that adjusts the max strikes per level</li><li>Display a cold, warm, hot indicator based on how close to the correct value the guess is (example, 10 numbers away is cold, 5 numbers away is warm, 2 numbers away is hot; adjust these per your preference)</li><li>Add a hint command that can be used once per level and only after 2 strikes have been used that reduces the range around the correct number (i.e., number is 5 and range is initially 1-15, new range could be 3-8 as a hint)</li><li>Implement separate save files based on a "What's your name?" prompt at the start of the game</li></ol><li>Fill in the below deliverables</li><li>Create an m3_submission.md file and fill in the markdown from this tool when you're done</li><li>Git add/commit/push your changes to the HW branch</li><li>Create a pull request to main</li><li>Complete the pull request</li><li>Grab the link to the m3_submission.md from the main branch and submit that direct link to github</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Implementation 1 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/218610218-e40da9a1-45cf-47d6-93a9-ecc2b380644f.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>This for problem 1. The code displays tells the user if the number<br>is higher or lower<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/218611130-d0fb8143-f4ad-4113-85ba-eac242594df3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the code running<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>The method that I did was adding an if statement. How it works<br>is, the number that the user inputs is the guess number and if<br>that number is greater then the actual number it will display lower giving<br>a hint to the guesser that the number is lower and the same<br>for if the guess number is higher.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Implementation 2 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/218612683-2d057cb7-b82c-4512-a22d-13147f49b1e0.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the code that I implemented for problem 4<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/218612974-ed91fa5d-a303-4a1c-88cd-e6da2feb70ec.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the code when it runs<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <div>I created an int variable diff, which is going to take the number<br>that is actually the number and subtract it from the user guess. After<br>that it will take the diff number and run through the if statements.<br>First if statement is when the diff number is less then or equal<br>to 2, which means if the number is less then two numbers away,<br>then a message will appear telling the user that the number that he<br>guessed is very close to the actual number. It is the same for<br>the else if and else statements except it will display warm if the<br>users guess is 5 numbers away and cold if the number is anything<br>else greater then 6.</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a link to the related pull request of this hw</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/rl433/IT114-008/pull/3">https://github.com/rl433/IT114-008/pull/3</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Discuss anything you learned during this lesson/hw or any struggles you had</td></tr>
<tr><td> <em>Response:</em> <p>A struggle that I had with the homework was understanding how to do<br>the cold, warm, and hot part of the problem. By creating another variable<br>and having the variable be set to Math.abs(number-guess). I was able to solve<br>the problem because when doing this method it takes the number and subtracts<br>the guessing number and whatever that number is if the number is less<br>then 2, 5 or 10 then it will display the proper message.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-number-guesser/grade/rl433" target="_blank">Grading</a></td></tr></table>