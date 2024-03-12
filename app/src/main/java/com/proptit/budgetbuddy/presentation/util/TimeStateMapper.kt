package com.proptit.budgetbuddy.presentation.util

import androidx.constraintlayout.motion.widget.MotionLayout
import com.proptit.budgetbuddy.R

object TimeStateMapper {
    val constraintSetIds = listOf(
        R.id.start,
        R.id.state01,
        R.id.state02,
        R.id.state03,
        R.id.state04,
        R.id.state05,
        R.id.state06,
        R.id.state07,
        R.id.state08,
        R.id.state09,
        R.id.state10,
        R.id.state11,
        R.id.state12,
        R.id.state13,
        R.id.state14,
        R.id.state15,
        R.id.state16,
        R.id.state17,
        R.id.state18,
        R.id.state19,
        R.id.state20,
        R.id.state21,
        R.id.state22,
        R.id.state23
    )

    fun getNextState(currentId: Int): Int {
        return constraintSetIds[(constraintSetIds.indexOf(currentId) + 1)]
    }
    fun getPreviouState(currentId: Int): Int {
        return constraintSetIds[(constraintSetIds.indexOf(currentId) -1)]
    }

    fun getPostion(id: Int): Int {
        return constraintSetIds.indexOf(id)
    }
    fun getState(pos: Int): Int {
        return constraintSetIds[pos]
    }

}