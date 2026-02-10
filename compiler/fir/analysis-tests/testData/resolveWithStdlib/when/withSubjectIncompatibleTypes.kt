// RUN_PIPELINE_TILL: FRONTEND

val test = when(2) {
    <!INCOMPATIBLE_TYPES!>"bar"<!> -> println("bar")
    else -> "foo"
}

/* GENERATED_FIR_TAGS: equalityExpression, propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
