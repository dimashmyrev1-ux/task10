# student-app — тесты (JUnit 5 + JaCoCo)

Проект покрыт простыми модульными тестами на JUnit 5. Покрытие измеряется JaCoCo,
установлен порог **> 80 %** по инструкциям.

## Что добавлено

- Подключена зависимость **JUnit 5** (`junit-jupiter`) в `pom.xml`, плюс плагины
  `maven-surefire-plugin` (запуск тестов) и `jacoco-maven-plugin` (покрытие + проверка порога).
- Реализовано кастомное исключение **`InvalidAgeException`** и валидация возраста
  в `Student` (конструктор и `setAge`), диапазон `MIN_AGE`..`MAX_AGE` = 1..149.
- Тесты в `src/test/java`, повторяющем структуру `src/main/java`:
  - `model/StudentTest` — конструктор, геттеры/сеттеры, `toString`, `equals`, CSV;
  - `exception/InvalidAgeExceptionTest` — исключение бросается при некорректном возрасте;
  - `service/StreamAPITest` — фильтрация, сортировка, средний балл, группировка;
  - `service/FileServiceTest` — запись и чтение файлов;
  - `app/MainTest` — программа запускается без ошибок.

Используются только базовые аннотации `@Test`, `@BeforeEach`, `@DisplayName` (и `@TempDir`
для временной папки в файловом тесте) и простые проверки `assertEquals`, `assertTrue`, `assertThrows`.

## Запуск

```bash
mvn test      # тесты + отчёт о покрытии
mvn verify    # тесты + проверка порога покрытия (> 80 %)
```

HTML-отчёт о покрытии: `target/site/jacoco/index.html`.

## Результат покрытия (проверено локально)

| Метрика       | Покрытие |
|---------------|----------|
| Instructions  | 85.4 %   |
| Lines         | 85.3 %   |

Всего **20 тестов**, все проходят.
