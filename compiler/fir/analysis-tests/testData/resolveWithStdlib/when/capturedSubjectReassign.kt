// RUN_PIPELINE_TILL: FRONTEND

fun main() {
    val result = when (val subject = "test") {
        <!USELESS_IS_CHECK!>is String<!> -> {
            <!VAL_REASSIGNMENT!>subject<!> = "reassign"
        }
        <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> Any()
    }
}

/* GENERATED_FIR_TAGS: assignment, functionDeclaration, isExpression, localProperty, propertyDeclaration, stringLiteral,
whenExpression, whenWithSubject */
