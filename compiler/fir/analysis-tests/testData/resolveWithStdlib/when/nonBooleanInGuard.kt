// RUN_PIPELINE_TILL: FRONTEND

val subject = 1
val result = when (subject) {
    in 1..3 if <!CONDITION_TYPE_MISMATCH!>"string"<!> -> Any()
    else -> Any()
}

/* GENERATED_FIR_TAGS: andExpression, guardCondition, integerLiteral, propertyDeclaration, rangeExpression,
stringLiteral, whenExpression, whenWithSubject */
