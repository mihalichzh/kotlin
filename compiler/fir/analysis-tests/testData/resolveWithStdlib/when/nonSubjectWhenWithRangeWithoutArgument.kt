// RUN_PIPELINE_TILL: FRONTEND

val test = when {
    <!EXPECTED_CONDITION!>in 5..10<!> -> "one"
    <!EXPECTED_CONDITION!>!in 5..10<!> -> "two"
    else -> "three"
}

/* GENERATED_FIR_TAGS: integerLiteral, propertyDeclaration, rangeExpression, stringLiteral, whenExpression */
