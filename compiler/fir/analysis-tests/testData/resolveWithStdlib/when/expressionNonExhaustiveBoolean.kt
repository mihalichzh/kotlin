// RUN_PIPELINE_TILL: FRONTEND

val bool: Boolean = listOf(true, false).random()
val test = <!NO_ELSE_IN_WHEN!>when<!> (bool) {
    true -> "true_match"
}

/* GENERATED_FIR_TAGS: equalityExpression, propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
