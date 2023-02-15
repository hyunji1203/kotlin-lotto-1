package domain

class Lotto(val numbers: List<LottoNumber>?) {

    init {
        require(numbers != null) { INPUT_LOTTO_NULL_ERROR_MESSAGE }
        require(numbers.size == 6) { INPUT_LOTTO_SIZE_ERROR_MESSAGE }
        require(numbers.map { it.number }.toSet().size == 6) { INPUT_LOTTO_DUPLICATE_ERROR_MESSAGE }
    }

    companion object {
        const val INPUT_LOTTO_NULL_ERROR_MESSAGE = "당첨 번호가 입력되지 않았습니다."
        const val INPUT_LOTTO_SIZE_ERROR_MESSAGE = "당첨 번호가 6개가 아닙니다"
        const val INPUT_LOTTO_DUPLICATE_ERROR_MESSAGE = "당첨 번호가 중복되었습니다."
    }
}