package com.proptit.budgetbuddy.domain.model

class IconSectionItem(private val section: Int, private val iconUrl: String) : IconSection {
    override fun type(): Int = IconSection.ITEM

    override fun sectionHeaderPosition(): Int = section
    override fun getAttribute(): String = iconUrl
}