# BuildProjectSystemBazel

## Описание

Учебный проект, демонстрирующий базовую настройку сборки Java-приложения через **Bazel**
(с использованием Bzlmod, `MODULE.bazel`). `Main` разворачивает строку `"Hello World !"`
с помощью `StringUtils.reverse` из Apache Commons Lang3 и выводит результат в консоль
в кодировке UTF-8. Это Bazel-аналог соседних проектов `BuildProjectSystemMaven` и
`BuildProjectSystemGradle` — та же логика, но с другой системой сборки.

## Требования

- JDK 17+ (доступен в `PATH` либо через настроенный Bazel Java-toolchain)
- Bazel не нужно устанавливать вручную — рекомендуется [Bazelisk](https://github.com/bazelbuild/bazelisk),
  который сам подтянет версию Bazel, указанную в `.bazelversion` (7.4.1)

## Сборка и запуск

Сборка проекта:

```bash
bazel build //:main
```

Запуск:

```bash
bazel run //:main
```

Ожидаемый вывод:

```
! dlroW olleH
```

## Структура проекта

```
BuildProjectSystemBazel/
├── MODULE.bazel          # объявление модуля и внешних зависимостей (Bzlmod)
├── BUILD.bazel            # цель сборки java_binary
├── .bazelversion          # версия Bazel для Bazelisk
└── src/main/java/Main.java
```

## Зависимости

### Собственная JAR-библиотека

Проект не подключает собственную собранную JAR-библиотеку — используются только внешние
зависимости, разрешаемые Bazel через Maven Central. При необходимости подключить локальный
jar его можно объявить как `java_import`:

```python
java_import(
    name = "my_lib",
    jars = ["libs/my-lib.jar"],
)
```

и добавить `":my_lib"` в `deps` цели `java_binary`.

### Внешние зависимости

Внешние зависимости в Bazel (в отличие от Maven/Gradle) не резолвятся из коробки —
для этого подключён плагин [`rules_jvm_external`](https://github.com/bazelbuild/rules_jvm_external),
который в `MODULE.bazel` через `maven.install(...)` скачивает артефакты с Maven Central
и делает их доступными в `BUILD.bazel` через репозиторий `@maven`:

- **org.apache.commons:commons-lang3:3.14.0** — подключается как
  `@maven//:org_apache_commons_commons_lang3` в `deps` цели `//:main` и используется
  в `Main.java` для реверса строки (`StringUtils.reverse`).

Собственно систему сборки Java-целей (`java_binary`, компилятор, toolchain) предоставляет
модуль `rules_java`, подключённый в `MODULE.bazel` через `bazel_dep`.
