data class Note(
    val title: String,
    val content: String
) {
    init {
        require(title.isNotBlank()) { "Название заметки не может быть пустым" }
        require(content.isNotBlank()) { "Содержание заметки не может быть пустым" }
    }

    fun preview(): String {
        val shortContent = if (content.length > 30)
            content.take(30) + "..."
        else
            content
        return "$title: $shortContent"
    }
}