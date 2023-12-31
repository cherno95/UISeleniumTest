Небольшие UI-автотесты строки поиска

Используемый фреймворк для поиска элементов на Web-странице: Selenium;
Используемый фреймворк для запуска тестов: allure-junit5;
Используемая библиотека для формирования отчета: io.qameta.allure
Используемая версия Java - 1.8. 
Сборщик проекта: build.gradle

После прохождения сценариев можно сформировать Allure-отчет. Для этого необходимо:
1) Запустить тесты и дождаться их завершения;
2) gradle allureReport - команда позволяет репортировать результат тестов в виде отчета;
3) gradle allureServe - открывает страницу Allure с отчетом.

В данном тесте используется паттерн проектирования: PageObject. 
На странице указаны элементы, с которыми требуется взаимодействовать.

Запуск автотестов:
1) Через терминал "Execute Gradle Task";
2) Ввести "gradle clean test -Ptag=smoke -Pbrowser=chrome -PwebdriverPath=/path/to/webdriver -PbrowserVersion=86 -i", где:
- *gradle* - запускает сборку проекта с помощью системы сборки Gradle.
- *clean* - удаляет все сгенерированные ранее файлы и директории из проекта.
- *test* - запускает тесты в проекте.
- *-Ptag* - передает системное свойство "tag" со значением "smoke" в сборку проекта. Это может использоваться, например, для фильтрации тестов по тегам.
- *-Pbrowser* - указать браузер, на котором будут запущены тесты.
- *-PwebdriverPath* - указать путь, где установлен webdriver.
- *-PbrowserVersion* - указать версию браузера.
- *-i* - включает подробный вывод логов выполнения сборки.

Данный небольшой тест выполнен с целью знакомства с процессом UI-автоматизации. При необходимости можно доработать,
например:
- Настроить Jenkins-Job и через Selenoid запускать тесты в отдельных контейнерах

