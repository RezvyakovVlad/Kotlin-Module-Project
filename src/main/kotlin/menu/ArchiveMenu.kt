class ArchiveMenu : Menu<Archive>(mutableListOf()) {
    override val menuTitle = "Список архивов"
    override val createItemText = "Создать архив"

    override fun displayItem(item: Archive) = item.name
    override fun createItem(): Archive? = try {
        val name = readNonEmptyString("Введите название архива: ")
        Archive(name)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        null
    }

    override fun onItemSelected(item: Archive) {
        NoteMenu(item).show()
    }
}