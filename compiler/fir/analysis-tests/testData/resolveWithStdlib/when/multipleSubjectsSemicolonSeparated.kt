// RUN_PIPELINE_TILL: FRONTEND

fun main() {
    when("123"<!SYNTAX!><!>; "123"<!SYNTAX!>)<!> {
    }
}

/* GENERATED_FIR_TAGS: functionDeclaration, lambdaLiteral, whenExpression, whenWithSubject */
