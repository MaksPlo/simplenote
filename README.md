# SimpleNote

===== Introduction

SimpleNote is a demo project wich use technologies and tools on backend:

- Java 8 
- Spring boot (https://spring.io/projects/spring-boot)
- Spring Security (https://spring.io/projects/spring-security)
- Spring Session (https://spring.io/projects/spring-session)
- Spring Data (https://spring.io/projects/spring-data)
- Junit (https://junit.org/junit4/javadoc/latest/index.html)
- Mockito (https://site.mockito.org/)
- FlyWay (https://flywaydb.org/documentation/)
- PostgreSQL (https://www.postgresql.org/docs/)
- Mongo DB (https://docs.mongodb.com/guides/)
- Swagger (https://swagger.io/docs/)
- Lombok (https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)

and on frontend:

- JS 
- Vue (https://vuejs.org/v2/guide/)
- Vuetify (https://vuetifyjs.com/ru/getting-started/quick-start/)
- Node.js (https://nodejs.org/en/docs/)

==How it work==

Project start from login form. 

![login alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/login.png)

For authentication, gmail OAuth 2.0 is used, the token is provided by Google API.

![google form alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/google_form.png)

After authentication user sees the main interface in which there are input form for title and tet of note and filter form.

![interface alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/interface.png)


User can add note after click to button "save".
![writing note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/note_writing.png)
![first note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/add_first_note.png)

User can add many notes.

![second note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/add_second_note.png)

User can edit note text
![edit note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/update_second_note.png)

And delete note
![delete note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/remove_first_note.png)

Also user can filtering notes
![note for filter alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/add_note_to_filtering.png)
![filtering note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/filtering_example.png)

The user can see only his notes.
![first user note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/other_user.png)
![second user note alt](https://github.com/MaksPlo/simplenote/raw/master/src/main/resources/images/update_second_note.png)

