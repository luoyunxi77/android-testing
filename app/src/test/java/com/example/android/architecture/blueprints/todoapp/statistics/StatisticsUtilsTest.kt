package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Given
        val tasks = listOf(Task("title", "desc", isCompleted = false))

        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)

        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        // Given
        val tasks = listOf(Task("title", "desc", isCompleted = true))

        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedAndThreeActive_returnsFortyAndSixty() {
        // Given
        val tasks = listOf(
                Task("title1", "desc1", isCompleted = true),
                Task("title2", "desc2", isCompleted = true),
                Task("title3", "desc3", isCompleted = false),
                Task("title4", "desc4", isCompleted = false),
                Task("title5", "desc5", isCompleted = false)
        )

        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZeros() {
        // When there's an error loading stats
        val result = getActiveAndCompletedStats(null)

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // When there are no tasks
        val result = getActiveAndCompletedStats(emptyList())

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}