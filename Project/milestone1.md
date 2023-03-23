<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Ryan Lim (rl433)</td></tr>
<tr><td> <em>Generated: </em> 3/23/2023 2:34:06 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/rl433" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/222546586-9842ad2b-4f52-4b9d-aecc-0950cd35080c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server being started running!<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/222546586-9842ad2b-4f52-4b9d-aecc-0950cd35080c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Left is the Server side and Right is the Client side. Client waiting<br>for input<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>As the server is trying to listen to the client, the server needs<br>to know what port it needs to listen too. So by typing connect<br>localhost:3000, it displays a message that the server connected and is now listening<br>to port 3000. So if you have multiple client you must always input<br>connect localhost:3000 so that the messages are able to be able to receive<br>it at the server end. During the client side it needs to know<br>the server address and what port the server is listening too so it<br>can be connected successfully.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/223213358-e309400a-c75d-4d44-8172-a40c5d156417.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Left side is Server while the middle and right sides are Clients. Showing<br>clients that have names that was inputted by the users and sending messages<br>to the each other through the server broadcasting.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/223215143-61bd6a8d-9448-46e5-92f8-46d7b393fb44.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the clients both created different rooms and both sending messages, but both<br>aren&#39;t able to receive the messages sent.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <p>The server accepts connections and adds the socket referencing to a room while<br>the ServerThread representing a single client on the server, handles sending/receiving data over<br>socket connection. By using /joinroom command the messages are only being sent to<br>clients that joined the room. So if the client is not in the<br>room then they wouldn&#39;t be able to receive messages. Using the command /createroom,<br>it creates a room by the user and when another user types /joinroom,<br>the user is able to join the room that was created and viscera.<br>This leads to everyone that is inside the room being able to send<br>and receive messages.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/223221479-4daac081-92d5-4428-99b4-c4c16c6be3e5.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>The left side is Server. All other three terminals are Clients. This shows<br>that the client from the left disconnected from the server, but since the<br>other two clients didn&#39;t disconnect they are able to message each other.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/223222268-861942d4-7828-4170-a8e5-fa72de8f9b70.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing that the server side is terminated, but the clients are still running<br>even though it isn&#39;t connected to the server.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407761/223224982-a74bb93b-7ff3-4b25-8fb8-c1d3b85a6833.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing that when the client disconnects from the server, the server displays a<br>message saying that the thread was disconnected from the server. Not only that<br>but from the client sides they display a message saying that one of<br>the users disconnected from the server, but the other two clients are able<br>to send message to each other still. <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <div>Terminating the server is using control+c and this leads to the clients disconnecting<br>from the server, but are still running. The clients don't crash when the<br>server is terminated because the only way the clients are terminated is when<br>entering "quit". This in turn closes all connection and the server does not<br>crash when the client(s) disconnects just like client not crashing when terminating the<br>server.</div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/rl433/IT114-008/pull/6">https://github.com/rl433/IT114-008/pull/6</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p>Some issues that I had was when doing this milestone was creating rooms<br>or joining a created room. So to find the solution I looking through<br>the slides from previous lessons and it was /createroom_name of room as well<br>as /joinroom_name of room to join a room. Another problem I had was<br>trying to figure out how to create names as well as connecting to<br>the server. So by looking over the slides and notes I was able<br>to find that creating a name for the client was /name your name<br>and for connecting to the server was using /connect localhost:3000. These were some<br>of the ways that I fixed my issues while going to office hours<br>from the professor.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/rl433" target="_blank">Grading</a></td></tr></table>
