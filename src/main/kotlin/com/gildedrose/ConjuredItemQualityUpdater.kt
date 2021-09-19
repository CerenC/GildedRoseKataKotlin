package com.gildedrose

class ConjuredItemQualityUpdater : ItemQualityUpdater() {

    override fun update(item: Item) {
        item.sellIn -= 1

        item.quality = decrease(item.quality, 2)
        if (item.sellIn < 0) {
            item.quality = decrease(item.quality, 2)
        }
    }
}