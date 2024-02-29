import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun cardType1() {
        val card = "VK Pay"
        val amountOfPreviousTransfers = 1_000
        val transferAmount = 16_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun cardType2() {
        val card = "VK Pay"
        val amountOfPreviousTransfers = 100_000
        val transferAmount = 16_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals("Карта заблокирована", result)
    }

    @Test
    fun cardType3() {
        val card = "Mastercard"
        val amountOfPreviousTransfers = 100_000
        val transferAmount = 160_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals("Карта заблокирована", result)
    }

    @Test
    fun cardType4() {
        val card = "Mastercard"
        val amountOfPreviousTransfers = 1_000_000
        val transferAmount = 160_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals("Карта заблокирована", result)
    }

    @Test
    fun cardType5() {
        val card = "Maestro"
        val amountOfPreviousTransfers = 1_000_000
        val transferAmount = 160_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals("Карта заблокирована", result)
    }

    @Test
    fun cardType6() {
        val card = "Visa"
        val amountOfPreviousTransfers = 1_000_000
        val transferAmount = 160_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals("Карта заблокирована", result)
    }

    @Test
    fun cardType7() {
        val card = "Мир"
        val amountOfPreviousTransfers = 1_000_000
        val transferAmount = 160_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals("Карта заблокирована", result)
    }

    @Test
    fun cardType8() {
        val card = "Mastercard"
        val amountOfPreviousTransfers = 80_000
        val transferAmount = 10_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(80.0, result)
    }

    @Test
    fun cardType9() {
        val card = "Maestro"
        val amountOfPreviousTransfers = 80_000
        val transferAmount = 10_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(80.0, result)
    }


    @Test
    fun cardType10() {
        val card = "Mastercard"
        val amountOfPreviousTransfers = 70_000
        val transferAmount = 10_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(50.0, result)
    }

    @Test
    fun cardType11() {
        val card = "Maestro"
        val amountOfPreviousTransfers = 70_000
        val transferAmount = 10_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(50.0, result)
    }

    @Test
    fun cardType12() {
        val card = "Mastercard"
        val amountOfPreviousTransfers = 70_000
        val transferAmount = 1_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun cardType13() {
        val card = "Maestro"
        val amountOfPreviousTransfers = 70_000
        val transferAmount = 1_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun cardType14() {
        val card = "Visa"
        val amountOfPreviousTransfers = 10_000
        val transferAmount = 1_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(35, result)
    }

    @Test
    fun cardType15() {
        val card = "Мир"
        val amountOfPreviousTransfers = 10_000
        val transferAmount = 1_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(35, result)
    }

    @Test
    fun cardType16() {
        val card = "VK Pay"
        val amountOfPreviousTransfers = 10_000
        val transferAmount = 1_000
        val result = cardType(card, amountOfPreviousTransfers, transferAmount)
        assertEquals(0, result)
    }


}