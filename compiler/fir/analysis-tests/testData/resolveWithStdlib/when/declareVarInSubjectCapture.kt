// RUN_PIPELINE_TILL: FRONTEND

fun main() {
    when(<!ILLEGAL_DECLARATION_IN_WHEN_SUBJECT!>var subject = 1<!>) {
        1 -> println("1")
        2 -> println("2")
    }
}

/* GENERATED_FIR_TAGS: equalityExpression, functionDeclaration, integerLiteral, localProperty, propertyDeclaration,
stringLiteral, whenExpression, whenWithSubject */
