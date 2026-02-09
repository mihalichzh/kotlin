// RUN_PIPELINE_TILL: FRONTEND

val test = when {
    1 -> println("bar")
    else -> "foo"
}
