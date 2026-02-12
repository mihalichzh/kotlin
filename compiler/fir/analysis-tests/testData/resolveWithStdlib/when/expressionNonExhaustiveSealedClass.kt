// RUN_PIPELINE_TILL: FRONTEND

sealed class Sealed

class FirstChild : Sealed()
class SecondChild : Sealed()
class ThirdChild : Sealed()

val sealed: Sealed = listOf(FirstChild(), SecondChild(), ThirdChild()).random()
val test = <!NO_ELSE_IN_WHEN!>when<!> (sealed) {
    is FirstChild -> "First"
    is ThirdChild -> "Third"
}

/* GENERATED_FIR_TAGS: classDeclaration, isExpression, propertyDeclaration, sealed, smartcast, stringLiteral,
whenExpression, whenWithSubject */
