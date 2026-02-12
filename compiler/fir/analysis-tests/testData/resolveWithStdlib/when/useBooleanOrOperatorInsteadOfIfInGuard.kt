// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -USELESS_IS_CHECK

val result = when ("subject") {
    is String <!SYNTAX!>|| 2 > 1<!> -> "foo"
}

/* GENERATED_FIR_TAGS: comparisonExpression, equalityExpression, integerLiteral, isExpression, propertyDeclaration,
smartcast, stringLiteral, whenExpression, whenWithSubject */
