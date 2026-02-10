// RUN_PIPELINE_TILL: FRONTEND

val test = when {
    <!CONDITION_TYPE_MISMATCH!>1<!> -> println("bar")
    else -> "foo"
}

/* GENERATED_FIR_TAGS: integerLiteral, propertyDeclaration, stringLiteral, whenExpression */
