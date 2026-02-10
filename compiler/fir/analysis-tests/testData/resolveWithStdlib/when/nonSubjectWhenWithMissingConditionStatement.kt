// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -SYNTAX

val test = when("foo") {
    -> "broken"
    else -> "else"
}

/* GENERATED_FIR_TAGS: equalityExpression, propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
