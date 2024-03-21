package com.proptit.budgetbuddy.domain.model

class IconSectionHeader(private val section: Int, private val title: String) : IconSection {
    override fun type(): Int = IconSection.HEADER

    override fun sectionHeaderPosition(): Int = section
    override fun getAttribute(): String = title
}