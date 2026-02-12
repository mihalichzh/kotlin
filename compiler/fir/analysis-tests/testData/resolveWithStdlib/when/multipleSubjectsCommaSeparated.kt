// RUN_PIPELINE_TILL: FRONTEND

fun main() {
    when("123"<!SYNTAX!><!SYNTAX!><!>, "123")<!> {
    }
}

/* GENERATED_FIR_TAGS: functionDeclaration, lambdaLiteral, whenExpression, whenWithSubject */
