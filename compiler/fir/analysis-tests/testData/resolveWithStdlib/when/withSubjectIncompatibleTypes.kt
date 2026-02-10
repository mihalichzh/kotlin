// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -INCOMPATIBLE_TYPES

val test = when(2) {
    "bar" -> println("bar")
    else -> "foo"
}

/* GENERATED_FIR_TAGS: equalityExpression, propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
