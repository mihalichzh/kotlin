// RUN_PIPELINE_TILL: FRONTEND

fun main() {
    val subject = "foo bar"
    val result = when (subject) {
        <!CONFUSING_BRANCH_CONDITION_ERROR, INCOMPATIBLE_TYPES!>subject.length > 2<!> -> "first match"
        else -> "else"
    }
}

/* GENERATED_FIR_TAGS: comparisonExpression, equalityExpression, functionDeclaration, integerLiteral, localProperty,
propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
