package com.saydullin.codehub.presentation.util

import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.model.bug.BugStatus

class BugStatusText {

    companion object {

        fun getText(bugStatus: BugStatus): Int {
            return when(bugStatus) {
                BugStatus.OPEN -> {
                    R.string.bug_status_open
                }
                BugStatus.SOLVED -> {
                    R.string.bug_status_solved
                }
                BugStatus.CLOSED -> {
                    R.string.bug_status_closed
                }
            }
        }

    }

}