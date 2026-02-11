// RUN_PIPELINE_TILL: FRONTEND

fun test() {
    val value: Number = 11
    val value1: Number = 9
    when (value1) {
        is Int if value <!UNRESOLVED_REFERENCE!>><!> 10 -> println("pretty positive int")
    }
}

/* GENERATED_FIR_TAGS: andExpression, comparisonExpression, functionDeclaration, guardCondition, integerLiteral,
isExpression, localProperty, propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
