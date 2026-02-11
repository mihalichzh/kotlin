// RUN_PIPELINE_TILL: FRONTEND

val test = when (3) {
    3, <!SYNTAX!>,<!> <!SYNTAX!><!>-> "foo"
    else -> "bar"
}

/* GENERATED_FIR_TAGS: disjunctionExpression, equalityExpression, integerLiteral, propertyDeclaration, stringLiteral,
whenExpression, whenWithSubject */
