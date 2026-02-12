# Exploratory tests report

## 'green' cases checked

✅ Statement without subject, with matching case inside top-level declaration - 'a match' is printed:

```kotlin
fun main() {
    when {
        false -> println("not_match")
        true -> println("a match")
    }
}
```

✅ Expression with subject, with matching case inside top-level declaration - 'a match' is assigned to result:

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

✅ Expression with subject, without matching case outside top-level declaration - 'else' is assigned to result:

```kotlin
val subject = "foobar"
val result = when (subject) {
    "bar" -> "not a match"
    "foo" -> "still not a match"
    else -> "else"
}
```

✅ Statement with subject variable non-exhaustive - no compilation/runtime errors:

```kotlin
fun main() {
    val subject = "foobar".substring(3)
    when (subject) {
        "foo" -> println("not a match")
        "oof" -> "not match"
    }
}
```

✅ Statement with subject literal - 'a match' is printed:

```kotlin
fun main() {
    when ("foo") {
        "foo" -> println("a match")
        "oof" -> println("not match")
    }
}
```

✅ Statement without variable assignment - no compilation/runtime errors:

```kotlin
val subject = "foobar"
when (subject) {
    "bar" -> "not a match"
    "foo" -> "still not a match"
    else -> "else"
}
```

✅ Expression exhaustive with enum subject - 'result' is assigned with matching value:

```kotlin
val enumSubject = SubjectOption.entries.random()
val result = when (enumSubject) {
    SubjectOption.ONE -> 1
    SubjectOption.TWO -> 2
    SubjectOption.THREE -> 3
}
```

✅ Expression exhaustive with boolean - 'result' is assigned with matching value:

```kotlin
val bool = Random.nextDouble(until = 1.0) <= 0.5
val result = when (bool) {
    true -> 1
    false -> 2
}
```

✅ Expression exhaustive with sealed class - 'result' is assigned with matching value:

```kotlin
sealed interface Sealed
class FirstSealed : Sealed
class SecondSealed : Sealed

fun main() {
    val subject = listOf(FirstSealed(), SecondSealed()).random()
    val result = when (subject) {
        is FirstSealed -> "First sealed"
        is SecondSealed -> "Second sealed"
    }
}
```

✅ Expression returning boolean in statements - 'result' is assigned with matching value:

```kotlin
val subject = "bla"
val result = when {
    subject.isEmpty() -> "Empty"
    else -> subject
}
```

✅ Statement with case duplicate - no compilation/runtime errors, first matched value is printed to console:

```kotlin
fun main() {
    val bool = true
    when (bool) {
        true -> println(1)
        false -> println(2)
        true -> println(3)
        false -> println(4)
    }
}
```

✅ Expression with cases returning same type - result type is resolved to values type:

```kotlin
fun main() {
  val result = when (false) {
    true -> "String1"
    false -> "String2"
  }
  result.lowercase() // no error
}
```

✅ Expression with cases returning different types - result type is resolved with Any (closest common type):

```kotlin
val subject = "foo"
val result = when (subject) {
    "bar" -> "String"
    "foo" -> println("Unit")
    else -> 1
}
```

✅ Expression with subject and only 'else' case - result is assigned with 'only else':

```kotlin
val result = when ("subject") {
    else -> "only else"
}
```

✅ Statement with single-line block - no compilation/runtime errors, 'block' is printed:

```kotlin
fun main() {
    when {
        "foo".length <= 3 -> {
            println("block")
        }
    }
}
```

✅ Expression with multi-line block - result is assigned with 'match':

```kotlin
val result = when {
    "foo".length < 3 -> {
        println("match detected")
        "match"
    }

    else -> "not a match"
}
```

✅ With exception throw - exception from matching case is thrown:

```kotlin
fun main() {
  when {
    false -> throw Exception("should not throw")
    true -> throw Exception("should throw")
  }
}
```

✅ Nested where block - matching case from nested when is invoked:

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

✅ Multiple matches - result is assigned with the first match:

```kotlin
val subject = "foo bar"
val result = when {
    subject.length > 2 -> "first match"  // to be matched
    subject.length > 3 -> "second match"
    else -> "else"
}
```

