// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONDITION_TYPE_MISMATCH

val test = when {
    1 -> println("bar")
    else -> "foo"
}

/* GENERATED_FIR_TAGS: integerLiteral, propertyDeclaration, stringLiteral, whenExpression */
