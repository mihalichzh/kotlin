// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -ELSE_MISPLACED_IN_WHEN

val test = when {
    "bar".length > 10 -> println("bar")
    else -> ""
    "foo".length < 10 -> println("foo")
}

/* GENERATED_FIR_TAGS: comparisonExpression, integerLiteral, propertyDeclaration, stringLiteral, whenExpression */