✅ Case with value from function - no compilation errors, result is assigned with matching case value:

```kotlin
fun multiply(l: Int, r: Int): Int = l * r

val result = when {
  multiply(l = 2, r = 3) > 2 -> "> 2"
  else -> "else"
}
```

✅ Multiple conditions (comma separated) - result is assigned with matching case value:

```kotlin
fun main() {
    val subject = "1"
    val result = when (subject) {
        "2", "1" -> "match"  // to be matched
        "3" -> "not a match"
        else -> "else"
    }
}
```

✅ Multiple match in multiple conditions - result is assigned value from first matching case:

```kotlin
fun main() {
    val subject = 1
    val result = when (subject) {
        5 -> "not match"
        1, 2 -> "first match" // to be matched
        3, 1 -> "second match"
        4 -> "not match"
        else -> "else"
    }
}
```

✅ Subject with 'in' range match - 'matched range' is assigned to result:

```kotlin
val subject = 2
val result = when (subject) {
    in 0..4 -> "matched range"
    else -> "not matched"
}
```

✅ Subject with '!in' range match - 'matched range' is assigned to result:

```kotlin
val subject = 4
val test = when (subject) {
    in 5..10 -> "not matched range"
    !in 5..10 -> "matched range"
    else -> "not matched"
}
```

✅ Subject with 'is' expression match - 'match' is assigned to result:

```kotlin
val subject = 4
val test = when (subject) {
    is String -> "not a match"
    is Number -> "match"
    else -> "not a match"
}
```

✅ Subject with '!is' expression match - 'match' is assigned to result:

```kotlin
val subject = 4
val test = when (subject) {
    !is String -> "match"
    is Any -> "not a match"
    else -> "not a match"
}
```

✅ Smart casting by 'is' expression in match body - result is assigned with lowercased subject value:

```kotlin
val subject: Any = "ANY"
val test = when (subject) {
    is String -> subject.lowercase()
    is Number -> subject.toLong()
    else -> "not matched"
}
```

✅ Variable declaration within the subject - 'foo' is printed out:

```kotlin
fun main() {
    when (val value = "foo") {
        value -> println("foo")
        "bar" -> println("bar")
    }
}
```

✅ Guard statement with single boolean - 'a match' is assigned to result:

```kotlin
val value = "foo"
val result = when (value) {
    value if value.length > 5 -> "not a match"
    is String if value.length < 5 -> "a match"
    else -> "else"
}
```

✅ Guard statement with boolean expression - 'a match' is printed out:

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

✅ Match with null case - 'a match' is printed out:

```kotlin
fun main() {
    val value: Int? = null
    when (value) {
        null -> println("a match")
        else -> println("else")
    }
}
```

✅ Guard with 'in' range - 'a match' is printed out:

```kotlin
fun main() {
    val value: Int = Random.nextInt()
    when (value) {
        in 1..5 if value < 3 -> println("a match")
        else -> println("else")
    }
}
```

✅ Guard is lazily executed on match only - 'func is executed with foo\na match' is printed out:

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
✅ Smart casting by 'is' expression in guard - result is assigned with 'long string':

```kotlin
val subject: Any = "ANY"
val test = when (subject) {
  is String if subject.length > 5 -> "long string"
  is Number if subject.toLong() == 2L -> "small number"
  else -> "not matched"
}
```

✅ Guard condition with else if - 'result' is assigned with '>2':

```kotlin
fun main() {
    val result = when (val subject = "test") {
        is String if subject.length < 0 -> "< 2"
        else if subject.length > 2 -> "> 2"
        is String if subject.length > subject.length -> "!= 2"
        else -> subject
    }
}
```

✅ Matching by guard statement when the main case is duplicated - 'a match' is assigned to result:

```kotlin
val result = when ("foo") {
    is String if value.length > 5 -> "not a match"
    is String if value.length < 5 -> "a match"
    else -> "else"
}
```

✅ Return from when block - function returns 'from foo block':

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

✅ 'for' loop break from when block - only 'one' and 'two' are printed out to console:

