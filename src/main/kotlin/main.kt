fun main() {
    //print(cardType("VK Pay", 1_000, 16_000)) //result = Карта заблокирована
    //print(cardType("VK Pay", 100_000, 16_000)) //result = Карта заблокирована
    //print(cardType("Mastercard", 100_000, 160_000)) //result = Карта заблокирована
    //print(cardType("Mastercard", 1_000_000, 160_000)) //result = Карта заблокирована
    //print(cardType("Mastercard", 80_000, 10_000)) //result = 80.0
    //print(cardType("Mastercard", 70_000, 10_000)) //result = 50.0
    //print(cardType("Mastercard", 70_000, 1_000)) //result = 0
    print(cardType("VK Pay", 10_000, 1_000)) //result = 0

}

fun cardType(card: String = "VK Pay", amountOfPreviousTransfers: Int = 0, transferAmount: Int): Any {
    val maximumTransferDayCard = 150_000
    val maximumTransferMonthCard = 600_000

    val maximumTransferDayBill = 15_000
    val maximumTransferMonthBill = 40_000

    if ((card == "VK Pay" && ((amountOfPreviousTransfers + transferAmount) > maximumTransferMonthBill || transferAmount > maximumTransferDayBill)) ||
        ((card == "Mastercard" || card == "Maestro" || card == "Visa" || card == "Мир") && ((amountOfPreviousTransfers + transferAmount) > maximumTransferMonthCard || transferAmount > maximumTransferDayCard))
    ) {
        return "Карта заблокирована"
    } else {
        val commission = when {
            // Mastercard и Maestro
            (card == "Mastercard" || card == "Maestro") &&
                    amountOfPreviousTransfers > 75_000 -> (0.006 * transferAmount + 20)

            (card == "Mastercard" || card == "Maestro") &&
                    (amountOfPreviousTransfers > 300 && amountOfPreviousTransfers <= 75_000) &&
                    (amountOfPreviousTransfers + transferAmount) > 75_000 -> (0.006 * ((amountOfPreviousTransfers + transferAmount) - 75_000) + 20)

            (card == "Mastercard" || card == "Maestro") &&
                    (amountOfPreviousTransfers > 300 && amountOfPreviousTransfers <= 75_000) &&
                    ((amountOfPreviousTransfers + transferAmount) > 300 && (amountOfPreviousTransfers + transferAmount) <= 75_000) -> 0

            //Visa и Мир
            (card == "Visa" || card == "Мир") -> (if (0.0075 * transferAmount < 35) 35 else (0.0075 * transferAmount))

            else -> 0
        }
        return commission
    }
}