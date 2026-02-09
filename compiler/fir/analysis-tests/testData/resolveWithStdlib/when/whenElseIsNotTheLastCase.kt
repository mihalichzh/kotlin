// RUN_PIPELINE_TILL: FRONTEND

val test = when {
    "bar".length > 10 -> println("bar")
    else -> ""
    "foo".length < 10 -> println("foo")
}
