// RUN_PIPELINE_TILL: FRONTEND

val test = when("foo") {
    <!SYNTAX!>,<!> <!SYNTAX!><!>-> "broken"
    else -> "else"
}

/* GENERATED_FIR_TAGS: equalityExpression, propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
