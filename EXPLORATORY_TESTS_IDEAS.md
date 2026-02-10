# What to test (draft)

## 'green' cases

1. Statement without subject, with matching case inside top-level declaration - 'a match' is printed:

```kotlin
fun main() {
    when {
        false -> println("not_match")
        true -> println("a match")
    }
}
```

2. Expression with subject, with matching case inside top-level declaration - 'a match' is assigned to result:

```kotlin
fun main() {
    val subject = Random.nextInt()
    val result = when (subject) {
        1 -> "not a match"
        subject -> "a match"
        else -> "else"
    }
}
```

3. Expression with subject, without matching case outside top-level declaration - 'else' is assigned to result:

```kotlin
val subject = "foobar"
val result = when (subject) {
    "bar" -> "not a match"
    "foo" -> "still not a match"
    else -> "else"
}
```

4. Statement with subject variable non-exhaustive - no compilation/runtime errors:

```kotlin
fun main() {
    val subject = "foobar".substring(3)
    when (subject) {
        "foo" -> println("not a match")
        "oof" -> "not match"
    }
}
```

5. Statement with subject literal - 'a match' is printed:

```kotlin
fun main() {
    when ("foo") {
        "foo" -> println("a match")
        "oof" -> println("not match")
    }
}
```

6. Expression without variable assignment - no compilation/runtime errors:

```kotlin
val subject = "foobar"
when (subject) {
    "bar" -> "not a match"
    "foo" -> "still not a match"
    else -> "else"
}
```

7. Expression exhaustive with enum subject - 'result' is assigned with matching value:

```kotlin
val enumSubject = SubjectOption.entries.random()
val result = when (enumSubject) {
    SubjectOption.ONE -> 1
    SubjectOption.TWO -> 2
    SubjectOption.THREE -> 3
}
```

8. Expression exhaustive with boolean - 'result' is assigned with matching value:

```kotlin
val bool = Random.nextDouble(until = 1.0) <= 0.5
val result = when (bool) {
    true -> 1
    false -> 2
}
```

9. Expression exhaustive with sealed class - 'result' is assigned with matching value:

```kotlin
sealed interface Sealed
class FirstSealed : Sealed
class SecondSealed : Sealed

fun main() {
    val subject = listOf(FirstSealed(), SecondSealed()).random()
    val result = when (subject) {
        is FirstSealed -> println("First sealed")
        is SecondSealed -> println("Second sealed")
    }
}
```

10. Statement with case duplicate - no compilation/runtime errors, first matched value is printed to console:

```kotlin
fun main() {
    val bool = Random.nextDouble(until = 1.0) <= 0.5
    when (bool) {
        true -> println(1)
        false -> println(2)
        true -> println(3)
        false -> println(4)
    }
}
```

11. Expression with cases returning same type - result type is resolved to values type:

```kotlin
val bool = Random.nextDouble(until = 1.0) <= 0.5
val result = when (bool) {
    true -> "String1"
    false -> "String2"
}
```

12. Expression with cases returning different types - result type is resolved with Any (closest common type):

```kotlin
val subject = "foo"
val result = when (subject) {
    "bar" -> "String"
    "foo" -> println("Unit")
    else -> 1
}
```

13. Expression with subject and only 'else' case - result is assigned with 'only else':

```kotlin
val result = when ("subject") {
    else -> "only else"
}
```

14. Statement with single-line block - no compilation/runtime errors, 'block' is printed:

```kotlin
fun main() {
    when {
        "foo".length <= 3 -> {
            println("block")
        }
    }
}
```

15. Expression with multi-line block - result is assigned with 'match':

```kotlin
val result = when {
    "foo".length < 3 -> {
        println("match detected")
        "match"
    }

    else -> "not a match"
}
```

16. With exception throw:

```kotlin
fun main() {
    when {
        Random.nextDouble(until = 1.0) < 2.0 -> throw Exception()
    }
}
```

17. Nested where block - matching case from nested when is invoked:

```kotlin
fun main() {
    val value = Random.nextInt()
    when {
        true -> when (value) {
            4 -> println("4")
            else -> println("3 or less")
        }
    }
}
```

18. Multiple matches (TODO - clarify a warning) - result is assigned with the first match:

```kotlin
val subject = "foo bar"
val result = when {
    subject.length > 2 -> "first match"  // to be returned
    subject.length > 3 -> "second match"
    else -> "else"
}
```

Potential bug - IDE shows irrelevant warning for the second match:
![img.png](img.png)
IDE build: Build #IU-253.30387.90
Project kotlin version: 2.3.0

19. Case with value from function - no compilation errors, result is assigned with matching case value:

```kotlin
fun randomInt(): Int = Random.nextInt()

val result = when {
    randomInt() > 2 -> "> 2"
    else -> "else"
}
```

20. Multiple conditions (coma separated) - result is assigned with matching case value:

```kotlin
fun main() {
    val subject = "1"
    val result = when (subject) {
        "2", "1" -> "match"  // to be returned
        "3" -> "not a match"
        else -> "else"
    }
}
```

21. Multiple match in multiple conditions - result is assigned value from first matching case:

```kotlin
fun main() {
    val subject = 1
    val result = when (subject) {
        5 -> "not match"
        1, 2 -> "first match" // to be returned
        3, 1 -> "second match"
        4 -> "not match"
        else -> "else"
    }
}
```

22. Subject with 'in' range match - 'matched range' is assigned to result:

```kotlin
val subject = 2
val result = when (subject) {
    in 0..4 -> "matched range"
    else -> "not matched"
}
```

