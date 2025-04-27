fun showNoteMenu(archive: Archive) { // Функция для отображения меню заметок внутри выбранного архива
    var shouldExit = false // Флаг, чтобы выйти из while
    while (!shouldExit) {
        val screen = MenuScreen("Заметки в архиве \"${archive.name}\"")

        screen.addOption("Создать заметку") { // Пункт меню: создание новой заметки
            print("Введите название заметки и нажмите Enter: ")
            val title = scanner.nextLine().trim()
            if (title.isEmpty()) {
                println("Название не может быть пустым. ")
                return@addOption // Прерываем только действие, не всё меню
            }

            print("Введите текст заметки и нажмите Enter: ")
            val content = scanner.nextLine().trim()
            if (content.isEmpty()) {
                println("Содержимое не может быть пустым.")
                return@addOption
            }

            archive.notes.add(Note(title, content)) // Добавляем заметку в архив
            println("Заметка \"$title\" добавлена. ")
        }

        archive.notes.forEach { note -> // Для каждой заметки добавляем пункт меню — "Открыть: Название"
            screen.addOption("Открыть заметку: ${note.title}") {
                showNoteScreen(note) // Переход на просмотр заметки

            }
        }

        screen.addOption("Назад") { // Пункт возврата назад в меню архивов
            shouldExit = true // Устанавливаем флаг выхода
        }

        screen.show() // Показываем сформированное меню и ждём выбор пользователя

    }
}