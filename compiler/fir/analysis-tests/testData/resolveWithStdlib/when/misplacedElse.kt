// RUN_PIPELINE_TILL: FRONTEND

val test = when {
    "bar".length > 10 -> println("bar")
    <!ELSE_MISPLACED_IN_WHEN!>else<!> -> ""
    "foo".length < 10 -> println("foo")
}

/* GENERATED_FIR_TAGS: comparisonExpression, integerLiteral, propertyDeclaration, stringLiteral, whenExpression */
