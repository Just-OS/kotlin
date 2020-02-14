// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_VARIABLE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -UNUSED_PARAMETER -UNUSED_EXPRESSION
// SKIP_TXT

/*
 * KOTLIN DIAGNOSTICS SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 0.1-268
 * PLACE: overload-resolution, building-the-overload-candidate-set-ocs, infix-function-call -> paragraph 2 -> sentence 1
 * RELEVANT PLACES: overload-resolution, building-the-overload-candidate-set-ocs, infix-function-call -> paragraph 2 -> sentence 2
 * NUMBER: 1
 * DESCRIPTION: Implicitly imported extension callable without infix modifier
 */

// FILE: Extensions.kt
package libPackage

/*public, without infix */
operator fun CharSequence.contains(regex: Regex): Boolean {
    println("my contains")
    return true
}

// FILE: TestCase2.kt
package sentence3
import libPackage.* //nothing to import, extension is not infix

// TESTCASE NUMBER: 1
fun case1() {
    val regex = Regex("")
    "" <!INFIX_MODIFIER_REQUIRED!>contains<!> regex
}