```kotlin
fun main() {
  val items = listOf("one", "two", "three")
  for (item in items) {
    when(item) {
      "one" -> println("one")
      "two" -> {
        println("two")
        break
        println("two after break")
      }
      "three" -> println("three")
    }
  }
}
```

✅ 'while' loop continue from when block - only 'one', 'two before continue' and 'three' are printed out to console:

```kotlin
fun main() {
  val itemsIterator = listOf("one", "two", "three").iterator()
  while(itemsIterator.hasNext()) {
    when(itemsIterator.next()) {
      "one" -> println("one")
      "two" -> {
        println("two before continue")
        continue
        println("two")
      }
      "three" -> println("three")
    }
  }
}
```

✅ Trailing comma in case - no compilation/runtime error, result is assigned with 'match':

```kotlin
fun main() {
    val subject = 1
    val result = when (subject) {
        1, -> "match" // to be matched
        4 -> "not match"
        else -> "else"
    }
}
```

✅ Explicitly typed subject capture - no compilation/runtime error, '1L' is printed out:

```kotlin
fun main() {
    val subject = 2
    when (val subject: Long = 1) {
        1L -> println("1L")
        2L -> println("2L")
    }
}
```

✅ Use outer variable name in subject capture - no compilation/runtime error, '1' is printed out:

```kotlin
fun main() {
    val subject = 2
    when (val subject = 1) {
        1 -> println("1")
        2 -> println("2")
    }
}
```

✅ Branches with 'Nothing' types - no compilation error, result variable type is resolved to String:
```kotlin
val result: String = when("test") {
    is String -> "String"
    is Int -> "Int"
    is Double -> TODO("implement me")
    else -> error("unknow type")
}
```

✅ Unambiguous type is considered exhaustive in when expression - no compilation/runtime error, result is assigned with 'match':
```kotlin
val result: String = when(1L) {
    is Long -> "match"
    is Int -> "not a match"
}
```

## Negative ('red') checks
### diagnostic

* non-exhaustive with open type -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/expressionNonExhaustiveWithOpenType.kt);
* else is not the last case - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/misplacedElse.kt);
* when expression with empty block -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/emptyExpressionWhenBlock.kt);
* without subject condition type mismatch -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/expressionTypeMismatch.kt);
* with subject condition incompatible type -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/withSubjectIncompatibleTypes.kt);
* boolean expression in where with subject -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/booleanExpressionInWhenWithSubjectCase.kt);
* when with empty subject - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/subjectWhenWithEmptySubject.kt);
* when with subject without block -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/subjectWhenWithWithoutBrackets.kt);
* when with missing condition statement -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/missingConditionStatement.kt);
* when keyword as a variable name -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsVariableName.kt);
* when keyword as a function name -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsFunctionName.kt);
* when keyword as a class name - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsClassName.kt);
* when keyword as a enum entry name -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsEnumEntry.kt);
* when as a type - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/whenKeywordAsVariableType.kt);
* non-subject with range without argument -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/nonSubjectWhenWithRangeWithoutArgument.kt);
* refer to outer variable in guard condition -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/referOuterVariableInGuard.kt);
* use guard for multi-conditional case -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/useGuardForMultipleConditionsCase.kt);
* use guard condition in when without subject -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/guardConditionInWhenWIthoutSubject.kt);
* use non-boolean in guard - 
    see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/nonBooleanInGuard.kt);
* non-exhaustive with enum - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/expressionNonExhaustiveWithEnum.kt);
* non-exhaustive with sealed class -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/expressionNonExhaustiveSealedClass.kt);
* non-exhaustive with boolean -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/expressionNonExhaustiveBoolean.kt);
* two consecutive trailing commas -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/twoConsecutiveTrailingCommasAtTheCaseEnd.kt);
* comma in the beginning of the case -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/commaAtTheCaseBeginning.kt);
* condition statement contains only comma -
  see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/conditionStatementContainsOnlyComma.kt);
* use var in subject capture - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/declareVarInSubjectCapture.kt);
* generics type erasure in 'is' conditions - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/typeErasureInIsCondition.kt);
* attempt to reassign captured subject - see [snippet](compiler/fir/analysis-tests/testData/resolveWithStdlib/when/capturedSubjectReassign.kt);