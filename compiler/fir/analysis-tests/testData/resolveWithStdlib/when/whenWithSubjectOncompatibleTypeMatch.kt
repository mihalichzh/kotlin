// RUN_PIPELINE_TILL: FRONTEND

val test = when(2) {
    "bar" -> println("bar")
    else -> "foo"
}
