package com.saydullin.codehub.data.repository

import com.saydullin.codehub.domain.model.article.ArticleAuthor
import com.saydullin.codehub.domain.model.article.ArticleTag
import com.saydullin.codehub.domain.model.article.bug.BugAnswersArticle
import com.saydullin.codehub.domain.model.article.bug.BugArticle
import com.saydullin.codehub.domain.repository.BugArticleRepository
import com.saydullin.codehub.domain.util.Resource
import com.saydullin.codehub.presentation.model.bug.BugStatus
import javax.inject.Inject
import kotlin.random.Random

class BugArticleRepositoryImpl @Inject constructor(

): BugArticleRepository {

    override suspend fun getBugArticlesAPI(): Resource<List<BugArticle>> {
        TODO("Not yet implemented")
    }

    override suspend fun getBugArticleDB(): Resource<List<BugArticle>> {
        val bugDescriptions = listOf(
            "NullPointerException: Attempt to access a null reference - This bug occurs when trying to access or manipulate an object that is null.",
            "ArrayIndexOutOfBoundsException: Index is out of range - This bug occurs when trying to access an element at an invalid index in an array or list.",
            "ConcurrentModificationException: Collection modified during iteration - This bug occurs when modifying a collection while iterating over it, causing an inconsistent state.",
            "ClassCastException: Object cannot be cast to a specific type - This bug occurs when attempting to cast an object to an incompatible type, resulting in a runtime error.",
            "NumberFormatException: Invalid input for numeric conversion - This bug occurs when trying to convert a string that cannot be parsed as a number, resulting in a number format error.",
            "NoSuchElementException: Element not found - This bug occurs when trying to access an element from a collection that does not contain the requested element.",
            "IllegalStateException: Object is in an inappropriate state - This bug occurs when an object is used or accessed in a way that is not allowed in its current state.",
            "StackOverflowError: Recursive function calls exceed the stack size - This bug occurs when a recursive function calls itself too many times, causing the stack to overflow.",
            "IndexOutOfBoundsException: Substring or range index is out of bounds - This bug occurs when trying to extract a substring or range that extends beyond the valid range of a string or collection.",
            "AssertionError: Assertion failed - This bug occurs when an assertion check fails, indicating an unexpected condition or incorrect assumption in the code.",
            "IllegalArgumentException: Invalid argument passed to a method - This bug occurs when passing an invalid argument to a method, violating its requirements and resulting in a runtime error.",
            "OutOfMemoryError: Java heap space - This bug occurs when an application exhausts all available memory in the Java heap, causing a runtime error.",
            "NoSuchMethodError: Method not found - This bug occurs when trying to invoke a method that does not exist, typically due to a mismatch in the version or configuration of libraries or dependencies.",
            "ArithmeticException: Division by zero - This bug occurs when attempting to divide a number by zero, resulting in an arithmetic error.",
            "IllegalMonitorStateException: Object not locked by current thread - This bug occurs when trying to manipulate a monitor (lock) that is not held by the current thread.",
            "UnsupportedOperationException: Operation not supported - This bug occurs when trying to perform an unsupported operation on a specific object or data structure.",
            "Deadlock: Two or more threads waiting indefinitely for each other to release resources - This bug occurs when multiple threads are stuck waiting for each other's resources, resulting in a system deadlock.",
            "FileNotFoundException: File or directory not found - This bug occurs when trying to access a file or directory that does not exist.",
            "BufferOverflowException: Buffer capacity exceeded - This bug occurs when trying to write more data to a buffer than its capacity allows, resulting in a buffer overflow.",
            "SecurityException: Security violation - This bug occurs when a security policy is violated, such as accessing restricted resources or performing unauthorized operations.",
            "AssertionError: Unexpected condition - This bug occurs when an assertion check fails, indicating an unexpected condition or incorrect assumption in the code.",
            "NoSuchFieldError: Field not found - This bug occurs when trying to access a field that does not exist in a class, typically due to a mismatch in the version or configuration of libraries or dependencies.",
            "NullPointerException: Attempt to invoke a method on a null object reference - This bug occurs when trying to call a method on an object that is null, resulting in a runtime error.",
            "IllegalArgumentException: Invalid enum constant - This bug occurs when trying to assign an invalid value to an enumeration constant.",
            "OutOfMemoryError: PermGen space - This bug occurs when the PermGen space, used for storing class metadata, is exhausted.",
            "NoSuchAlgorithmException: Algorithm not available - This bug occurs when trying to use a cryptographic algorithm that is not available on the current platform or environment.",
            "NumberFormatException: Invalid input for radix conversion - This bug occurs when trying to convert a string to a number using an invalid radix value.",
            "StackOverflowError: Infinite recursion - This bug occurs when a recursive function does not have a proper termination condition, causing an infinite loop.",
            "ArrayStoreException: Incompatible type assignment - This bug occurs when trying to store an object of an incompatible type in an array.",
            "IllegalStateException: Operation not allowed in the current context - This bug occurs when trying to perform an operation that is not allowed in the current program state.",
            "DateTimeParseException: Unable to parse date/time - This bug occurs when trying to parse a string into a date or time format that does not match the expected pattern."
        )

        val bugArticles2 = ArrayList<BugArticle>()
        for (i in 0..20) {
            bugArticles2.add(
                BugArticle(
                    id = i,
                    previewImage = "https://discuss.tvm.apache.org/uploads/default/original/2X/e/e63794720957c1cb4cb42d669049fa16ffb879d6.png",
                    title = bugDescriptions[i],
                    description = bugDescriptions[i+1],
                    author = ArticleAuthor(
                        id = i,
                        firstName = "Saydullin",
                        lastName = "Sady",
                        middleName = "Say",
                        userName = "Saydullin",
                        nickName = "Saydullin",
                        profileImageUrl = "https://miro.medium.com/v2/resize:fit:1400/1*vQXhQFnWmJNu1KfLfHwRlw.png",
                        useful = 198,
                        answers = 8,
                        tags = listOf(
                            ArticleTag(0, "android"),
                            ArticleTag(1, "kotlin"),
                            ArticleTag(2, "coroutines"),
                        ),
                        registrationDate = 0,
                        updatedDate = 0,
                    ),
                    isFixed = false,
                    isDeprecated = false,
                    bugStatus = BugStatus.OPEN,
                    views = Random.nextInt(523, 721),
                    answers = List(Random.nextInt(2, 58)) { BugAnswersArticle(
                        id = i,
                        description = "",
                        repliedTo = 0,
                    ) },
                    tags = listOf(
                        ArticleTag(0, "android"),
                        ArticleTag(0, "kotlin"),
                        ArticleTag(0, "coroutines"),
                    ),
                    useful = Random.nextInt(3, 340),
                    publishedDate = 0,
                    updatedDate = 0,
                )
            )
        }
        return Resource.Success(bugArticles2)
    }

    override suspend fun saveBugArticles(articles: List<BugArticle>): Resource<Unit> {
        TODO("Not yet implemented")
    }

}


