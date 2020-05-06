# SimpleNote

### Introduction

SimpleNote is a toy project which aims to demo Java 8 + Spring Boot + Vue.
The project consists of two parts: a backend on Java + Spring Boot and a web frontend on Vue.

The backend uses:

- Java 8 
- Spring boot (https://spring.io/projects/spring-boot)
- Spring Security (https://spring.io/projects/spring-security)
- Spring Session (https://spring.io/projects/spring-session)
- Spring Data (https://spring.io/projects/spring-data)
- JUnit (https://junit.org/junit4/javadoc/latest/index.html)
- Mockito (https://site.mockito.org/)
- FlyWay (https://flywaydb.org/documentation/)
- PostgreSQL (https://www.postgresql.org/docs/)
- Mongo DB (https://docs.mongodb.com/guides/)
- Swagger (https://swagger.io/docs/)
- Lombok (https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)

The frontend uses:

- JS 
- Vue (https://vuejs.org/v2/guide/)
- Vuetify (https://vuetifyjs.com/ru/getting-started/quick-start/)
- Node.js (https://nodejs.org/en/docs/)

### How to use the app

Project start from login form. 

![login alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/login.png)

For the authentication the project uses OAuth 2.0 with Google API providing tokens.

![google form alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/google_form.png)

After the authentication a user sees the main page consisting of a form for adding new notes:

![interface alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/interface.png)

... and the list of their notes:

![second note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/add_second_note.png)


A user can create, filter, edit and delete their notes.
![writing note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/note_writing.png)
![first note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/add_first_note.png)
![edit note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/update_second_note.png)
![delete note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/remove_first_note.png)
![note for filter alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/add_note_to_filtering.png)
![filtering note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/filtering_example.png)

The user can see only his notes.
![first user note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/other_user.png)
![second user note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/update_second_note.png)

