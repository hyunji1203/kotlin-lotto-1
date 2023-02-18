package domain

class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == 6) { INPUT_LOTTO_SIZE_ERROR_MESSAGE }
        require(numbers.toSet().size == 6) { INPUT_LOTTO_DUPLICATE_ERROR_MESSAGE }
    }

    fun countMatchNumber(lotto: Lotto): Int {
        return numbers.filter { lotto.numbers.contains(it) }.size
    }

    fun hasBonusNumber(bonusNumber: BonusNumber): Boolean {
        return numbers.contains(LottoNumber.from(bonusNumber.number))
    }

    fun matchLotto(lotto: Lotto, bonusNumber: BonusNumber): Rank? =
        Rank.valueOf(countMatchNumber(lotto), hasBonusNumber(bonusNumber))

    companion object {
        const val INPUT_LOTTO_SIZE_ERROR_MESSAGE = "당첨 번호가 6개가 아닙니다"
        const val INPUT_LOTTO_DUPLICATE_ERROR_MESSAGE = "당첨 번호가 중복되었습니다."
    }
}
