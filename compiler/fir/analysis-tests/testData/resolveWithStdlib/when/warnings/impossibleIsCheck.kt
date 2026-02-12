// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -USELESS_IS_CHECK

val result = when ("subject") {
    is String -> "foo"
    <!IMPOSSIBLE_IS_CHECK_ERROR!>is Number<!> -> "bar"
}

/* GENERATED_FIR_TAGS: isExpression, propertyDeclaration, smartcast, stringLiteral, whenExpression, whenWithSubject */
