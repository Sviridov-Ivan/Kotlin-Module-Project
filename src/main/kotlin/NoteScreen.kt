fun showNoteScreen(note: Note) {
    println("\nЗаметка: ${note.title}")
    println("\nТекст заметки: ${note.content}")
    println("Нажмите Enter, чтобы вернуться. ")
    scanner.nextLine()
}