class NoteMenu(private val archive: Archive) : Menu<Note>(archive.notes.toMutableList()) {
    override val menuTitle = "Архив: ${archive.name}"
    override val createItemText = "Создать заметку"

    override fun displayItem(item: Note) = item.preview()

    override fun createItem(): Note? = try {
        val title = readNonEmptyString("Введите название заметки: ")
        val content = readNonEmptyString("Введите текст заметки: ")
        val note = Note(title, content)
        archive.addNote(note)
        note
    } catch (e: IllegalArgumentException) {
        println(e.message)
        null
    }

    override fun onItemSelected(item: Note) {
        ViewNoteMenu(item).show()
    }
}