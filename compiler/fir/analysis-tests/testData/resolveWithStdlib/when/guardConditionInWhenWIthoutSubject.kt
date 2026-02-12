// RUN_PIPELINE_TILL: FRONTEND

fun main() {
    val subject = listOf("bla", 1, true).random()
    val result = when {
        subject is String <!WHEN_GUARD_WITHOUT_SUBJECT!>if subject.length > 0<!> -> "Not empty"
        else -> subject
    }
}

/* GENERATED_FIR_TAGS: andExpression, comparisonExpression, functionDeclaration, guardCondition, integerLiteral,
isExpression, localProperty, propertyDeclaration, stringLiteral, whenExpression */
