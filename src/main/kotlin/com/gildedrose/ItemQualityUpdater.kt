package com.gildedrose

import kotlin.math.max
import kotlin.math.min

abstract class ItemQualityUpdater {

    abstract fun update(item: Item)

    internal fun increase(quality: Int, value: Int = DEFAULT_QUALITY_DEGRADE_VALUE): Int {
        return min(MAX_QUALITY_VALUE, quality + value)
    }

    internal fun decrease(quality: Int, value: Int = DEFAULT_QUALITY_DEGRADE_VALUE): Int {
        return max(MIN_QUALITY_VALUE, quality - value)
    }

    companion object {
        private const val MIN_QUALITY_VALUE = 0
        private const val MAX_QUALITY_VALUE = 50
        private const val DEFAULT_QUALITY_DEGRADE_VALUE = 1
    }

}