import java.util.Scanner
import kotlin.system.exitProcess

val archives = mutableListOf<Archive>() // Глобальный список архивов из дата класса
val scanner = Scanner(System.`in`)

fun showArchiveMenu() { // Функция отображения главного меню — список архивов + создание + выход
    while (true) { // Главный цикл — пока пользователь не выберет "Выход"
        val screen = MenuScreen("Архивы") // Создаём экран меню с заголовком "Архивы"

        screen.addOption("Создать архив") {
            print("Введите имя архива и нажмите Enter: ")
            val name = scanner.nextLine().trim() // Чтение и обрезка пробелов

            if (name.isEmpty()) { // Проверка: имя не должно быть пустым
                println("Имя не может быть пустым.")
                return@addOption // Прерываем выполнение текущего действия
            }

            archives.add(Archive(name)) // Создаём архив и добавляем в список
            println("Архив \"$name\" создан.")
        }

        archives.forEach { archive ->
            screen.addOption("Открыть архив: ${archive.name}") {
                showNoteMenu(archive)  // Переход в меню заметок внутри архива
            }
        }

        screen.addOption("Выход из программы") { // Пункт выхода из программы
            println("Выход ... ")
            exitProcess(0) // Выход из всей программы (ПЕРЕПРОВЕРЬ ЭТОТ ВАРИАНТ!!!!!)
        }

        screen.show() // Показываем меню и ждём пользовательский выбор
    }
}