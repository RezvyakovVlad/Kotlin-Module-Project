class ViewNoteMenu(private val note: Note) : Menu<Unit>(mutableListOf()) {
    override val menuTitle = "Просмотр заметки"
    override val createItemText = ""

    override fun displayItem(item: Unit) = ""

    override fun createItem(): Unit? = null

    override fun onItemSelected(item: Unit) {}

    override fun show() {
        println("\n${note.title}\n")
        println(note.content)
        println("\n0. $exitText")

        while (true) {
            print("> ")
            when (readInput()) {
                0 -> break
                else -> showInputError()
            }
        }
    }
}