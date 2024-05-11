package com.saydullin.codehub.presentation.util

import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.model.bug.BugStatusType

class BugStatusText {

    companion object {

        fun getText(bugStatusType: BugStatusType): Int {
            return when(bugStatusType) {
                BugStatusType.OPEN -> {
                    R.string.bug_status_open
                }
                BugStatusType.SOLVED -> {
                    R.string.bug_status_solved
                }
                BugStatusType.CLOSED -> {
                    R.string.bug_status_closed
                }
            }
        }

    }

}