23. Subject with '!in' range match - 'matched range' is assigned to result:

```kotlin
val subject = 4
val test = when (subject) {
    in 5..10 -> "not matched range"
    !in 5..10 -> "matched range"
    else -> "not matched"
}
```

24. Variable declaration within the subject - 'foo' is printed out:

```kotlin
fun main() {
    when (val value = "foo") {
        value -> println("foo")
        "bar" -> println("bar")
    }
}
```

24. Guard statement with single boolean - 'a match' is assigned to result:

```kotlin
val value = "foo"
val result = when (value) {
    value if value.length > 5 -> "not a match"
    value if value.length < 5 -> "a match"
    else -> "else"
}
```

25. Guard statement with boolean expression - 'a match' is printed out:

```kotlin
fun main() {
    val value = "foo"
    when (value) {
        value if value.length > 5 || true -> println("a match")
        value if value.length < 5 && true -> println("not a match")
        else -> println("else")
    }
}
```

26. Match with null case - 'a match' is printed out:

```kotlin
fun main() {
    val value: Int? = null
    when (value) {
        null -> println("a match")
        else -> println("else")
    }
}
```

27. Guard with 'in' range - 'a match' is printed out:

```kotlin
fun main() {
    val value: Int = Random.nextInt()
    when (value) {
        in 1..5 if value < 3 -> println("a match")
        else -> println("else")
    }
}
```

28. Guard is executed on match only - 'func is executed with foo\namatch' is printed out:

```kotlin
fun func(parameter: String): Boolean {
    println("func is executed with $parameter")
    return true
}

fun main() {
    val value = "foo"
    when (value) {
        "bar" if func("bar") -> println("not a match")
        "foo" if func("foo") -> println("a match")
        else -> println("else")
    }
}
```

29. Return from when block - function returns 'from foo block':

```kotlin
fun test(): String {
    when {
        "foo".length < 3 -> {
            return "from foo block"
        }
        else -> return "else"
    }
}
```

## Negative ('red') checks

1. when expression non-exhaustive without else -
   see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/expressionNonExhaustive.kt);
2. else is not the last case - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/misplacedElse.kt);
3. when expression with empty block -
   see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/emptyExpressionWhenBlock.kt);
4. without subject condition type mismatch -
   see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/withoutSubjectTypeMismatch.kt);
5. with subject condition incompatible type -
   see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/withSubjectIncompatibleTypes.kt);
6. boolean expression in where with subject -
   see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/booleanExpressionInWhenWithSubjectCase.kt);
7. when with empty subject - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/subjectWhenWithEmptySubject.kt);
8. when with subject without block -
   see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/subjectWhenWithWithoutBrackets.kt);
9. when with missing condition statement -
   see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/nonSubjectWhenWithMissingConditionStatement.kt);
10. when keyword as a variable name -
    see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsVariableName.kt);
11. when keyword as a function name -
    see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsFunctionName.kt);
12. when keyword as a class name - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsClassName.kt);
13. when keyword as a enum entry name -
    see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsEnumEntry.kt);
14. when as a type - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsVariableType.kt);


13. Use non-subject when with ranges:

```kotlin
val subject = 4
val test = when {
    in 5..10 -> "not matched range"
    !in 5..10 -> "matched range"
    else -> "not matched"
}
```

9. Refer to non-subject in guard condition:

```kotlin

val value: Number = Random.nextInt()
val value1: Number = Random.nextInt()
when (value1) {
    is Int if value > 10 -> println("pretty positive int")
}
```

10. Refer to non-subject in guard condition:

```kotlin

val value: Number = Random.nextInt()
val value1: Number = Random.nextInt()
when (value1) {
    is Int if value > 10 -> println("pretty positive int")
}
```

11. Can't use guard conditions when you have multiple conditions separated by a comma:

```kotlin
fun main() {
    when (val value = "foo") {
        value, "bar" if "bar".length > 1 -> println("foo")
        "bar" -> println("bar")
    }
}
```

12. when expression with subject, non-exhaustive enum:

```kotlin
enum class Option {
    ONE,
    TWO,
    THREE
}

val someOption = Option.entries.random()
val test = when (someOption) {
    Option.ONE -> 1
    Option.TWO -> 2
}
```

13. when expression with subject, non-exhaustive sealed class:

```kotlin
sealed class Sealed

class FirstChild : Sealed()
class SecondChild : Sealed()
class ThirdChild : Sealed()

val sealed: Sealed = listOf(FirstChild(), SecondChild(), ThirdChild()).random()
val test = when (sealed) {
    is FirstChild -> "First"
    is ThirdChild -> "Third"
}
```

14. when expression with subject, non-exhaustive boolean:

```kotlin
   val bool: Boolean = listOf(true, false).random()
val test = when (bool) {
    true -> "true_match"
}
```

17. when as a type:

```kotlin
val test: when = "bla"
```

18. when with two consecutive trailing commas:

```kotlin
val test = when (3) {
    3, , -> ""
    else -> ""
}
```

19. when with two consecutive intermediate commas:

```kotlin
val test = when (3) {
    3, ,4 -> ""
    else -> ""
}
```

20. when with two consecutive preceding commas:

```kotlin
val test = when (3) {
        ,,3 -> ""
    else -> ""
}
```

21. when with comma instead of statement:

```kotlin
val test = when (3) {
        , -> ""
    else -> ""
}
```

13. when with subject outside of function:

```kotlin
val userRole = "Editor"
when (userRole) {
    "Viewer" -> print("User has read-only access")
    "Editor" -> print("User can edit content")
    else -> print("User role is not recognized")
} 
```
