package sobaya.app.studyflux.flux

interface Action<out T> {
    val type: String
    val data: T?
}