// RUN_PIPELINE_TILL: FRONTEND

val subject: String? = "subject"
val result = <!NO_ELSE_IN_WHEN!>when<!>(subject) {
    is String -> subject
}

/* GENERATED_FIR_TAGS: isExpression, nullableType, propertyDeclaration, smartcast, stringLiteral, whenExpression,
whenWithSubject */
