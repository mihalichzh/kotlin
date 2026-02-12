// RUN_PIPELINE_TILL: FRONTEND

val test = when (3) {
    <!SYNTAX!>,<!>3 -> "foo"
    else -> "bar"
}

/* GENERATED_FIR_TAGS: disjunctionExpression, equalityExpression, integerLiteral, propertyDeclaration, stringLiteral,
whenExpression, whenWithSubject */
