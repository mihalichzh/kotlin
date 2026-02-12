// RUN_PIPELINE_TILL: BACKEND

val result = when ("subject") {
    <!USELESS_IS_CHECK!>is String<!> -> "foo"
}

/* GENERATED_FIR_TAGS: isExpression, propertyDeclaration, smartcast, stringLiteral, whenExpression, whenWithSubject */
