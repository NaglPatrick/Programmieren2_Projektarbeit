# ISchedule

## Description

This project is an easy Scheduler for Professors(Admin), Assistants and Students. 
Due to time problems, not all intended functions which would have increased the usability are available.
Also, there is no Database, so all changes made are lost after closing of program.
If someone doesn't like the blunt design, he or she is welcome to help me, since I am not a designer and won't ever be one ;)

## Autor
Patrick Nagl

## Specifications

### General:
It is intended that courses are made by Admin and Assistant before students can enroll. Later collisions are not being handled.
Also, communication between Admin and Assistants before booking courses should be a given ;)


### Admins:

+ can create rooms
+ can create new courses
+ can create specific course with time, room and weekday
+ cannot yet specify the lector of the course other than self
+ cannot create collisions (yet)
+ can delete entire courses
+ can delete rooms
+ can delete specific course (also if not lector)


### Assistant:

+ can create courses with time, room and weekday
+ cannot specify lector of the course other than self (stays that way)
+ cannot create collisions
+ can delete specific course (only if self lector)


### Student:

+ can see courses, and also all times they are
+ can enroll in course if there is no time collision with other courses
+ can withdraw from course

### Timetable:
It shows the week and relative time of courses the user attends to.
In a later version it is planned, that Admin can also see of Assistants
Unfixed issue: it doesn't close or update automatically if you perform an action in menu,
and it will open more than once

## Predefined
if you want to test the program without creating users or courses or rooms, there are some predefined ones.

+ ### Admin: 
    Username: Master

    Password: 4321
+ ### Assiastant1: 
    Username: Matze

    Password: password
+ ### Assistant2:
    Username: Dominik

    Password: 1234
+ ### Student: 
    Username: Vilja

    Password: password

+ ### Rooms and Courses:
    You will find out.




