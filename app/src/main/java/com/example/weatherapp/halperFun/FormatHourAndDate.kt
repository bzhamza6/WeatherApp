package com.example.weatherapp.halperFun

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * 🟢 FormatHourAndDate
 * Utility class that contains helper functions for formatting time and date.
 *
 * This class is used to convert API date/time strings into user-friendly formats
 * for display in the UI (e.g., converting "2025-09-12 15:00" → "3 PM").
 */
class FormatHourAndDate {

    /**
     * Converts a full date-time string (yyyy-MM-dd HH:mm)
     * into a short hour format (e.g., "3 PM").
     *
     * Example:
     * Input:  "2025-09-12 15:00"
     * Output: "3 PM"
     */
    fun formatHour(time: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val outputFormat = SimpleDateFormat("h a", Locale.getDefault())

        val date = inputFormat.parse(time)
        return if (date != null) outputFormat.format(date) else ""
    }

    /**
     * Converts a date string (yyyy-MM-dd)
     * into the day name (e.g., "Monday", "Friday").
     *
     * Example:
     * Input:  "2025-09-12"
     * Output: "Friday"
     */
    fun getDayName(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("EEEE", Locale.getDefault())

        val date = inputFormat.parse(dateString)
        return if (date != null) outputFormat.format(date) else ""
    }
}
