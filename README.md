# Doyano-EJB
Doyano is a distributed enterprise system that can assist people in asking questions and getting answers via messages. It has the following functionalities:

1. Users can post questions, or answers to other user’s questions
2. Users can mark follow or like of other uses. As a result, a user can follow other users while at the same time can be followed by other users.
3. Users can rate questions or topics, such as giving thumbs up and down. The system can automatically promote questions with higher ranking, and filter out those less informative or invalid answers. 
4. Each person has a person rank, and every operation can affect a person’s rank, such as the thumb ups one received from others. Each person has his rank in every category starting at 0, the more thumbs up for posts adds to the users person rank in that category.
5. Users can tag each other in posts or send private messages
6. Users get email notification when specified users update their status.

There are 2 projects, Doyano-EJB-Session-Entity (with session and entity beans) and Doyano with the servlet alone. The servlet project is the one that runs on a server. The EJB project should be exported as a jar, and should be pasted in the Webcontent/WEB-INF/lib directory of the servlet project.

Internally, Doyano uses H2 database for its data storage solution, and it is deployed in the JBoss application server. It integrate the data source and the application with ESB (ServiceMix, Camel, ActiveMQ) and it uses AJAX technique to a few places to make the user interface more interactive.

It also contains a small test harness to test the latency for queries.
