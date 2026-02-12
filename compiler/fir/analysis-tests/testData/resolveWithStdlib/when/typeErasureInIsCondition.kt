// RUN_PIPELINE_TILL: FRONTEND

val list = listOf(1, 2, 3, 4, 5)
val result: String = when (list) {
    is <!CANNOT_CHECK_FOR_ERASED!>List<String><!> -> "List of strings"
    <!USELESS_IS_CHECK!>is List<Int><!> -> "List of ints"
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> "List of unknown type"
}

/* GENERATED_FIR_TAGS: integerLiteral, isExpression, propertyDeclaration, smartcast, stringLiteral, whenExpression,
whenWithSubject */
