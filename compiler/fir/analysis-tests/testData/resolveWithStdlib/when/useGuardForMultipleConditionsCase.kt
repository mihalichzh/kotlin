// RUN_PIPELINE_TILL: FRONTEND

fun test() {
    when (val value = "foo") {
        value, "bar" <!COMMA_IN_WHEN_CONDITION_WITH_WHEN_GUARD!>if "bar".length > 1<!> -> println("foo")
        "bar" -> println("bar")
    }
}

/* GENERATED_FIR_TAGS: andExpression, comparisonExpression, disjunctionExpression, equalityExpression,
functionDeclaration, guardCondition, integerLiteral, localProperty, propertyDeclaration, stringLiteral, whenExpression,
whenWithSubject */
