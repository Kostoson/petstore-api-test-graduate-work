# <span style="color: white"> Дипломая работа по автоматизации тестовых сценариев API сервиса [Petstore](https://petstore.swagger.io/) </span>

#### Petstore — образец приложения, которое можно использовать для практики REST-запросов. Этот сайт имитирует онлайн-зоомагазин, и пользователи могут добавлять и получать информацию о своих питомцах.
<p align="center">
<img title="petstore" src="media/readme/petstore.jpg">
</p>



## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Команда на запуск тестов сборки Jenkins](#task-команда-на запуск-тестов-сборки-jenkins)
- [Сборка в Jenkins](#jenkins-сборка-в-jenkins)
- [Пример Allure-отчета](#allure-пример-allure-отчета)
- [Интеграция с Allure TestOps](#testops-интеграция-с-allure-testops)
- [Интеграция с Jira](#jira-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#tlg-уведомления-в-telegram-с-использованием-бота)

## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/readme/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/readme/Java.svg"></a>
<a href="https://docs.qameta.io/allure-report/"><img width="6%" title="Allure Report" src="media/readme/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/readme/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/readme/Gradle.svg"></a>
<a href="https://junit.org/junit5/docs/current/user-guide/"><img width="6%" title="JUnit5" src="media/readme/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/readme/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/readme/Jenkins.svg"></a>
<a href="https://telegram.org/?1"><img width="6%" title="Telegram" src="media/readme/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="media/readme/Jira.svg"></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code>.
- В качестве сборщика был использован - <code>Gradle</code>.
- Для тестирования API использованы инструменты <code>REST Assured</code> и <code>Lombock</code>.
- Для удаленного запуска реализована параметризированная джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

### :task: Команда на запуск тестов сборки Jenkins

```
clean
${TASK}
```

### <img src="media/readme/param.svg" title="Параметры сборки" width="4%"/> Параметры сборки

* <code>TASK</code> – задача на прогон тестов. Варианты: <code>regress_test</code>, <code>users_test</code>, <code>store_test</code>, <code>pet_test</code>.



## :jenkins: <a href="https://jenkins.autotests.cloud/job/petstore-api-test-graduate-work/"><img src="media/readme/Jenkins.svg" title="Jenkins" width="4%"/> Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Build" src="media/readme/JenkinsBuild.png">
</p>

## :allure: <a href="https://jenkins.autotests.cloud/job/petstore-api-test-graduate-work/5/allure/"><img src="media/readme/Allure_Report.svg" title="Allure Report" width="4%"/> Пример Allure-отчета</a>


<p align="center">
<img title="Allure Overview" src="media/readme/allureReport.png">
</p>

## :testops: <a href="https://allure.autotests.cloud/project/3477/dashboards"><img src="media/readme/AllureTestOps.svg" title="Allure TestOps" width="4%"/> Интеграция с Allure TestOps</a>

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/readme/Allure.png">
</p>

## :jira: <a href="https://jira.autotests.cloud/browse/HOMEWORK-777"><img src="media/readme/Jira.svg" title="Jira" width="4%"/> Интеграция с Jira</a>

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/readme/jiraTask.png">
</p>

## :tlg: <img width="4%" style="vertical-align:middle" title="Telegram" src="media/readme/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

| ALL PASSED                            | WITH FAILED AND SKIPPED                |
|---------------------------------------|----------------------------------------|
| ![pos](media/readme/notification.png) | ![neg](media/readme/notification2.png) |

