// RUN_PIPELINE_TILL: FRONTEND

val test = <!NO_ELSE_IN_WHEN!>when<!> {
    "foo".length == 0 -> println("foo")
}

/* GENERATED_FIR_TAGS: equalityExpression, integerLiteral, propertyDeclaration, stringLiteral, whenExpression */
