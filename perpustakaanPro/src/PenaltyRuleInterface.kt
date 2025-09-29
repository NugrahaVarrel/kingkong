interface PenaltyRuleInterface {
    fun hitungDenda(hariTelat: Long): Int
}

class SiswaRuleInterface : PenaltyRuleInterface {
    override fun hitungDenda(hariTelat: Long) = (hariTelat * 1000).toInt()
}
class GuruRuleInterface  : PenaltyRuleInterface {
    override fun hitungDenda(hariTelat: Long) = (hariTelat * 500).toInt()
}
