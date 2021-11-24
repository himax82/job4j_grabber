[![Build Status](https://app.travis-ci.com/himax82/job4j_grabber.svg?branch=master)](https://app.travis-ci.com/himax82/job4j_grabber)
[![codecov](https://codecov.io/gh/himax82/job4j_grabber/branch/master/graph/badge.svg?token=SXTGPK09TW)](https://codecov.io/gh/himax82/job4j_grabber)

## О проекте
Парсер вакансий для сайта https://www.sql.ru/forum/job-offers/.
Ищет вакансии для Java программистов и сохраняет их в базе данных.
С заданным интервал выполняет акутуализацию имеющейся информации.
Интервал между запусками и параметры БД указываются в файле app.properties.

## Технологии
- Java Core
- Quartz-scheduler
- JSOUP
- JDBC (PostgreSQL)
- JUnit
