package domain

class Lotto(val numbers: List<Int>?) {

    init {
        require(numbers != null) { INPUT_LOTTO_NULL_ERROR_MESSAGE }
        require(numbers.size == 6) { INPUT_LOTTO_SIZE_ERROR_MESSAGE }
        require(numbers.toSet().size == 6) { INPUT_LOTTO_DUPLICATE_ERROR_MESSAGE }
        require(numbers.filter { number -> number in 1..45 }.size == 6) { INPUT_LOTTO_RANGE_ERROR_MESSAGE }
    }

    fun countMatchNumber(lotto: Lotto): Int {
        return numbers!!.filter { lotto.numbers!!.contains(it) }.size
    }

    fun hasBonusNumber(bonusNumber: BonusNumber): Boolean {
        return numbers!!.contains(bonusNumber.number)
    }

    fun matchLotto(lotto: Lotto, bonusNumber: BonusNumber): Rank =
        when (countMatchNumber(lotto)) {
            6 -> Rank.FIRST
            5 -> checkBonusNumber(bonusNumber)
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.MISS
        }

    fun checkBonusNumber(bonusNumber: BonusNumber): Rank {
        if (hasBonusNumber(bonusNumber)) return Rank.SECOND
        return Rank.THIRD
    }

    companion object {
        const val INPUT_LOTTO_NULL_ERROR_MESSAGE = "당첨 번호가 입력되지 않았습니다."
        const val INPUT_LOTTO_SIZE_ERROR_MESSAGE = "당첨 번호가 6개가 아닙니다"
        const val INPUT_LOTTO_DUPLICATE_ERROR_MESSAGE = "당첨 번호가 중복되었습니다."
        const val INPUT_LOTTO_RANGE_ERROR_MESSAGE = "당첨 번호는 1에서 45사이의 숫자여야 합니다."
    }
}
