# CodeMystics_Project


## App name: Emission Ease
### Theme: Lifestyle and climate change

### Documentation
1. Wireframes PDF
2. prototype
3. Intial idea
4. Presentation
5. Project

### Backend development Description

1. IDE used : Intellij
2. Language : Java 
3. Database : MongoDB 
4. Plan Deployment : To AWS EC2

<br>
High level details of the backend:
<br>
The Connection class initiated a connection to the MongoDB. This class also set up the Database and the required tables and provide them for use in other classes. 
<br> The Create class handle all data insertion operation to the MongoDB. We can pass in any object of class implementing DataModel to it to be written into the Database. 
<br> The Read class handle the data retrieve operation from MongoDB. 
<br> MysticApplication class is the entry point of the web application. It will handle Http Request based on the URLs specified. 
<br> The rest of the classes are modal classes and controller classes to interact with the database. 

The UML is available in [link](https://asset.cloudinary.com/dlf1ttson/559f990f6fcfa4e9a18cd0673387c66b)


