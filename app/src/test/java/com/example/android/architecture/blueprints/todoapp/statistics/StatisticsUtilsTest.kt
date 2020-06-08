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
}