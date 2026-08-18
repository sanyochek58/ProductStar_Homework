# BuildProjectSystemGradle

## Описание

Учебный проект, демонстрирующий базовую настройку сборки Java-приложения через Gradle
(Kotlin DSL). `Main` разворачивает строку `"Hello World !"` с помощью
`StringUtils.reverse` из Apache Commons Lang3 и выводит результат в консоль в
кодировке UTF-8.

## Требования

- JDK 17+
- Gradle не нужен — используется Gradle Wrapper (`gradlew` / `gradlew.bat`), версия 9.3.0

## Сборка и запуск

Сборка проекта:

```bash
./gradlew build        # Linux/macOS
gradlew.bat build       # Windows
```

Так как в проекте не подключён плагин `application`, задачи `run` нет.
Быстрее всего запустить `Main` через IDE (IntelliJ IDEA подхватит зависимости
Gradle автоматически). Чтобы запустить из командной строки, нужно явно указать
в classpath jar-файл commons-lang3, который Gradle скачает в локальный кэш при
сборке:

```bash
./gradlew build
java -cp "build/classes/java/main;$(find ~/.gradle/caches -name 'commons-lang3-3.14.0.jar')" Main
```

## Зависимости

### Собственная JAR-библиотека

Проект не подключает собственную собранную JAR-библиотеку — используются
только внешние зависимости из Maven Central.

### Внешние зависимости

- **org.apache.commons:commons-lang3:3.14.0** — используется в `Main.java`
  для реверса строки (`StringUtils.reverse`).
- **JUnit 5 (junit-jupiter, junit-platform-launcher)** — подключены для
  тестирования (`useJUnitPlatform()` в `build.gradle.kts`), тестовых классов
  в проекте пока нет.
