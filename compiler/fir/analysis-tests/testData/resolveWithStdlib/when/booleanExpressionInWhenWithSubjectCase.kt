// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -INCOMPATIBLE_TYPES -CONFUSING_BRANCH_CONDITION_ERROR

fun main() {
    val subject = "foo bar"
    val result = when (subject) {
        subject.length > 2 -> "first match"
        else -> "else"
    }
}

/* GENERATED_FIR_TAGS: comparisonExpression, equalityExpression, functionDeclaration, integerLiteral, localProperty,
propertyDeclaration, stringLiteral, whenExpression, whenWithSubject */
