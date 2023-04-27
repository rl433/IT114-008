<table><tr><td> <em>Assignment: </em> IT114 RPS Milestone 2</td></tr>
<tr><td> <em>Student: </em> Ryan Lim (rl433)</td></tr>
<tr><td> <em>Generated: </em> 4/27/2023 12:09:30 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-rps-milestone-2/grade/rl433" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp;<a href="https://docs.google.com/document/d/11SRMo7JkLAMM-PuuiGwl_Z-QXP3pyQ7xN3lRxwmcwCc/view">https://docs.google.com/document/d/11SRMo7JkLAMM-PuuiGwl_Z-QXP3pyQ7xN3lRxwmcwCc/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/231857995-5aeb8027-d26b-4d76-9850-d8698b2feea2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing Payload Code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/231858173-2f74fc21-63e2-467a-9c3b-0556b3438a53.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Setters and Getters for client and clientId<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/231858391-b5053d9b-f59e-4eeb-8bac-ec1609b6fc9f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Setter and Getter for message<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/231858800-939c2c26-3038-433b-9863-e19e7d1fa15a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>toString message<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/231859512-81863407-aa8a-4d00-b312-2925b6997abb.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing payload through Server<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234441725-899b275e-f460-4a99-96f3-9417edb704b0.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing that client is being set to the first clientId and joining the<br>serverroom as well as showing the client that they joined the lobby<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234442096-794a6574-360a-4bfd-b884-764bfed51ad0.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing that second client is being set second clientId and joining the serverroom<br>as well as showing the client that they joined the lobby<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Game Play Code </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code related to the game flow</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234443055-4049b8a4-f603-400b-bce7-39dbdbb53732.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing how players are in the game and playerA being the active as<br>well as playerB being other player. This helps with separating players.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234443348-c4737c5d-a3bf-4f16-9e58-e7da2a3a9aa0.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing terminal on how the players use /choice RPS to make a choice<br><br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234664239-4b6f5dbe-b465-4579-a9b6-dc14406b4bbc.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the code for players choices<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234666727-74e2bbe8-696e-45a7-998d-25d446bf2c90.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing timeExpired method for when the players don&#39;t make a choice<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234667694-afaf3dc2-2815-4e1a-bbbe-f222ae3ed457.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code for checking outcomes that returns 0 if string a equals b. Returns<br>1 if any of the players beat each other. Returns -1 if players<br>lost<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234674340-20cb68fd-c232-4f7a-bd09-6d6ceb4e8fbe.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Continuneing on showing the game logic of outcome because we set outcome to<br>an int that is equal to checkOutcome<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234670573-f24a642f-8b82-488c-a8e8-89fab33289cf.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the syncReadyStatus method which tells the serverplayer if serverplayer client is ready<br>then it is going to send success, a boolean statement that gets the<br>clientId who is ready, to the serverthread and if not success then it<br>will go the handledisconnect method.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234669058-cc77f4b2-d91a-4f2e-9813-01f464f721d5.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the game logic of outcome because we set outcome to an int<br>that is equal to checkOutcome<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234749015-c721cb2d-4224-49d4-93bc-5653f22cbb60.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the Syncing resetSession because if players are done with the game then<br>a message would appear telling the client users on how to reset the<br>game.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234749369-0c5195c8-45ac-4d98-9a7c-6b2c70c0845a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the syncing start for when the game starts it will display to<br>the users that the game has started<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234750064-bd3476c8-ad6b-4570-ba2d-01ba993af9b1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing if remain players equals 1 then that player is the winner. If<br>it equals to 0 then a tie. If it is greater then 1<br>then the game resets<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234750542-f2aa05c1-4281-45e4-977f-8522a6a63ddd.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing code for players that are eliminated<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the Game flow code at a high level</td></tr>
<tr><td> <em>Response:</em> <p>First you would have to do ./build.sh Project server and then ./run.sh Project<br>server to compile and run the server side of the code in the<br>terminal. For your players they would just have to do ./run.sh Project client<br>to make the terminal a player. Once that is done, /name name which<br>would be the next step that sets a certain that the user types<br>in to one of the clients making it different for each clientId or<br>clientName. /connect localhost:3000 that allows the clients or users to connect to the<br>server that then leads them to a chat lobby where they are able<br>to type to each other if and only if they connect to the<br>local server. The next step would be for one of the players to<br>do /createroom which creates a separate room in the server that allows certain<br>users to if they like to join a separate chat room from the<br>lobby. Doing /joinroom would allow the user to join the created room to<br>either type of play Rock, Paper, Scissors(RPS). To play the&nbsp; game RPS, there<br>has to be more then one player in the lobby and all players<br>would have to type /ready and wait 15 seconds for every player to<br>type /ready. If not enough players are ready then the game will not<br>run and display a message to everyone saying that not enough players are<br>ready and would restart the ready message again. Once all players are ready,<br>they would have to do /choice R, P, S, or skip to make<br>a choice with R being rock, P being paper, S being scissor, or<br>skip so that they skip their turn. Doing skip would make the player<br>automatically lose and would make them spectate the entire game until there is<br>one winner. Each picking phase is 15 seconds long so if by chance<br>a player didn&#39;t make a decision they will automatically lose. When all players<br>make a decision, they are put up against each other. If the first<br>player loses they lose, but if they tie with the next player then<br>they will still be in the game. Finally, when all players go if<br>there is only one then a message will appear showing that the last<br>player has won. If there is still more then one player then the<br>game will repeat until there is only one player standing.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Game Evidence </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the terminal output of a working game flow</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234751303-16b17397-edda-4d3f-84cb-d3615d6071e2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing terminal of players picking as well as the output of a winner<br>and loser<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234751527-e02e4710-23ef-4773-a49b-3effd3a07b11.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing terminal of when a player is skipped when they don&#39;t make a<br>decision<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234751908-b0bc1a8a-a187-4c64-8d23-7f0166a4ffe9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing terminal of when players tie<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/234752079-298de5e4-b80e-44f8-accc-85ed98be2b01.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows terminal of when there is only one player left<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/rl433/IT114-008/pull/7">https://github.com/rl433/IT114-008/pull/7</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-rps-milestone-2/grade/rl433" target="_blank">Grading</a></td></tr></table>