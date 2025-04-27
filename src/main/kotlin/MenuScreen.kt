import java.util.Scanner

class MenuScreen (private val title: String) { // Экран меню с заголовком
    private val menuItems = mutableListOf<MenuItem>() // Список пунктов меню: каждый пункт — MenuItem (название + действие)
    private val scanner = Scanner(System.`in`) // Сканер для чтения ввода из консоли

    fun addOption(optionTitle: String, action: () -> Unit) { // Добавляем новый пункт меню
        menuItems.add(MenuItem(optionTitle, action))
    }

    fun show() { // Отображаем меню и обрабатываем выбор пользователя
        while (true) {
            println("\n$title") // Заголовок меню
            menuItems.forEachIndexed { index, item ->
                println("$index. ${item.title}")
            }
            print("Введите номер и нажмите Enter: ") // Ввод без переноса строки
            val input = scanner.nextLine() // Чтение строки
            val choice = input.toIntOrNull() // Безопасное преобразование в число

            if (choice == null || choice !in menuItems.indices) { // Проверка, если choice не число, или оно не входит в диапазон допустимых индексов
                println("Введите корректный номер из списка.")
                continue // Начать цикл заново
            }

            menuItems[choice].action.invoke() // берётся элемент списка menuItems по индексу (можно через get(),но так IDE подсказал), который ввёл пользователь. Это объект класса MenuItem
            break // Выход из текущего меню

        }
    }
}

