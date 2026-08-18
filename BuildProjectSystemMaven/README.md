# BuildProjectSystemMaven

Учебный проект, демонстрирующий базовую настройку системы сборки **Maven**: структуру
`pom.xml`, подключение внешней зависимости из Maven Central и сборку/запуск приложения
через стандартный жизненный цикл Maven.

## Функционал

Приложение состоит из одного класса `Main`, который переворачивает строку с помощью
метода `StringUtils.reverse()` из библиотеки Apache Commons Lang3 и выводит результат
в консоль в кодировке UTF-8.

```
Hello World ! -> ! dlroW olleH
```

## Требования

- JDK 21
- Maven 3.9+ (локально установленный; в проекте не используется Maven Wrapper)

## Сборка и запуск

Компиляция проекта:

```bash
mvn clean compile
```

Сборка jar-файла (без зависимостей в манифесте):

```bash
mvn clean package
```

Запуск через плагин `exec` (без предварительного объявления плагина в `pom.xml`,
поэтому указывается полная координата плагина):

```bash
mvn org.codehaus.mojo:exec-maven-plugin:3.1.0:java -Dexec.mainClass="Main"
```

Альтернативно — запуск из IDE (IntelliJ IDEA определяет зависимости из `pom.xml`
автоматически) или вручную, собрав classpath:

```bash
mvn dependency:build-classpath -Dmdep.outputFile=cp.txt
java -cp "target/classes;$(cat cp.txt)" Main
```

## Зависимости

### Внешняя зависимость

Проект подключает одну внешнюю зависимость из Maven Central, объявленную в `pom.xml`:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.20.0</version>
    <scope>compile</scope>
</dependency>
```

Она используется в `src/main/java/Main.java` для вызова `StringUtils.reverse(String)`.
Maven автоматически скачивает jar-файл библиотеки из центрального репозитория и добавляет
его в classpath при компиляции и запуске.

### Собственная JAR-библиотека

На данный момент проект **не подключает** собственную (локальную) JAR-библиотеку —
используется только внешняя зависимость из Maven Central. Если потребуется подключить
собственную библиотеку (например, jar, собранный из другого учебного проекта), это можно
сделать одним из способов:

- установить jar в локальный `.m2`-репозиторий и подключить как обычную зависимость:

  ```bash
  mvn install:install-file -Dfile=my-lib.jar -DgroupId=org.example \
      -DartifactId=my-lib -Dversion=1.0 -Dpackaging=jar
  ```

  и добавить в `pom.xml`:

  ```xml
  <dependency>
      <groupId>org.example</groupId>
      <artifactId>my-lib</artifactId>
      <version>1.0</version>
  </dependency>
  ```

- либо подключить jar напрямую через `scope=system`, указав путь до файла в `systemPath`.
