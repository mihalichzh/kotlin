// RUN_PIPELINE_TILL: FRONTEND

enum class Option {
    ONE,
    TWO,
    THREE
}

val someOption = Option.entries.random()
val test = <!NO_ELSE_IN_WHEN!>when<!> (someOption) {
    Option.ONE -> 1
    Option.TWO -> 2
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, equalityExpression, integerLiteral, propertyDeclaration, smartcast,
whenExpression, whenWithSubject */
