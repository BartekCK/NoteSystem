# NoteSystem

NoteSystem is really a reminder system through which Boss can manage employee time. This app can work like widget.

## Getting Started

If you want to use NoteSystem you can download full demo https://github.com/BartekCK/NoteSystem/releases/tag/v1.0 choosing "NoteSystem.jar". 
You should have MySQL Community Server. Thanks to ***hibernate.cfg.xml*** you can manage your connection with database but if you don't do this,
the database ***note_system*** will automaticly run common configuration. 

### Description and visuals 

Boss Sign in and sign up.

![alt text][BossCreate]
![alt text][BossLogin]

Main boss work panel. On this img boss add his employee.

![alt text][BossPanel]

Boss can send **task list** for his employee.

![alt text][BossPanelAddReminder]
![alt text][NoteForUser]

User (employee) Sign in and sign up.

![alt text][UserCreate]
![alt text][UserLogin]

User main work panel. Employee can see the **task list** from his boss. When employee did the task then can click double to mark job done.

![alt text][UserPanel]
![alt text][UserPanelDone]

User can filer tasks by data.

![alt text][UserPanelFilter]

In the picture we can see how It look's like on worker desktop.

![alt text][employee_desktop]





[employee_desktop]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/employee%20desktop.png "Employee desktop"
[BossCreate]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/BossCreate.png "Boss create"
[BossLogin]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/BossLogin.png "Boss login"
[BossPanel]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/BossPanel.png "Boss panel"
[BossPanelAddReminder]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/BossPanelAddReminder.png "Boss panel add reminder"
[NoteForUser]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/NoteForUser.png "NoteForUser"
[UserCreate]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/UserCreate.png "UserCreate"
[UserLogin]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/UserLogin.png "UserLogin"
[UserPanel]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/UserPanel.png "UserPanel"
[UserPanelDone]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/UserPanelDone.png "UserPanelDone"
[UserPanelFilter]: https://github.com/BartekCK/NoteSystem/blob/master/src/forReadme/UserPanelFilter.png "UserPanelFilter"


### Prerequisites and installing

1. Install [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
2. Set:
```
user: root
password: root
```
2. Install [Java](https://www.java.com/pl/download/)
3. Download [NoteSystem](https://github.com/BartekCK/NoteSystem/releases/tag/v1.0) choosing "NoteSystem.jar"

## Authors

* **Bartłomiej Kotarski**

See also my different [project](https://github.com/BartekCK?tab=repositories).

## License

This project is licensed under the MIT License.
