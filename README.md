# AnimalGuesser
Animal Guesser Game for RedCollar intern test task

1. Реализованные фичи:
   - Хранение животных и вопросов к ним реализовано через дерево узлов (AnimalNode, QuestionNode), вершиной которого является GameStartNode;
   - Основная логика работы игры реализована в AnimalGuesserGameService;
   - Диалоговое окно для сохранения текущей модели данных в файл и её чтение из файла;
   - Защита от неправильного ввода и выбора неправильного файла;
   - Поддерживается два языка (Ru, Eng).
2. Технические детали реализации:
   - Gson для сериализации и десериализации дерева узлов;
   - Gradle;
   - Lombok.
3. Что можно было бы улучшить:
   - Хранить дерево узлов в базе данных, а не в файле;
   - Сделать графический интерфейс через JavaFX или Swing;
   - Вынести строковые константы в resources, а не хранить в классах;
   - Сделать возможность пользователю самому выбирать язык (сейчас это реализовано только в коде);
   - Сделать capitalizer для вводимых пользователем названий животных;
   - Переработать структуру хранения классов.

![Структура хранения данных в игре](src/main/resources/png/AnimalGuesser_Structure.png)
![Вид диалогового окна при выборе файла](src/main/resources/png//Open_File_dialog.png)
![Пример работы игры](src/main/resources/png/Game_Example.png)
![Пример хранимых данных в файле](src/main/resources/png/Saved_JSON_Example.png)