package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    //Normal Item
    @Test
    fun `when the normal item is before sell date then quality should decrease`() {
        val expectedSellIn = 4
        val expectedQuality = 9
        val items = arrayOf<Item>(Item("Normal Item", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedSellIn, app.items[0].sellIn)
        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when the normal item quality is zero then quality should not be decreased`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Normal Item", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when the normal item sell date has passed then quality decrease twice`() {
        val expectedQuality = 1
        val items = arrayOf<Item>(Item("Normal Item", -1, 3))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when the normal item is on sell date then quality decrease twice`() {
        val expectedQuality = 1
        val items = arrayOf<Item>(Item("Normal Item", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when the normal item sell date has passed and quality is near min value then quality should stay at min value`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Normal Item", -1, 1))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    //Tests for Aged Brie
    @Test
    fun `when Aged Brie is before sell date, then quality should increase`() {
        val expectedQuality = 4
        val items = arrayOf<Item>(Item("Aged Brie", 4, 3))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Aged Brie is before sell date and at max quality, then quality shouldn't increase`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Aged Brie", 4, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Aged Brie is on sell date, then quality should increase twice`() {
        val expectedQuality = 5
        val items = arrayOf<Item>(Item("Aged Brie", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Aged Brie is on sell date and quality near max value, then quality shouldn't be more than max value`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Aged Brie", 0, 49))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Aged Brie is on sell date and quality hits max value, then quality should stay at max`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Aged Brie", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Aged Brie sell date has passed then quality should increase twice`() {
        val expectedQuality = 5
        val items = arrayOf<Item>(Item("Aged Brie", -1, 3))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Aged Brie sell date has passed and quality hits max value then quality should stay at max value`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Aged Brie", -1, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    //Tests Sulfuras
    @Test
    fun `when Sulfuras is before sell date then quality should stay same`() {
        val expectedQuality = 30
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 3, 30))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Sulfuras sell date has passed then quality should stay same`() {
        val expectedQuality = 30
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", -1, 30))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Sulfuras quality is updated then sellIn value should stay same `() {
        val expectedSellIn = 5
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 5, 30))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedSellIn, app.items[0].sellIn)
    }

    //Conjured Tests
    @Test
    fun `when Conjured is before sell date then quality should decrease twice`() {
        val expectedSellIn = 4
        val expectedQuality = 8
        val items = arrayOf<Item>(Item("Conjured Mana Cake", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedSellIn, app.items[0].sellIn)
        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Conjured is before sell date and quality is near min value then quality should be min value`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Conjured Mana Cake", 5, 1))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }


    @Test
    fun `when Conjured is on sell date and quality is near min value then quality should be min value`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Conjured Mana Cake", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Conjured is on sell date then quality should decrease twice faster than normal item`() {
        val expectedQuality = 1
        val items = arrayOf<Item>(Item("Conjured Mana Cake", 0, 5))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Conjured quality is min value then quality should stay as min value`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Conjured Mana Cake", 5, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    // Backstage Tests
    @Test
    fun `when Backstage sell date is 10+ days then quality should increase by one`() {
        val expectedQuality = 15
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 15, 14))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage sell date is 10+ days and quality is at max then quality should stay at max`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 15, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage quality is at max before sell date (10 days) then quality should stay at max`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 10, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage quality is at near max before sell date (10 days) then quality should increase to max`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage is before sell date (10 days) then quality should increase twice`() {
        val expectedQuality = 15
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 10, 13))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage sell date is close to 10 days limit then quality should increase twice`() {
        val expectedQuality = 14
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 11, 13))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage sell date is between 10 and 5 days bounds then quality should increase twice`() {
        val expectedQuality = 15
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 7, 13))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage sell date is close to 5 days limit then quality should increase by three`() {
        val expectedQuality = 15
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 6, 13))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage quality is at near max before sell date (5 days) then quality should increase to max`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 6, 48))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage quality is at max before sell date (5 days) then quality should stay at max`() {
        val expectedQuality = 50
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage sell date is between 5 and 0 days then quality should increase twice`() {
        val expectedQuality = 16
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 2, 13))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage is on sell date and quality is at max then quality should be set to 0`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage is on sell date and quality is greater than 0 then quality should be set to 0`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0, 30))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage is on sell date and quality is 0 then quality should be set to 0`() {
        val expectedQuality = 3
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }

    @Test
    fun `when Backstage is after sell date then quality should be set to 0`() {
        val expectedQuality = 0
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", -10, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(expectedQuality, app.items[0].quality)
    }
}


