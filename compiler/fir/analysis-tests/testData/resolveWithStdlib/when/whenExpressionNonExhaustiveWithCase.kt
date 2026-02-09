// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -NO_ELSE_IN_WHEN

val test = when {
    "foo".length == 0 -> println("foo")
}

/* GENERATED_FIR_TAGS: equalityExpression, integerLiteral, propertyDeclaration, stringLiteral, whenExpression */
